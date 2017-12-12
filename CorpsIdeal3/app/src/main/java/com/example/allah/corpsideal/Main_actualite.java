package com.example.allah.corpsideal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main_actualite extends AppCompatActivity implements ClassAddressIP {



    ListView listview;

    // liste JSONArray
    JSONArray liste_actualites = null;

    public ArrayList<HashMap<String, String>> ActualitesList;
    private ProgressDialog pDialog;

    private static final String URL_LISTE_ACTUALITES = "http://"+ClassAddressIP.ip+"/admin/android/get_all_actualites.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_LISTE = "actualite";
    private static final String TAG_TITRE = "Titre_actualite";
    private static final String TAG_DATE = "Date_actualite";
    private static final String TAG_DESCRIPTION = "Description_actualite";
    private static final String TAG_Reference = "Reference_actualite";
    private static final String TAG_ID = "ID_actualite";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualite);

        listview = (ListView) findViewById(R.id.listview_actualite);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> listitem = ActualitesList.get(position);

                //recuperer les donnees de la position cliquee
                String titre = listitem.get(TAG_TITRE);
                String date = listitem.get(TAG_DATE);
                String desc = listitem.get(TAG_DESCRIPTION);
                String ref = listitem.get(TAG_Reference);

                //transferer les donnees vers l'activite détail
                Intent intent_detail = new Intent(getApplicationContext(), ActualiteDetailActivity.class);
                intent_detail.putExtra(TAG_TITRE, titre);
                intent_detail.putExtra(TAG_DATE, date);
                intent_detail.putExtra(TAG_DESCRIPTION, desc);
                intent_detail.putExtra(TAG_Reference, ref);

                //afficher activite detail
                startActivity(intent_detail);
            }
        });


        // recuperer actualites in Background Thread
        new ListActualitesAsync().execute();
    }



    //async arriere plan pour récuperer users
    class ListActualitesAsync extends AsyncTask<String, String, JSONObject> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        JSONParser jsonParser = new JSONParser();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Main_actualite.this);
            pDialog.setMessage("Recuperer liste Actualités ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        protected JSONObject doInBackground(String... args) {
            JSONObject json = null;
            try {
                HashMap<String, String> params = new HashMap<>();
                json = jsonParser.makeHttpRequest(URL_LISTE_ACTUALITES, "GET", params);
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
            ActualitesList = new ArrayList<HashMap<String, String>>();
            try {

                if (json != null) {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        // todos found
                        // Getting Array of todos
                        Log.v("TEST", "json = " + json.toString());

                        liste_actualites = json.getJSONArray(TAG_LISTE);

                        // looping through All users
                        for (int i = 0; i < liste_actualites.length(); i++) {
                            JSONObject c = liste_actualites.getJSONObject(i);

                            // Storing each json item in variable
                            String titre = c.getString(TAG_TITRE);
                            String date = c.getString(TAG_DATE);
                            String id= c.getString(TAG_ID);
                            String desc= c.getString(TAG_DESCRIPTION);
                            String ref= c.getString(TAG_Reference);

                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            map.put(TAG_ID, id);
                            map.put(TAG_TITRE, titre);
                            map.put(TAG_DATE, date);
                            map.put(TAG_DESCRIPTION,desc);
                            map.put(TAG_Reference,ref);

                            // adding HashList to ArrayList
                            ActualitesList.add(map);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            SimpleAdapter adapter = new SimpleAdapter(
                    Main_actualite.this, ActualitesList,
                    R.layout.list_item_atualite, new String[]{TAG_TITRE, TAG_DATE},
                    new int[]{R.id.txtTitre, R.id.txtDate});

            listview.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_actualite.this,Main_Menu.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_actualite.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_actualite.this).create();
            alertDialog.setTitle("à propos");
            alertDialog.setView(formElementsView);
           /* alertDialog.setMessage(" cette application permettre ");*/
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
