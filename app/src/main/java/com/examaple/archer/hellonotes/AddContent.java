package com.examaple.archer.hellonotes;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Archer on 2016/5/21.
 */
public class AddContent extends AppCompatActivity{

    private String val;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
         setContentView(R.layout.addcontent);
        val=getIntent().getStringExtra("flag");
    }
}
