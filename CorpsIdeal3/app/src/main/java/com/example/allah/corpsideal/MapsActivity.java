package com.example.allah.corpsideal;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,ClassAddressIP{

    private GoogleMap mMap;


    JSONArray liste_salles = null;

    public ArrayList<HashMap<String, String>> SalleList;
    private ProgressDialog pDialog;
    ArrayList <String>salle=new ArrayList<String>();
    private static final String URL_LISTE_SALLES = "http://"+ClassAddressIP.ip+"/admin/android/get_all_salles.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_LISTE = "salle";
    private static final String TAG_TITRE = "Titre";
    private static  String TAG_LATITUDE = "Latitude";
    private static  String TAG_LONGITUDE = "Longitude";
    private static final String TAG_ADRESSE = "Adresse";
    private static  String TAG_TEL = "Tel";
    private static final String TAG_ID = "ID_salle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);


    }

   /* @Override
    public boolean onMarkerClick(Marker marker) {

        Log.i("MapsActivity", "onMarkerClick");
        Toast.makeText(getApplicationContext(),
                "Marker Clicked: " + marker.getTitle(), Toast.LENGTH_LONG)
                .show();
        return false;
    }*/

    class ListSallesAsync extends AsyncTask<String, String, JSONObject> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        JSONParser jsonParser = new JSONParser();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MapsActivity.this);
            pDialog.setMessage("Recuperer liste des salles ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        protected JSONObject doInBackground(String... args) {
            JSONObject json = null;
            try {
                HashMap<String, String> params = new HashMap<>();
                json = jsonParser.makeHttpRequest(URL_LISTE_SALLES, "GET", params);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return json;
        }

        protected void onPostExecute(JSONObject json) {


            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }


            // Hashmap for ListView
            SalleList = new ArrayList<HashMap<String, String>>();
            try {

                if (json != null) {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        // todos found
                        // Getting Array of todos
                        Log.v("TEST", "json = " + json.toString());

                        liste_salles = json.getJSONArray(TAG_LISTE);

                        // looping through All users
                        for (int i = 0; i < liste_salles.length(); i++) {
                            JSONObject c = liste_salles.getJSONObject(i);

                            // Storing each json item in variable
                            String lat = c.getString(TAG_LATITUDE);
                            String log = c.getString(TAG_LONGITUDE);
                           // String adr = c.getString(TAG_ADRESSE);
                           // String tel = c.getString(TAG_TEL);

                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value

                            map.put(TAG_LATITUDE, lat);
                            map.put(TAG_LONGITUDE, log);
                            //map.put(TAG_ADRESSE, adr);
                            //map.put(TAG_TEL, tel);
                            // adding HashList to ArrayList
                            SalleList.add(map);

                            double lattitude = Double.parseDouble(lat);
                            double longitude = Double.parseDouble(log);
                            LatLng salle = new LatLng(lattitude,longitude);


                            mMap.addMarker(new MarkerOptions()
                                    .title(c.getString(TAG_TITRE))
                                    .position(salle)
                                    .snippet("Adresse: " + c.getString(TAG_ADRESSE)));
                           // + "TEL: " + c.getString(TAG_TEL))
                                    //.icon(BitmapDescriptorFactory.fromResource(R.drawable.flag))


                        }


                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap = googleMap;


        new ListSallesAsync().execute();

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }


        // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        if(location!=null){
// Getting latitude of the current location
            double latitude = location.getLatitude();

            // Getting longitude of the current location
            double longitude = location.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude, longitude);

            // Showing the current location in Google Map
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // Zoom in the Google Map
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }


    }


}
