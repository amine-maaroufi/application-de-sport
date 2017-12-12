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
import android.widget.LinearLayout;

public class Main_profil_epaule extends AppCompatActivity {
   private LinearLayout layout_epaule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_epaule);
        layout_epaule=(LinearLayout)findViewById(R.id.layout_epaule);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex1_developpe_derriere_la_nuque);
        }
        else
        if(Vid.equals("2"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex2_elevation_laterale_buste_plenche);
        }
        else
        if(Vid.equals("3"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex3_tirage_vertical_a_la_barre);
        }
        else
        if(Vid.equals("4"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex4_developpe_assis_avec_haltere_dans_chaque_main);
        }
        else
        if(Vid.equals("5"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex5_developpe_deriere_la_nuque_a_la_barre);
        }
        else
        if(Vid.equals("6"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex6_elevation_alternee_en_avant_avec_halteres_courts);
        }
        else
        if(Vid.equals("7"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex7_elevation_laterale_a_la_machine);
        }
        else
        if(Vid.equals("8"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex8_elevation_laterale_a_la_poulie_basse_buste_penche_en_avant);
        }
        else
        if(Vid.equals("9"))
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex9_elevation_laterale_alternee_a_la_poulie_basse);
        }
        else
        {
            layout_epaule.setBackgroundResource(R.drawable.epaule_ex10_elevations_laterales_des_bras_avec_halteres);
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
            Intent i =new Intent(Main_profil_epaule.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_profil_epaule.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_epaule.this).create();
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
