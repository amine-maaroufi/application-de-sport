package com.example.allah.corpsideal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Allah on 23/04/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Corps.db";

    private static final String TABLE_SPORTIFS_NAME = "sportifs";
    private static final String SPORTIFS_COLUMN_ID = "id_sportif";
    private static final String SPORTIFS_COLUMN_NOM = "nom";
    private static final String SPORTIFS_COLUMN_PRENOM = "prenom";
    private static final String SPORTIFS_COLUMN_EMAIL = "email";
    private static final String SPORTIFS_COLUMN_PSEUDO = "pseudo";
    private static final String SPORTIFS_COLUMN_PASS = "pass";

    private static final String TABLE_CHARGES_NAME = "charges";
    private static final String COLUMN_ID_CHARGE = "id_charge";
    private static final String COLUMN_TITRE_PRODUIT = "titre_produit";
    private static final String COLUMN_QUANTITE = "quantite";
    private static final String COLUMN_PRIX_PRODUIT  = "prix_produit";

    private static final String TABLE_CRITERE_NAME = "criteres";
    private static final String COLUMN_ID_CRITERE = "id_critere";
    private static final String COLUMN_IMC_CRITERE = "imc";
    private static final String COLUMN_IMG_CRITERE = "img";
    private static final String COLUMN_DATE_CRITERE = "date";

    SQLiteDatabase db;

    /*private static final String TABLE_CREATE = "create table sportifs (id integer primary key not null , " +
            "nom text not null ,prenom text not null , email text not null , pseudo text not null , pass text not null);";*/

    public static final String TABLE_CREATE_USER = "CREATE TABLE "
            + TABLE_SPORTIFS_NAME + "(" + SPORTIFS_COLUMN_ID + " INTEGER PRIMARY KEY, "
            + SPORTIFS_COLUMN_NOM + " TEXT, " + SPORTIFS_COLUMN_PRENOM + " TEXT, "
            + SPORTIFS_COLUMN_EMAIL + " TEXT, " + SPORTIFS_COLUMN_PSEUDO + " TEXT,"
            + SPORTIFS_COLUMN_PASS + " TEXT" + ")";

   public static final String TABLE_CREATE_CHARGE = "CREATE TABLE "
            + TABLE_CHARGES_NAME + "(" + COLUMN_ID_CHARGE + " INTEGER PRIMARY KEY, "
            + COLUMN_TITRE_PRODUIT + " TEXT, " + COLUMN_QUANTITE + " TEXT, "
            + COLUMN_PRIX_PRODUIT + " TEXT" + ")";

    public static final String TABLE_CREATE_CRITERE = "CREATE TABLE "
            + TABLE_CRITERE_NAME + "(" + COLUMN_ID_CRITERE + " INTEGER PRIMARY KEY, "
            + COLUMN_IMC_CRITERE + " TEXT, " + COLUMN_IMG_CRITERE + " TEXT, "
            + COLUMN_DATE_CRITERE + " TEXT" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USER);
        db.execSQL(TABLE_CREATE_CHARGE);
        db.execSQL(TABLE_CREATE_CRITERE);
        this.db = db;


    }

    public void insertSportif(Sportif s) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from sportifs";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(SPORTIFS_COLUMN_ID , count);
        values.put(SPORTIFS_COLUMN_NOM, s.getNom());
        values.put(SPORTIFS_COLUMN_PRENOM, s.getPrenom());
        values.put(SPORTIFS_COLUMN_EMAIL, s.getEmail());
        values.put(SPORTIFS_COLUMN_PSEUDO, s.getPseudo());
        values.put(SPORTIFS_COLUMN_PASS, s.getPass());

        db.insert(TABLE_SPORTIFS_NAME, null, values);
        db.close();
    }


    public String searchPass(String pseudo)
    {
        db = this.getReadableDatabase();
        String query = "select pseudo, pass from "+TABLE_SPORTIFS_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(pseudo))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPORTIFS_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARGES_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CRITERE_NAME);
        this.onCreate(db);
    }
}
