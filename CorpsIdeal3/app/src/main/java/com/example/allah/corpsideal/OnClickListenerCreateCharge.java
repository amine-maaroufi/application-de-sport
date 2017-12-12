package com.example.allah.corpsideal;

/**
 * Created by Allah on 09/05/2016.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnClickListenerCreateCharge implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        final Context context = view.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.charge_input_form, null, false);


        final EditText editTextTitreProduit = (EditText) formElementsView.findViewById(R.id.editTexttitreProduit);
        final EditText editTextQuantite = (EditText) formElementsView.findViewById(R.id.editTextQuantite);
        final EditText editTextPrix = (EditText) formElementsView.findViewById(R.id.editTextPrixProduit);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Ajouter votre dépense")
                .setPositiveButton("Ajouter",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String TitreProduit = editTextTitreProduit.getText().toString();
                                String Quantite = editTextQuantite.getText().toString();
                                String Prix = editTextPrix.getText().toString();

                                ObjectChargeFinanciere objectCharge = new ObjectChargeFinanciere();
                                objectCharge.titreproduit = TitreProduit;
                                objectCharge.quantite = Quantite;
                                objectCharge.prixproduit = Prix;

                                boolean createSuccessful = new TableControllerCharge(context).create(objectCharge);

                                if (createSuccessful) {
                                    Toast.makeText(context, "Ajout avec succée.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Impossible d\'enregistrer le dépense.", Toast.LENGTH_SHORT).show();
                                }

                                ((Main_charge_financiere) context).readRecords();
                                ((Main_charge_financiere) context).countRecords();
                                dialog.cancel();
                            }

                        }).show();

    }
}