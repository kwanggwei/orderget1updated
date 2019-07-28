package com.jiak.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    Context context;
    List<Main> mainList = new ArrayList<>();

    MainAdapter(Context context, List<Main> mains){
        this.context = context;
        this.mainList = mains;
    }

    @Override
    public int getCount(){
        return mainList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View itemView = convertView;

        itemView = LayoutInflater.from(context).inflate(R.layout.customlayout,parent,false);

        TextView mainName = itemView.findViewById(R.id.textView);
        mainName.setText(mainList.get(position).getName());

        ImageView mainImage = itemView.findViewById(R.id.imageView);
        mainImage.setImageResource(R.drawable.grilledchicken);

        return itemView;
    }
}
