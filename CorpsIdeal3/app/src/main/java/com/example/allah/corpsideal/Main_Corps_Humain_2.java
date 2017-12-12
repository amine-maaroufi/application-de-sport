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
import android.widget.Button;

public class Main_Corps_Humain_2 extends AppCompatActivity implements View.OnClickListener {
    private Button btn_cou,btn_triceps,btn_dorsaux,btn_lambaire,btn_fessiers,btn_mollet,btn_epaule,btn_retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__corps__humain_2);

        btn_cou=(Button)findViewById(R.id.btn_cou);
        btn_cou.setOnClickListener(this);

        btn_triceps=(Button)findViewById(R.id.btn_triceps);
        btn_triceps.setOnClickListener(this);
        btn_lambaire=(Button)findViewById(R.id.btn_lambaire);
        btn_lambaire.setOnClickListener(this);
        btn_dorsaux=(Button)findViewById(R.id.btn_dorsaux);
        btn_dorsaux.setOnClickListener(this);
        btn_fessiers=(Button)findViewById(R.id.btn_fessiers);
        btn_fessiers.setOnClickListener(this);
        btn_mollet=(Button)findViewById(R.id.btn_mollet);
        btn_mollet.setOnClickListener(this);
        btn_epaule=(Button)findViewById(R.id.btn_epaule);
        btn_epaule.setOnClickListener(this);
        btn_retour=(Button)findViewById(R.id.btn_retour);
        btn_retour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==btn_cou.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Cou.class);
            startActivity(i);

        }

        if(v.getId()==btn_triceps.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Triceps.class);
            startActivity(i);

        }

        if(v.getId()==btn_dorsaux.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Dorsaux.class);
            startActivity(i);

        }

        if(v.getId()==btn_fessiers.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Fessiers.class);
            startActivity(i);

        }

        if(v.getId()==btn_lambaire.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Lombaire.class);
            startActivity(i);

        }

        if(v.getId()==btn_mollet.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Mollet.class);
            startActivity(i);

        }

        if(v.getId()==btn_epaule.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Epaule.class);
            startActivity(i);

        }

        if(v.getId()==btn_retour.getId())
        {
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Corps_Humain.class);
            startActivity(i);

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
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Menu.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_Corps_Humain_2.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_Corps_Humain_2.this).create();
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
