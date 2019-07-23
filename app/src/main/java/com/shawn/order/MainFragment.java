package com.shawn.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainFragment extends Fragment {

    String[] menuItems = {"Grilled Chicken", "Black Pepper Chicken", "Hickory BBQ Chicken", "Lemon Lime Chicken", "Golden Fried Chicken", "Honey Bourbon Ribs", "Lamb T Bone", "Pork Chops", "Golden Fried Fish", "Fish & Chips", "Grilled Fish w Herbs", "Grilled Salmon Fillet", "Wagyu Beef Burger"};
    int[] images = {R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) view.findViewById(R.id.main);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        listView.setAdapter(customAdaptor);

        return view;
    }

    class CustomAdaptor extends BaseAdapter{
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
