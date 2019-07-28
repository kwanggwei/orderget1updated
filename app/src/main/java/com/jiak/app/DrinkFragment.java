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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DrinkFragment extends Fragment {

    public DrinkFragment(){

    }

    ListView listView;
    View view;
    String[] menuItems = {"Coke", "Coke Zero", "Bottled Water", "Sprite", "Coke Float", "Sprite Float", "Ice Lemon Tea", "Apple Juice", "Orange Juice", "Lime Juice"};
    int[] images = {R.drawable.image3,R.drawable.cokezero,R.drawable.bottledwater,R.drawable.sprite,R.drawable.cokefloat,R.drawable.spirtefloat,R.drawable.icelemontea,R.drawable.applejuice,R.drawable.orangejuice,R.drawable.limejuice};
    List<Main> mainList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_drink, container, false);
        listView = view.findViewById(R.id.drink);

        mainList.add(new Main("Coke", "drawable/image3.jpg"));
        mainList.add(new Main("Coke Zero", "res/drawable/cokezero.jpg"));
        mainList.add(new Main("Bottled Water", "drawable/bottledwater.jpg"));
        mainList.add(new Main("Sprite", "drawable/sprite.jpg"));
        mainList.add(new Main("Coke Float", "drawable/cokefloat.jpg"));
        mainList.add(new Main("Sprite Float", "drawable/spirtefloat.jpg"));
        mainList.add(new Main("Ice Lemon Tea", "drawable/icelemontea.jpg"));
        mainList.add(new Main("Apple Juice", "drawable/applejuice.jpg"));
        mainList.add(new Main("Orange Juice", "drawable/orangejuice.jpg"));
        mainList.add(new Main("Lime Juice", "drawable/limejuice.jpg"));

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
