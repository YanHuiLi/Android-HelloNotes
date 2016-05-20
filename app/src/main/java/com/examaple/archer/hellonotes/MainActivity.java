package com.examaple.archer.hellonotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

     private  NotesDB notesDB;
    private SQLiteDatabase dbWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         notesDB= new NotesDB(this);
        dbWriter= notesDB.getWritableDatabase();
        addDB();
    }

    public void addDB(){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NotesDB.CONTENT,"Hello");
        contentValues.put(NotesDB.TIME,getTime());
        //插入语句
        dbWriter.insert(NotesDB.TABLE_NAME,null,contentValues);

    }

    //获取当前设备时间
    public String getTime(){

        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate=new Date();
        return format.format(curDate);

    }

}
