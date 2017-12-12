package com.example.allah.corpsideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_Menu extends AppCompatActivity implements View.OnClickListener {
    private Button btn_entrainer,btn_regime,btn_event,btn_act,btn_salle,btn_charge,btn_caractr,btn_achat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        btn_entrainer=(Button)findViewById(R.id.btn_entrainer);
        btn_entrainer.setOnClickListener(this);
        btn_regime=(Button)findViewById(R.id.btn_regime);
        btn_regime.setOnClickListener(this);
        btn_caractr=(Button)findViewById(R.id.btn_caract);
        btn_caractr.setOnClickListener(this);
        btn_event=(Button)findViewById(R.id.btn_event);
        btn_event.setOnClickListener(this);
        btn_act=(Button)findViewById(R.id.btn_act);
        btn_act.setOnClickListener(this);
        btn_salle=(Button)findViewById(R.id.btn_salle);
        btn_salle.setOnClickListener(this);
        btn_charge=(Button)findViewById(R.id.btn_charge);
        btn_charge.setOnClickListener(this);
        btn_achat=(Button)findViewById(R.id.btn_achat);
        btn_achat.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

//For 3G check
        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
//For WiFi Check
        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();


       if(v.getId()==btn_entrainer.getId())
        {
            Intent i = new Intent(Main_Menu.this,Main_Corps_Humain.class);
            startActivity(i);
        }
        else
        if(v.getId()==btn_regime.getId())
        {

            if (!is3g && !isWifi)
            {
                Toast.makeText(getApplicationContext(),"Pas de connexion Internet ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Main_Menu.this,Main_recette.class);
                startActivity(i);
            }

        }
        else
        if(v.getId()==btn_salle.getId())
        {
            if (!is3g && !isWifi)
            {
                Toast.makeText(getApplicationContext(),"Pas de connexion Internet  ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Main_Menu.this,MapsActivity.class);
                startActivity(i);
            }

        }
        else
        if(v.getId()==btn_act.getId())
        {
            if (!is3g && !isWifi)
            {
                Toast.makeText(getApplicationContext(),"Pas de connexion Internet ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Main_Menu.this,Main_actualite.class);
                startActivity(i);
            }

        }
        else
        if(v.getId()==btn_event.getId())
        {


            if (!is3g && !isWifi)
            {
                Toast.makeText(getApplicationContext(),"Pas de connexion Internet ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Main_Menu.this,Main_evenement.class);
                startActivity(i);
            }
        }
        else
        if(v.getId()==btn_charge.getId())
        {
            Intent i = new Intent(Main_Menu.this,Main_charge_financiere.class);
            startActivity(i);
        }
        else
        if(v.getId()==btn_caractr.getId())
        {
            Intent i = new Intent(Main_Menu.this,Main_caraterestiques_corporelle.class);
            startActivity(i);
        }
        else
        {
            if (!is3g && !isWifi)
            {
                Toast.makeText(getApplicationContext(),"Pas de connexion Internet ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent i = new Intent(Main_Menu.this,Main_achat_en_ligne.class);
                startActivity(i);
            }

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
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_Menu.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_Menu.this).create();
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
