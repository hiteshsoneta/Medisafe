package com.example.medisafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Meddb extends SQLiteOpenHelper {

    public static  final String KEY_ID="ID";
    public static  final String KEY_DRUGS="Drugs";
    public static  final String KEY_PILLS="Pills";
    public static  final String KEY_hours="Hours";
    public static  final String KEY_minutes="Minutes";

    public static final String DBName="Medicines.db";
    public static final String Table_Name="Medicinedetails";


    public Meddb(@Nullable Context context) {
        super(context, DBName, null, 1);
    }


    public void addmed(Medicine med)
    {
        Log.d("Meddb","Inserting medicine records");

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(KEY_DRUGS,med.getdrugname());
        values.put(KEY_PILLS,med.getpills());

        db.insert(Table_Name,null,values);

        db.close();
    }

    public Cursor getallrecords()
    {
        Log.d("Meddb","Reading all medicine records");

        SQLiteDatabase db=this.getWritableDatabase();

        String querydisp="SELECT * FROM "+Table_Name;

        Cursor result=db.rawQuery(querydisp,null);

        return result;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+Table_Name+ "(" + KEY_DRUGS +" TEXT, "+ KEY_PILLS +" TEXT "+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        onCreate(db);
    }
}
