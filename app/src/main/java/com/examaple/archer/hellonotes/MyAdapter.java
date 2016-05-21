package com.examaple.archer.hellonotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Archer on 2016/5/21.
 */
public class MyAdapter  extends BaseAdapter{

    private Context context;
    private Cursor cursor;


    public  MyAdapter(Context context,Cursor cursor){
        this.context=context;
        this.cursor=cursor;
    }
    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //加载视图的权限

        LayoutInflater inflater=LayoutInflater.from(context);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cell, null);

        TextView contenttv= (TextView) layout.findViewById(R.id.list_content);
        TextView timetv= (TextView) layout.findViewById(R.id.list_time);
        ImageView imageView= (ImageView) layout.findViewById(R.id.list_img);
        ImageView  imageView1= (ImageView) layout.findViewById(R.id.list_video);

        cursor.moveToPosition(position);
         String content=cursor.getString(cursor.getColumnIndex("content"));
        String time=cursor.getString(cursor.getColumnIndex("time"));
        contenttv.setText(content);
        timetv.setText(time);


        return layout;
    }
}
