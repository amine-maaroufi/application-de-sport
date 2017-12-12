package com.example.allah.corpsideal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main_charge_financiere extends AppCompatActivity implements View.OnClickListener {

   Button btn_create;
    String VarLog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_charge_financiere);



        btn_create=(Button)findViewById(R.id.buttonCreateProduct);
        btn_create.setOnClickListener(this);

        Button buttonCreateLocation = (Button) findViewById(R.id.buttonCreateProduct);
        buttonCreateLocation.setOnClickListener(new OnClickListenerCreateCharge());

        //  3.6 On your MainActivity.java > onCreate() method, call the countRecords() method.
        countRecords();

        //4.4 Call readRecords() method on your MainActivity.java > onCreate() method
        readRecords();
    }

    @Override
    public void onClick(View v) {

    }

    //3.2 On your MainActivity.java file, create a countRecords() method
    public void countRecords() {

        //3.4 Go back to your MainActivity.java > countRecords() method and call the count() method you just created.
        int recordCount = new TableControllerCharge(this).count();

        //3.5 Display the count to the text view.

        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " enregistrement exist.");

    }

    //4.3 On your MainActivity.java, create the readRecords() method. This will display database records to user interface.
    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectChargeFinanciere> charges = new TableControllerCharge(this).read();

        if (charges.size() > 0) {

            for (ObjectChargeFinanciere obj : charges) {

                int id = obj.id;
                String TitreProduit = obj.titreproduit;
                String Quantite = obj.quantite;
                String Prix = obj.prixproduit;
                int total  =  Integer.parseInt(Prix)*Integer.parseInt(Quantite);

                String textViewContents = " Nom de produit :  " + TitreProduit + " - Quantité :   " + Quantite+ " - Prix :  " + total;

                TextView textViewStudentItem= new TextView(this);
                textViewStudentItem.setPadding(0, 10, 0, 10);
                textViewStudentItem.setText(textViewContents);
                textViewStudentItem.setTag(Integer.toString(id));
                textViewStudentItem.setTextColor(Color.parseColor("#FF000000"));

                /*5.2 Set the OnLongClickListener for each of the display records. Go to your MainActivity.java > readRecords() method,
                 inside the ‘for’ loop,
                put the following code under the textViewStudentItem.setTag(Integer.toString(id)); code.*/
                textViewStudentItem.setOnLongClickListener(new OnLongClickListenerChargeRecord());


                linearLayoutRecords.addView(textViewStudentItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("Pas des enregistrements");

            linearLayoutRecords.addView(locationItem);
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
            Intent i =new Intent(Main_charge_financiere.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_charge_financiere.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(Main_charge_financiere.this).create();
            alertDialog.setTitle("à propos");
            alertDialog.setView(formElementsView);
           /* alertDialog.setMessage(" cette application permettre ");*/
            alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK",
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
