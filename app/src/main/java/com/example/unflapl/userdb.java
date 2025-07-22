package com.example.unflapl;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class userdb extends SQLiteOpenHelper {
    public static final String DB_NAME = "users_db";
    public static final int DB_VERSION = 1;

    public static final String TB_USERS = "users";

    public static final String TB_CLM_USER_ID = "user_id";
    public static final String TB_CLM_USER_NAME = "user_name";
    public static final String TB_CLM_USER_PASSWORD = "user_password";

    public userdb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TB_USERS + " (" +
                        TB_CLM_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TB_CLM_USER_NAME + " TEXT UNIQUE, " +
                        TB_CLM_USER_PASSWORD + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_USERS);
        onCreate(sqLiteDatabase);
    }

    public boolean insertUser(String userName, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TB_CLM_USER_NAME, userName);
        values.put(TB_CLM_USER_PASSWORD, password);

        long res = db.insert(TB_USERS, null, values);
        db.close();
        return res != -1;
    }



    @SuppressLint("Range")
    public boolean isUserNameAvailable(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        String[] selectionArgs = {userName};
        String[] columns = {TB_CLM_USER_ID};

        Cursor cursor = db.query(
                TB_USERS,
                columns,
                TB_CLM_USER_NAME + " =?",
                selectionArgs,
                null,
                null,
                null
        );
        boolean available = cursor.getCount() == 0;
        cursor.close();
        db.close();
        return available;
    }
    public boolean checkUser(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] selectionArgs = {userName, password};
        String[] columns = {TB_CLM_USER_ID};

        Cursor cursor = db.query(
                TB_USERS,
                columns,
                TB_CLM_USER_NAME + " =? AND " + TB_CLM_USER_PASSWORD + " =?",
                selectionArgs,
                null,
                null,
                null
        );

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }

}
