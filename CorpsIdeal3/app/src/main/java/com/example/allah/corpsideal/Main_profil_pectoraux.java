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

public class Main_profil_pectoraux extends AppCompatActivity {
private LinearLayout layout_pectoraux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_pectoraux);


        layout_pectoraux=(LinearLayout)findViewById(R.id.layout_pectoraux);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex3_ecarte_couche_sur_banc);
        }
        else
        if(Vid.equals("2"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex1_developpe_decline_aux_halteres);
        }
        else
        if(Vid.equals("3"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex2_devoloppe_couche);
        }
        else
        if(Vid.equals("4"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex4_developpe_a_la_machine_convergente);
        }
        else
        if(Vid.equals("5"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex5_developpe_couche_avec_barre);
        }
        else
        if(Vid.equals("6"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex6_developpe_couche_avec_halteres);
        }
        else
        if(Vid.equals("7"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex7_developpe_incline_avec_halteres);
        }
        else
        if(Vid.equals("8"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex8_developpe_incline_avec_barre);
        }
        else
        if(Vid.equals("9"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex9_ecarte_a_la_machine);
        }
        else
        if(Vid.equals("10"))
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex10_ecarte_couche_avec_haltere);
        }
        else
        {
            layout_pectoraux.setBackgroundResource(R.drawable.pectoraux_ex11_pull_over);
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
            Intent i =new Intent(Main_profil_pectoraux.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_pectoraux.this).create();
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

