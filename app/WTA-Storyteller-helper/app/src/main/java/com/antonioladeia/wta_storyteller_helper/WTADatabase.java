package com.antonioladeia.wta_storyteller_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ladeia on 27/02/17.
 */

public class WTADatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "WTACHARACTER";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "_id INTEGER PRIMARY KEY," +
                    "NAME  TEXT, " +
                    "BREED TEXT, " +
                    "AUSPICE TEXT, " +
                    "TRIBE TEXT, " +
                    "RAGE INTEGER, " +
                    "GNOSIS INTEGER, " +
                    "WILLPOWER INTEGER, " +
                    "HEALTH INTEGER );";

    WTADatabase(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insertCharacter(PlayerCharacter player, Context context) throws Exception {
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getWritableDatabase();

        try {
            db.insert(TABLE_NAME, null, player.getContentValues());
        }catch (Exception ex)
        {
            db.close();
            throw new Exception(ex);

        }
        db.close();
    }

    public Cursor getCharacters(Context context){
        Cursor cursor;
        String[] fields =  {"_id","NAME"};
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.query(TABLE_NAME, fields, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor getCharacterByID(Context context, int id){
        Cursor cursor;
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getReadableDatabase();
        String[] fields =  {"_id","NAME", "BREED", "AUSPICE", "TRIBE", "RAGE", "GNOSIS", "WILLPOWER", "HEALTH"};
        String where = "_id =" + id;
        cursor = db.query(TABLE_NAME,fields,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void deletCharacter(Context context, int id) throws Exception {
        String where = "_id =" + id;
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getReadableDatabase();
        try {
            db.delete(TABLE_NAME, where, null);
        }
        catch (Exception ex)
        {
            db.close();
            throw new Exception(ex);
        }
        db.close();
    }

    public void updateRage(Context context, int rage, int characterID) {
        ContentValues values = new ContentValues();
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getWritableDatabase();

        String where = "_id =" + characterID;

        values.put("RAGE", rage);

        db.update(TABLE_NAME,values,where,null);
        db.close();
    }

    public void updateGnosis(Context context, int gnosis, int characterID) {
        ContentValues values = new ContentValues();
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getWritableDatabase();

        String where = "_id =" + characterID;

        values.put("GNOSIS", gnosis);

        db.update(TABLE_NAME,values,where,null);
        db.close();
    }

    public void updateWillpower(Context context, int willpower, int characterID) {
        ContentValues values = new ContentValues();
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getWritableDatabase();

        String where = "_id =" + characterID;

        values.put("WILLPOWER", willpower);

        db.update(TABLE_NAME,values,where,null);
        db.close();
    }

    public void updateHealth(Context context, int health, int characterID) {
        ContentValues values = new ContentValues();
        WTADatabase database = new WTADatabase(context);
        SQLiteDatabase db = database.getWritableDatabase();

        String where = "_id =" + characterID;

        values.put("HEALTH", health);

        db.update(TABLE_NAME,values,where,null);
        db.close();
    }
}
