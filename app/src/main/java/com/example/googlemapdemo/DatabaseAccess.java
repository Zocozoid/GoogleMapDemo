package com.example.googlemapdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    // private constructor so that that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);

    }

    //to return the single instance of database

    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    // to open the database

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    //closing the database connection

    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    // create a method to query and return the result from database

    public String getLongitude (String name){
        c=db.rawQuery("select Longitude from Table1 where Name = '"+name+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String longitude = c.getString(0);
            buffer.append(""+longitude);
        }
        return buffer.toString();
    }
}








