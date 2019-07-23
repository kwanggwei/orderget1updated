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

public class DrinkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);

        String[] menuItems = {"Coke", "Coke Zero", "Bottled Water", "Sprite", "Coke Float", "Sprite Float", "Ice Lemon Tea", "Apple Juice", "Orange Juice", "Lime Juice", "Plain Water", "Espresso", "Coffee Latte", "Coffee Mocha", "Hot Tea", "Hot Milk"};

        ListView listView = (ListView) view.findViewById(R.id.drinks);

        ArrayAdapter listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }
}
