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

public class Main_profil_dorsaux extends AppCompatActivity {
private LinearLayout layout_dorsaux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_dorsaux);

        layout_dorsaux=(LinearLayout)findViewById(R.id.layout_dorsaux);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex1_tirage_avec_haltere);
        }
        else
        if(Vid.equals("2"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex2_tirage_nuque);
        }
        else
        if(Vid.equals("3"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex3_tractions_a_la_barre_fixe);
        }
        else
        if(Vid.equals("4"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex4_tirage_a_la_poulie_basse);
        }
        else
        if(Vid.equals("5"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex5_tirage_bras_tendus_a_la_poulie_haute);
        }
        else
        if(Vid.equals("6"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex6_tirage_honrizontal);
        }
        else
        if(Vid.equals("7"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex7_tirage_vertical_a_la_barre_main_serrees);
        }
        else
        if(Vid.equals("8"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex8_traction_a_la_poulie_haute_tirage_a_la_poitrine);
        }
        else
        if(Vid.equals("9"))
        {
            layout_dorsaux.setBackgroundResource(R.drawable.dorsaux_ex9_tirage_nuque_a_la_poulie_haute);
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
            Intent i =new Intent(Main_profil_dorsaux.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_profil_dorsaux.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_dorsaux.this).create();
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
