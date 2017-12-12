package com.example.allah.corpsideal;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Allah on 06/05/2016.
 */
public class OnLongClickListenerChargeRecord implements View.OnLongClickListener {

    /*5.3 Go back to your OnLongClickListenerStudentRecord.java file, set the following as class variables*/
    Context context;
    String id;


    @Override
    public boolean onLongClick(View view) {

        //5.4 Put the following code inside the onLongClick() method.
        context = view.getContext();
        id = view.getTag().toString();

        //5.5 Add an AlertDialog with simple list view for ‘Edit’ and ‘Delete’ options. Put the following code below 5.4
        final CharSequence[] items = { "Modifier", "Supprimer" };

        new AlertDialog.Builder(context).setTitle("Gérer dépense")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

 /*5.7 Inside the onClick() method of AlertDialog in section 5.5, put the following code. “Edit” has an item index of 0.*/

                        if (item == 0) {
                            editRecord(Integer.parseInt(id));
                        }

                        // 6.1 Go to your OnLongClickListenerStudentRecord.java > onLongClick() method > inside the AlertDialog onClick() method. Put the following code after the first if statement.

                        else if (item == 1) {

                            boolean deleteSuccessful = new TableControllerCharge(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful){
                                Toast.makeText(context, "Suppression avec succée.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context, "Impossible de supprimer le dépense", Toast.LENGTH_SHORT).show();
                            }

                            ((Main_charge_financiere) context).countRecords();
                            ((Main_charge_financiere) context).readRecords();

                        }

                        dialog.dismiss();

                    }
                }).show();
        /*********************************/


        return false;
    }

    //5.8 On your OnLongClickListenerStudentRecord.java, add the following editRecord() method.

    public void editRecord(final int ChargeId) {

        /*5.9 Inside the editRecord() method, we will use the following code to read single record.
        Data will be used to fill up the student form for updating it.*/
        final TableControllerCharge tableControllerCharge = new TableControllerCharge(context);
        ObjectChargeFinanciere objectChargeFinanciere = tableControllerCharge.readSingleRecord(ChargeId);

        //5.11 Going back to OnLongClickListenerStudentRecord.java > editRecrod() method, inflate student_input_form.xml, this time we will use it for updating a record.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.charge_input_form, null, false);

        //5.12 List down form elements. Put the following code under the code in section 5.11
        final EditText editTextTitreProduit = (EditText) formElementsView.findViewById(R.id.editTexttitreProduit);
        final EditText editTextQuantite = (EditText) formElementsView.findViewById(R.id.editTextQuantite);
        final EditText editTextPrix = (EditText) formElementsView.findViewById(R.id.editTextPrixProduit);
        //5.13 Set single record values to the EditText form elements. Put the following code under the code in section 5.12
        editTextTitreProduit.setText(objectChargeFinanciere.titreproduit);
        editTextQuantite.setText(objectChargeFinanciere.quantite);
        editTextPrix.setText(objectChargeFinanciere.prixproduit);
        //  5.14 Show an AlertDialog with the form and single record filling it up. Put the following code under the code in section 5.13
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Modifier dépense")
                .setPositiveButton("Enregister",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

//5.15 Inside the AlertDialog > onClick() method, create the object with the updated value. We are still in the editRecord() method.
                                ObjectChargeFinanciere objectChargeFinanciere = new ObjectChargeFinanciere();
                                objectChargeFinanciere.id = ChargeId;
                                objectChargeFinanciere.titreproduit = editTextTitreProduit.getText().toString();
                                objectChargeFinanciere.quantite = editTextQuantite.getText().toString();
                                objectChargeFinanciere.prixproduit = editTextPrix.getText().toString();

//5.16 Update the record and tell the user whether it was updated or not. Put the following code under the code in section 5.15

                                boolean updateSuccessful = tableControllerCharge.update(objectChargeFinanciere);

                                if(updateSuccessful){
                                    Toast.makeText(context, "Modification avec succée.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Impossible de modifier le dépense.", Toast.LENGTH_SHORT).show();
                                }

                                //5.18 Refresh the count and record list. Put the following code under the code in section 5.16
                                ((Main_charge_financiere) context).countRecords();
                                ((Main_charge_financiere) context).readRecords();


                                dialog.cancel();
                            }

                        }).show();


    }

}