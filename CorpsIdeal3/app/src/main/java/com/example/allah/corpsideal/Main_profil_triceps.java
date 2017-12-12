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

public class Main_profil_triceps extends AppCompatActivity {
private LinearLayout layout_triceps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_triceps);


        layout_triceps=(LinearLayout)findViewById(R.id.layout_triceps);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex1_extension_des_avant_bras_a_la_barre_couche_sur_un_banc);
        }
        else
        if(Vid.equals("2"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex2_extension_des_avant_bras_un_altere_court_tenu_deux_a_mains);
        }
        else
        if(Vid.equals("3"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex3_repulsion_entre_deux_bancs);
        }
        else
        if(Vid.equals("4"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex4_extension_alternee_des_avant_bras_avec_un_haltere_le_buste_en_avant);
        }
        else
        if(Vid.equals("5"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex5_extension_des_avant_bras_a_la_poulie_haute_et_a_une_main);
        }
        else
        if(Vid.equals("6"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex6_extension_des_avant_bras_avec_halteres);
        }
        else
        if(Vid.equals("7"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex7_extension_verticale_des_bras_avec_haltere);
        }
        else
        if(Vid.equals("8"))
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex8_triceps_a_la_barre);
        }
        else
        {
            layout_triceps.setBackgroundResource(R.drawable.triceps_ex9_triceps_a_la_poulie_haute_et_a_deux_mains);
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
            Intent i =new Intent(this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_profil_triceps.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_triceps.this).create();
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
