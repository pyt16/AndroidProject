package net.hb.test.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Movie> mv;
    LayoutInflater inf;

    public MovieAdapter(Context context, int layout, ArrayList<Movie> mv){
        this.context = context;
        this.layout = layout;
        this.mv = mv;
        this.inf = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mv.size();
    }

    @Override
    public Object getItem(int position) {
        return mv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inf.inflate(layout, null);
        }//if end

        ImageView iv1 = (ImageView)convertView.findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView)convertView.findViewById(R.id.imageView2);
        TextView mvtitle = (TextView)convertView.findViewById(R.id.mvtitle);
        TextView mvrelease = (TextView)convertView.findViewById(R.id.mvrelease);
        TextView mvdate = (TextView)convertView.findViewById(R.id.mvdate);
        TextView mvstory = (TextView)convertView.findViewById(R.id.mvstory);

        Movie mv1 = mv.get(position);

        iv1.setImageResource(mv1.img1);
        iv2.setImageResource(mv1.img2);
        mvtitle.setText(mv1.title);
        String str = mv1.story;
        if(str.length() > 15){
            str= str.substring(0,20);
            str = str + "...";
        }
        mvstory.setText(str);
        mvrelease.setText(mv1.release ? "상영중": "개봉예정");
        mvdate.setText(mv1.date);
        return convertView;
    }
}
