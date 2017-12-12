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

public class Main_Mollet extends AppCompatActivity {
private ListView ListView_mollet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__mollet);

        ListView_mollet = (ListView)findViewById(R.id.listmollet);
        final ArrayList<HashMap<String,String>> malistArray = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> Map;
        //remplir le premier item
        Map = new HashMap<String,String>();
        Map.put("titre","Extension des mollets débout");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img",String.valueOf(R.drawable.mollets));
        Map.put("id","1");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Extension des mollets assis");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img", String.valueOf(R.drawable.mollets));
        Map.put("id","2");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Mollets au donkey");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img",String.valueOf(R.drawable.mollets));
        Map.put("id","3");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Extension des pieds debout à la machine");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img",String.valueOf(R.drawable.mollets));
        Map.put("id","4");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Extension des pieds assis à la machine");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img",String.valueOf(R.drawable.mollets));
        Map.put("id","5");
        malistArray.add(Map);

        Map = new HashMap<String,String>();
        Map.put("titre", "Extension de mollets couché");
        Map.put("desc","Nombre de répétition par série:8-10-12");
        Map.put("img",String.valueOf(R.drawable.mollets));
        Map.put("id","6");
        malistArray.add(Map);


        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),malistArray,R.layout.items_organes,new String[]{"img","titre","desc"},
                new int[]{R.id.img,R.id.titre,R.id.desc});

        ListView_mollet.setAdapter(adapter);

        ListView_mollet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> Map = (HashMap<String, String>) ListView_mollet.getItemAtPosition(position);
                String Vid = Map.get("id");

                Intent i = new Intent(Main_Mollet.this,Main_profil_mollet.class);
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
            Intent i =new Intent(Main_Mollet.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_Mollet.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_Mollet.this).create();
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
