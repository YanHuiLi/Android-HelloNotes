package com.examaple.archer.hellonotes;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Archer on 2016/5/20.
 */
public class NotesDB extends SQLiteOpenHelper{

    public static final  String TABLE_NAME="note";
    public static final String  CONTENT="content";
    public static final String ID="_id";

    //写入文本的时间
    public static final String TIME="time";
    public NotesDB(Context context) {
        super(context, "notes", null, 1);
    }

    public NotesDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库

   

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}