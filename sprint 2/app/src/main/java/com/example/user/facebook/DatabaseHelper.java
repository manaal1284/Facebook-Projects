package com.example.user.facebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by user on 10/18/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {

        super(context, "loginDb", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table tbl_login(id integer primary key autoincrement,email text,password text)");
        } catch (SQLiteException e)
        {
            Log.d("error in creating table", e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbl_login");
        onCreate(db);
    }

    public boolean insertData(String email,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;
        ContentValues mycontent = new ContentValues();
        mycontent.put("email", email);
        mycontent.put("password",password);
        try {
            result = db.insert("tbl_login", null, mycontent);
        }
        catch (SQLiteException e) {
            Log.d("message", e.getLocalizedMessage().toString());
        }
        if (result == -1)
            return false;
        else

        {
            return true;
        }

    }


    public String getEntry(String email_id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("tbl_login", null, " email=?",
                new String[] { email_id }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;


        }
    }