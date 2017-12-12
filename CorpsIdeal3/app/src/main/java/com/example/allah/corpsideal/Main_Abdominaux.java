package com.example.allah.corpsideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Main_Abdominaux extends AppCompatActivity {
    private ListView ListView_abdo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__abdominaux);

        ListView_abdo = (ListView)findViewById(R.id.listabdo);
        final ArrayList<HashMap<String,String>> malistArray = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> Map;
        //remplir le premier item
        Map = new HashMap<String,String>();
        Map.put("titre","Crunch");
        Map.put("desc","Nombre de répétion par série :8-10-12");
        Map.put("img",String.valueOf(R.drawable.abdominaux));
        Map.put("id","1");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Relevé de buste decliné");
        Map.put("desc","Nombre de répétion par série :8-10-12");
        Map.put("img", String.valueOf(R.drawable.abdominaux));
        Map.put("id","2");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Relevé de jambes");
        Map.put("desc","Nombre de répétion par série :8-10-12");
        Map.put("img",String.valueOf(R.drawable.abdominaux));
        Map.put("id","3");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Crunch à la machine");
        Map.put("desc","Nombre de répétion par série :8-10-12");
        Map.put("img",String.valueOf(R.drawable.abdominaux));
        Map.put("id","4");
        malistArray.add(Map);


        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),malistArray,R.layout.items_organes,new String[]{"img","titre","desc"},
                new int[]{R.id.img,R.id.titre,R.id.desc});

        ListView_abdo.setAdapter(adapter);

        ListView_abdo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> Map = (HashMap<String, String>) ListView_abdo.getItemAtPosition(position);
                String Vid = Map.get("id");

                Intent i = new Intent(Main_Abdominaux.this,Main_profil_abdominaux.class);
                i.putExtra("id",Vid);
                startActivity(i);


            }
        });
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
            Intent i =new Intent(Main_Abdominaux.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_Abdominaux.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_Abdominaux.this).create();
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
