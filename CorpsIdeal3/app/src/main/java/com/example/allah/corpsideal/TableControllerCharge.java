package com.example.allah.corpsideal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allah on 06/05/2016.
 */

/*2.6.6 Create new “TableControllerStudent.java” file, extending the DatabaseHandler. This file will control all the operations
related to the student’s table. It will have the following code.*/
public class TableControllerCharge extends DatabaseHelper {

    public TableControllerCharge(Context context) {
        super(context);
    }


    /*2.6.7 Do the create() method for creating new record. The following method is inside TableControllerStudent class.*/
    public boolean create(ObjectChargeFinanciere objectChargeFinanciere) {

        ContentValues values = new ContentValues();

        values.put("titre_produit", objectChargeFinanciere.titreproduit);
        values.put("quantite", objectChargeFinanciere.quantite);
        values.put("prix_produit", objectChargeFinanciere.prixproduit);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("charges", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    // 3.3 On your TableControllerStudent.java, create a count() method.

    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM charges";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    //4.2 On your TableControllerStudent.java, create a read() method.

    public List<ObjectChargeFinanciere> read() {

        List<ObjectChargeFinanciere> recordsList = new ArrayList<ObjectChargeFinanciere>();

        String sql = "SELECT * FROM charges ORDER BY id_charge DESC ";
//ORDER BY id_charge DESC
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_charge")));
                String TitreProduit = cursor.getString(cursor.getColumnIndex("titre_produit"));
                String Quantite = cursor.getString(cursor.getColumnIndex("quantite"));
                String Prix = cursor.getString(cursor.getColumnIndex("prix_produit"));

                ObjectChargeFinanciere objectChargeFinanciere = new ObjectChargeFinanciere();
                objectChargeFinanciere. id= id;
                objectChargeFinanciere.titreproduit = TitreProduit;
                objectChargeFinanciere.quantite = Quantite;
                objectChargeFinanciere.prixproduit = Prix;

                recordsList.add(objectChargeFinanciere);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

    //5.10 On your TableControllerStudent.java, add the following method readSingleRecord() code.
    public ObjectChargeFinanciere readSingleRecord(int ChargeId) {

        ObjectChargeFinanciere objectChargeFinanciere = null;

        String sql = "SELECT * FROM charges WHERE id_charge = " + ChargeId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_charge")));
            String TitreProduit = cursor.getString(cursor.getColumnIndex("titre_produit"));
            String Quantite = cursor.getString(cursor.getColumnIndex("quantite"));
            String Prix = cursor.getString(cursor.getColumnIndex("prix_produit"));

            objectChargeFinanciere = new ObjectChargeFinanciere();
            objectChargeFinanciere.id = id;
            objectChargeFinanciere.titreproduit = TitreProduit;
            objectChargeFinanciere.quantite = Quantite;
            objectChargeFinanciere.prixproduit = Prix;

        }

        cursor.close();
        db.close();

        return objectChargeFinanciere;

    }


    //5.17 On your TableControllerStudent.java, add the update() method.

    public boolean update(ObjectChargeFinanciere objectChargeFinanciere) {

        ContentValues values = new ContentValues();

        values.put("titre_produit", objectChargeFinanciere.titreproduit);
        values.put("quantite", objectChargeFinanciere.quantite);
        values.put("prix_produit", objectChargeFinanciere.prixproduit);

        String where = "id_charge = ?";

        String[] whereArgs = { Integer.toString(objectChargeFinanciere.id) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("charges", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }


    //6.2 Go back to your TableControllerStudent.java and add the following delete code.
    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("charges", "id_charge ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }

}