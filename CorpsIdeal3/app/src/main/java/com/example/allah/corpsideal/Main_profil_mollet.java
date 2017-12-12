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

public class Main_profil_mollet extends AppCompatActivity {
    private LinearLayout layout_mollet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil_mollet);
        layout_mollet=(LinearLayout)findViewById(R.id.layout_mollet);
        Intent i = getIntent();
        String Vid = i.getStringExtra("id");
        if (Vid.equals("1"))
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex1_extension_des_mollets_debout);
        }
        else
        if(Vid.equals("2"))
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex2_extension_des_mollets_assis);
        }
        else
        if(Vid.equals("3"))
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex3_mollets_au_donkey);
        }
        else
        if(Vid.equals("4"))
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex4_extension_des_pieds_a_lamachine);
        }
        else
        if(Vid.equals("5"))
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex5_extensions_des_pieds_assis_a_la_machine);
        }
        else
        {
            layout_mollet.setBackgroundResource(R.drawable.mollet_ex6_extension_de_mollets_couche);
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
            Intent i =new Intent(Main_profil_mollet.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_profil_mollet.this).create();
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
