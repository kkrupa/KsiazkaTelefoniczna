package com.kkrupa.android.nauka.ksiazkatelefoniczna;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kkrupa on 21.01.16.
 */
public class KontaktyOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "kontakty.db";
    private static final String OSOBY_TABLE_NAME = "osoby";
    private static final String ID = "id";
    private static final String IMIE = "imie";
    private static final String NAZWISKO = "nazwisko";
    private static final String NUMERTEL = "numer_telefonu";
    private static final String EMAIL = "email";
    private static final String KONTAKTY_TABLE_CREATE = "CREATE TABLE " + OSOBY_TABLE_NAME +
            " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IMIE + " TEXT, " + NAZWISKO +
            " TEXT, " + NUMERTEL + " TEXT, " + EMAIL + " TEXT);";

    KontaktyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(KONTAKTY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + OSOBY_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertContact(String name, String lastName, String number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMIE, name);
        contentValues.put(NAZWISKO, lastName);
        contentValues.put(NUMERTEL, number);
        contentValues.put(EMAIL, email);
        db.insert(OSOBY_TABLE_NAME, null, contentValues);
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(OSOBY_TABLE_NAME, "ID = ?", new String[] {Integer.toString(id)});
    }

    public boolean updateContact(Integer id, String name, String lastName, String number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMIE, name);
        contentValues.put(NAZWISKO, lastName);
        contentValues.put(NUMERTEL, number);
        contentValues.put(EMAIL, email);
        db.update(OSOBY_TABLE_NAME, contentValues, "ID = ?", new String[] {Integer.toString(id)});
        return true;
    }

}
