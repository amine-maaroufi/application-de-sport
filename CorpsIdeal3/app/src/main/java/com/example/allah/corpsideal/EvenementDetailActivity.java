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
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EvenementDetailActivity extends Activity {
    private static final String TAG_TITRE = "Titre_evenement";
    private static final String TAG_DATE = "Date_evenement";
    private static final String TAG_Heure = "Heure_evenement";
    private static final String TAG_DESCRIPTION = "Description_evenement";
    private static final String TAG_Adresse = "Adresse_evenement";
    private static final String TAG_Organiseur = "Organiseur";

    EditText edtitre, eddate, edheure,eddesc, edorg, edadr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__evenement_detail);

        edtitre=(EditText) findViewById(R.id.edtitre_event);
        eddate=(EditText) findViewById(R.id.eddate_event);
        edheure=(EditText) findViewById(R.id.edheure_event);
        eddesc=(EditText) findViewById(R.id.eddesc_event);
        edorg=(EditText) findViewById(R.id.edorg_event);
        edadr=(EditText)findViewById(R.id.edadr_event);

        //recuperer intent
        //puis recuperer les donnees venant avec l'intent
        //et les afficher dans les edittext

        edtitre.setText(getIntent().getStringExtra(TAG_TITRE));
        eddate.setText(getIntent().getStringExtra(TAG_DATE));
        edheure.setText(getIntent().getStringExtra(TAG_Heure));
        eddesc.setText(getIntent().getStringExtra(TAG_DESCRIPTION));
        edadr.setText(getIntent().getStringExtra(TAG_Adresse));
        edorg.setText(getIntent().getStringExtra(TAG_Organiseur));


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
            Intent i =new Intent(EvenementDetailActivity.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(EvenementDetailActivity.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(EvenementDetailActivity.this).create();
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
