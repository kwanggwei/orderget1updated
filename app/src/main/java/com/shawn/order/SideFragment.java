package com.shawn.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SideFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_side, container, false);

        String[] menuItems = {"Baked Potato", "BBQ Beans", "Corn On The Cob", "French Fries", "Garden Veggie", "Mac & Cheese", "Mashed Potato", "Onion Rings", "Potato Wedges", "Tasty Rice", "Colesaw", "House Salad", "Pasta Salad", "Potato Salad"};

        ListView listView = (ListView) view.findViewById(R.id.side);

        ArrayAdapter listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }
}
