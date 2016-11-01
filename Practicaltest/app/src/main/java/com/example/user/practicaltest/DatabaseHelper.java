package com.example.user.practicaltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 11/1/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "detailsdb", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table details(id int primary key autoincrement,first_name text,last_name text,address text,phone_number text,email_id text,password text ");
        }
        catch (SQLException e)
        {
            Log.d("error on table",e.getLocalizedMessage().toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exist");
        onCreate(db);
    }

public boolean insertData(String full_name,String last_name,String address,String phone,String email_id,String password)
{
    SQLiteDatabase db = this.getWritableDatabase();
    long result = -1;
    ContentValues mycontent = new ContentValues();
    mycontent.put("Full name", full_name);
    mycontent.put("Last name",last_name);
    mycontent.put("Address",address);
    mycontent.put("Phone",phone);
    mycontent.put("Email id",email_id);
    mycontent.put("Password",password);
    try
    {
        result = db.insert("tbl_rgstr", null, mycontent);
    }
    catch (SQLiteException e) {
        Log.d("Full name", e.getLocalizedMessage().toString());
        Log.d("Last name", e.getLocalizedMessage().toString());
        Log.d("Address", e.getLocalizedMessage().toString());
        Log.d("Phone", e.getLocalizedMessage().toString());
        Log.d("Email id", e.getLocalizedMessage().toString());
        Log.d("password", e.getLocalizedMessage().toString());
    }
    if (result == -1)
        return false;
    else
    {
        return true;
    }
}

}

