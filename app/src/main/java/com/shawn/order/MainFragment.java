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

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        String[] menuItems = {"Grilled Chicken", "Black Pepper Chicken", "Hickory BBQ Chicken", "Lemon Lime Chicken", "Golden Fried Chicken", "Honey Bourbon Ribs", "Lamb T Bone", "Pork Chops", "Golden Fried Fish", "Fish & Chips", "Grilled Fish w Herbs", "Grilled Salmon Fillet", "Wagyu Beef Burger"};

        ListView listView = (ListView) view.findViewById(R.id.main);

        ArrayAdapter listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }
}
