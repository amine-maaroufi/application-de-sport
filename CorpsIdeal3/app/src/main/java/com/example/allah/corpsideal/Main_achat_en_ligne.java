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

public class Main_achat_en_ligne extends AppCompatActivity implements ClassAddressIP{


    ListView listview;

    // liste JSONArray
    JSONArray liste_sites = null;

    public ArrayList<HashMap<String, String>> SitesList;
    private ProgressDialog pDialog;

    private static final String URL_LISTE_SITES = "http://"+ClassAddressIP.ip+"/admin/android/get_all_sites.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_LISTE = "site";
    private static final String TAG_TITRE = "Titre_site";
    private static final String TAG_URL = "URL";
    private static final String TAG_CATEGORIE = "Categr_produit";
    private static final String TAG_ENTREPRISE = "Entreprise";
    private static final String TAG_ID = "ID_site";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_achat_en_ligne);

        listview = (ListView) findViewById(R.id.listview_achat);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> listitem = SitesList.get(position);

                //recuperer les donnees de la position cliquee
                String titre = listitem.get(TAG_TITRE);
                String url = listitem.get(TAG_URL);
                String categorie = listitem.get(TAG_CATEGORIE);
               // String entrp = listitem.get(TAG_ENTREPRISE);


                //transferer les donnees vers l'activite détail
                Intent intent_detail = new Intent(getApplicationContext(), AchatDetailActivity.class);
                //intent_detail.putExtra(TAG_TITRE, titre);
                intent_detail.putExtra(TAG_URL, url);
               // intent_detail.putExtra(TAG_ENTREPRISE, entrp);
                //intent_detail.putExtra(TAG_CATEGORIE, categorie);

                //afficher activite detail
                startActivity(intent_detail);
            }
        });


        // recuperer sites in Background Thread
        new ListSitesAsync().execute();
    }



    //async arriere plan pour récuperer users
    class ListSitesAsync extends AsyncTask<String, String, JSONObject> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        JSONParser jsonParser = new JSONParser();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Main_achat_en_ligne.this);
            pDialog.setMessage("Recuperer liste sites ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        protected JSONObject doInBackground(String... args) {
            JSONObject json = null;
            try {
                HashMap<String, String> params = new HashMap<>();
                json = jsonParser.makeHttpRequest(URL_LISTE_SITES, "GET", params);
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
            SitesList = new ArrayList<HashMap<String, String>>();
            try {

                if (json != null) {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        // todos found
                        // Getting Array of todos
                        Log.v("TEST", "json = " + json.toString());

                        liste_sites = json.getJSONArray(TAG_LISTE);

                        // looping through All users
                        for (int i = 0; i < liste_sites.length(); i++) {
                            JSONObject c = liste_sites.getJSONObject(i);

                            // Storing each json item in variable
                            String titre = c.getString(TAG_TITRE);
                            String url = c.getString(TAG_URL);
                           // String entrp = c.getString(TAG_ENTREPRISE);
                            String id= c.getString(TAG_ID);
                            String categorie= c.getString(TAG_CATEGORIE);

                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            map.put(TAG_ID, id);
                            map.put(TAG_TITRE, titre);
                            map.put(TAG_URL, url);
                           // map.put(TAG_ENTREPRISE, entrp);
                            map.put(TAG_CATEGORIE,categorie);

                            // adding HashList to ArrayList
                            SitesList.add(map);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            SimpleAdapter adapter = new SimpleAdapter(
                    Main_achat_en_ligne.this, SitesList,
                    R.layout.list_item_achatenligne, new String[]{TAG_TITRE, TAG_CATEGORIE,},
                    new int[]{R.id.txtTitre, R.id.txtcatgr});

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
            Intent i =new Intent(Main_achat_en_ligne.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_achat_en_ligne.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_achat_en_ligne.this).create();
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
