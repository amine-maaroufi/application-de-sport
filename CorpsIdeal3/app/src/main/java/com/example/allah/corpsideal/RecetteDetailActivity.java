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

public class RecetteDetailActivity extends Activity {
    private static final String TAG_TITRE = "Titre_recette";
    private static final String TAG_Type = "Type_recette";
    private static final String TAG_Delai = "Delai_recette";
    private static final String TAG_Frequence = "Frequence";
    private static final String TAG_DESCRIPTION = "Description_recette";

    EditText edtitre, edtype, eddelai, edfreq, eddesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recette_detail);

        edtitre=(EditText) findViewById(R.id.edtitre_rct);
        edtype=(EditText) findViewById(R.id.edtype_rct);
        eddelai=(EditText) findViewById(R.id.eddelai_rct);
        edfreq=(EditText) findViewById(R.id.edfreq_rct);
        eddesc=(EditText)findViewById(R.id.eddesc_rct);

        //recuperer intent
        //puis recuperer les donnees venant avec l'intent
        //et les afficher dans les textview

        edtitre.setText(getIntent().getStringExtra(TAG_TITRE));
        edtype.setText(getIntent().getStringExtra(TAG_Type));
        eddelai.setText(getIntent().getStringExtra(TAG_Delai));
        edfreq.setText(getIntent().getStringExtra(TAG_Frequence));
        eddesc.setText(getIntent().getStringExtra(TAG_DESCRIPTION));


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
            Intent i =new Intent(RecetteDetailActivity.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(RecetteDetailActivity.this).create();
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
