package com.jiak.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DrinkFragment extends Fragment {
    String[] menuItems = {"Coke", "Coke Zero", "Bottled Water", "Sprite", "Coke Float", "Sprite Float", "Ice Lemon Tea", "Apple Juice", "Orange Juice", "Lime Juice"};
    int[] images = {R.drawable.image3,R.drawable.cokezero,R.drawable.bottledwater,R.drawable.sprite,R.drawable.cokefloat,R.drawable.spirtefloat,R.drawable.icelemontea,R.drawable.applejuice,R.drawable.orangejuice,R.drawable.limejuice};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_side, container, false);

        ListView listView = (ListView) view.findViewById(R.id.side);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        listView.setAdapter(customAdaptor);

        return view;
    }

    class CustomAdaptor extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textView);

            mImageView.setImageResource(images[position]);
            mTextView.setText(menuItems[position]);
            return view;
        }
    }
}
