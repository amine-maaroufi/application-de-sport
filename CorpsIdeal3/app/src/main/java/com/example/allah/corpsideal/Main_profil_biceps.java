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

public class Main_profil_biceps extends AppCompatActivity {
    private LinearLayout layout_biceps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_biceps);

        layout_biceps=(LinearLayout)findViewById(R.id.layout_biceps);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex1_flexion_biceps_debout_alternee);
        }
        else
        if(Vid.equals("2"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex2_flexion_biceps_debout_avec_barre);
        }
        else
        if(Vid.equals("3"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex3_traction_en_supination_a_la_barre_fixe);
        }
        else
        if(Vid.equals("4"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex4_flexio_des_avant_bras_a_la_poulie_basse);
        }
        else
        if(Vid.equals("5"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex5_flexion_alternee_avec_haltere_de_avant_bras_coude_cale_sur_la_cuisse);
        }
        else
        if(Vid.equals("6"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex6_flexion_alternee_des_avant_bras_ave_rotation_du_poignet_et_elevation_des_coudes);
        }
        else
        if(Vid.equals("7"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex7_flexion_des_avant_bras_a_la_poulie_haute);
        }
        else
        if(Vid.equals("8"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex8_flexion_des_avant_bras_avec_haltere_courts_en_position_dites_prise_marteau);
        }
        else
        if(Vid.equals("9"))
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex9_flexion_des_avant_bras_sur_machine);
        }
        else
        {
            layout_biceps.setBackgroundResource(R.drawable.biceps_ex10_flexion_des_avant_bras_a_labarre);
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
            Intent i =new Intent(Main_profil_biceps.this,Main_Menu.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_profil_biceps.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_biceps.this).create();
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
