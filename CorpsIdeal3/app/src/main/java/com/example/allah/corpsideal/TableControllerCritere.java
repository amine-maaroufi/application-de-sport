package com.example.allah.corpsideal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Allah on 06/05/2016.
 */

/*2.6.6 Create new “TableControllerStudent.java” file, extending the DatabaseHandler. This file will control all the operations
related to the student’s table. It will have the following code.*/
public class TableControllerCritere extends DatabaseHelper {

    public TableControllerCritere(Context context) {
        super(context);
    }

    String VarLog ;

    /*2.6.7 Do the create() method for creating new record. The following method is inside TableControllerStudent class.*/
    public boolean create(ObjectCritere objectCritere) {

        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(new Date());

        values.put("imc", objectCritere.IMC);
        values.put("img", objectCritere.IMG);
        values.put("date", strDate);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("criteres", null, values) > 0;
        db.close();

        return createSuccessful;
    }


    public List<ObjectCritere> read() {

        List<ObjectCritere> recordsList = new ArrayList<ObjectCritere>();

        String sql = "SELECT * FROM criteres ORDER BY id_critere DESC ";
//ORDER BY id_charge DESC
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_critere")));
                String TEXTIMC = cursor.getString(cursor.getColumnIndex("imc"));
                String TEXTIMG = cursor.getString(cursor.getColumnIndex("img"));
                String TEXTDate = cursor.getString(cursor.getColumnIndex("date"));

                ObjectCritere objectCritere = new ObjectCritere();
                objectCritere. id= id;
                objectCritere.IMC = TEXTIMC;
                objectCritere.IMG = TEXTIMG;
                objectCritere.Date = TEXTDate;

                recordsList.add(objectCritere);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }



}