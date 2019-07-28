package com.jiak.app;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    public MainFragment(){

    }

    ListView listView;
    View view;
    String[] menuItems = {"Grilled Chicken", "Black Pepper Chicken", "Hickory BBQ Chicken", "Lemon Lime Chicken", "Golden Fried Chicken", "Honey Bourbon Ribs", "Grilled Fish w Herbs"};
    int[] images = {R.drawable.grilledchicken, R.drawable.blackpepperchicken,R.drawable.hickorychicken,R.drawable.lemonlimechicken,R.drawable.goldenfriedchicken,R.drawable.honeybourbonribs, R.drawable.grilledfishwherbs};
    List<Main> mainList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        listView = view.findViewById(R.id.main);

        mainList.add(new Main("Grilled Chicken", 13,"drawable/grilledchicken.jpg"));
        mainList.add(new Main("Black Pepper Chicken", 13, "drawable/blackpepperchicken.jpg"));
        mainList.add(new Main("Hickory BBQ Chicken", 14,"drawable/hickorychicken.jpg"));
        mainList.add(new Main("Lemon Lime Chicken", 13,"drawable/lemonlimechicken.jpg"));
        mainList.add(new Main("Golden Fried Chicken", 12,"drawable/goldenfriedchicken.jpg"));
        mainList.add(new Main("Honey Bourbon Ribs", 17,"drawable/honeybourbonribs.jpg"));
        mainList.add(new Main("Grilled Fish w Herbs", 16,"drawable/grilledfishwherbs.jpg"));

        MainAdapter adapter = new MainAdapter(view.getContext(), mainList);
        listView.setAdapter(adapter);
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Main main = mainList.get(position);
                Log.i("test", "I Clicked on Row " + position + " and it worked!");

                Fragment fragment = new CartFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Name", main.getName());
                bundle.putInt("Cost", main.getCost());
                bundle.putString("Image", main.getImageFilePath());
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
