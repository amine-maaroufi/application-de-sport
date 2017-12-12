package com.example.allah.corpsideal;

/**
 * Created by Allah on 29/04/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActualiteDetailActivity extends Activity {
    private static final String TAG_TITRE = "Titre_actualite";
    private static final String TAG_DATE = "Date_actualite";
    private static final String TAG_DESCRIPTION = "Description_actualite";
    private static final String TAG_Reference = "Reference_actualite";

    EditText edTitre,edDate,edDesc,edRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__actualite_detail);

        edTitre=(EditText) findViewById(R.id.edTitre_act);
        edDate=(EditText) findViewById(R.id.edDate_act);
        edDesc=(EditText) findViewById(R.id.edDesc_act);
        edRef=(EditText) findViewById(R.id.edRef_act);

        //recuperer intent
        //puis recuperer les donnees venant avec l'intent
        //et les afficher dans les textview

        edTitre.setText(getIntent().getStringExtra(TAG_TITRE));
        edDate.setText(getIntent().getStringExtra(TAG_DATE));
        edDesc.setText(getIntent().getStringExtra(TAG_DESCRIPTION));
        edRef.setText(getIntent().getStringExtra(TAG_Reference));


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
            Intent i =new Intent(ActualiteDetailActivity.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(ActualiteDetailActivity.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(ActualiteDetailActivity.this).create();
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
