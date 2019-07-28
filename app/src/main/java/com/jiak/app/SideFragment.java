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

public class SideFragment extends Fragment {

    public SideFragment(){

    }

    ListView listView;
    View view;
    String[] menuItems = {"Baked Potato", "BBQ Beans", "Corn On The Cob", "French Fries", "Garden Veggie", "Mac & Cheese", "Mashed Potato", "Onion Rings", "Potato Wedges"};
    int[] images = {R.drawable.bakedpotato,R.drawable.bbqbeans,R.drawable.cornonthecob,R.drawable.frenchfries,R.drawable.gardenvegie,R.drawable.image2,R.drawable.mashedpotato,R.drawable.onionrings,R.drawable.potatowedges};
    List<Main> mainList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_side, container, false);
        listView = view.findViewById(R.id.side);

        mainList.add(new Main("Baked Potato", "drawable/bakedpotato.jpg"));
        mainList.add(new Main("BBQ Beans", "drawable/bbqbeans.jpg"));
        mainList.add(new Main("Corn On The Cob", "drawable/cornonthecob.jpg"));
        mainList.add(new Main("French Fries", "drawable/frenchfries.jpg"));
        mainList.add(new Main("Garden Veggie", "drawable/gardenvegie.jpg"));
        mainList.add(new Main("Mac & Cheese", "drawable/image2.jpg"));
        mainList.add(new Main("Mashed Potato", "drawable/mashedpotato.jpg"));
        mainList.add(new Main("Onion Rings", "drawable/onionrings.jpg"));
        mainList.add(new Main("Potato Wedges", "drawable/potatowedges.jpg"));

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
