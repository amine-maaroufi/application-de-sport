package com.example.allah.corpsideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main_Corps_Humain extends AppCompatActivity implements View.OnClickListener {
private Button btn_abdo,btn_quadriceps,btn_avantbras,btn_biceps,btn_oblique,btn_pectoraux,btn_undo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__corps__humain);
        btn_abdo=(Button)findViewById(R.id.btn_abdo);
        btn_abdo.setOnClickListener(this);
        btn_quadriceps=(Button)findViewById(R.id.btn_quadriceps);
        btn_quadriceps.setOnClickListener(this);
        btn_avantbras=(Button)findViewById(R.id.btn_avantbras);
        btn_avantbras.setOnClickListener(this);
        btn_biceps=(Button)findViewById(R.id.btn_biceps);
        btn_biceps.setOnClickListener(this);
        btn_oblique=(Button)findViewById(R.id.btn_oblique);
        btn_oblique.setOnClickListener(this);
        btn_pectoraux=(Button)findViewById(R.id.btn_pectoraux);
        btn_pectoraux.setOnClickListener(this);
        btn_undo=(Button)findViewById(R.id.btn_undo);
        btn_undo.setOnClickListener(this);


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
            Intent i =new Intent(Main_Corps_Humain.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_Corps_Humain.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



           AlertDialog alertDialog = new AlertDialog.Builder(Main_Corps_Humain.this).create();
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


    @Override
    public void onClick(View v) {
        if(v.getId()==btn_abdo.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Abdominaux.class);
            startActivity(i);

        }

        if(v.getId()==btn_quadriceps.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Quadriceps.class);
            startActivity(i);

        }

        if(v.getId()==btn_avantbras.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Avant_bras.class);
            startActivity(i);

        }

        if(v.getId()==btn_biceps.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Biceps.class);
            startActivity(i);

        }

        if(v.getId()==btn_oblique.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Oblique.class);
            startActivity(i);

        }

        if(v.getId()==btn_undo.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Corps_Humain_2.class);
            startActivity(i);

        }

        if(v.getId()==btn_pectoraux.getId())
        {
            Intent i =new Intent(Main_Corps_Humain.this,Main_Pectoraux.class);
            startActivity(i);

        }

    }
}
