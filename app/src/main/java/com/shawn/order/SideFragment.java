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

public class SideFragment extends Fragment {

    String[] menuItems = {"Baked Potato", "BBQ Beans", "Corn On The Cob", "French Fries", "Garden Veggie", "Mac & Cheese", "Mashed Potato", "Onion Rings", "Potato Wedges", "Tasty Rice", "Colesaw", "House Salad", "Pasta Salad", "Potato Salad"};
    int[] images = {R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2,R.drawable.image2};

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
