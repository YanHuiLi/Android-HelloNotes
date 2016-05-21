package com.examaple.archer.hellonotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Archer on 2016/5/21.
 */
public class AddContent extends AppCompatActivity implements View.OnClickListener{

    private String val;
    private Button savabtn,cancelbtn;
    private EditText editText;
    private ImageView c_imagview;
    private VideoView c_video;

    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        val=getIntent().getStringExtra("flag");

        savabtn= (Button) findViewById(R.id.save);
        cancelbtn= (Button) findViewById(R.id.cancel);
        editText= (EditText) findViewById(R.id.ettext);
        c_imagview= (ImageView) findViewById(R.id.c_img);
        c_video= (VideoView) findViewById(R.id.c_video);
        savabtn.setOnClickListener(this);
        cancelbtn.setOnClickListener(this);


        notesDB=new NotesDB(this);
        dbWriter=notesDB.getWritableDatabase();


    }


    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.save:

                 addDB();
                 finish();
                 break;

             case R.id.cancel:

                 finish();
                 break;
         }
    }

    //添加数据到数据库

    public void addDB(){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NotesDB.CONTENT,editText.getText().toString());
        contentValues.put(NotesDB.TIME,getTime());
        contentValues.put(NotesDB.PATH,"PATH_Test");
        contentValues.put(NotesDB.VIDEO,"Video_Test");

        dbWriter.insert(NotesDB.TABLE_NAME,null,contentValues);
    }

    //获取当前设备时间
    public String getTime(){

        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate=new Date();
        String string=format.format(curDate);
        return string;

    }


}
