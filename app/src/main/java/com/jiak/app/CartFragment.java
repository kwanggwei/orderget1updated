package com.jiak.app;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class CartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView Name = (TextView) view.findViewById(R.id.itemname);
        ImageView Image = (ImageView) view.findViewById(R.id.itemimg);

        Bundle bundle = this.getArguments();

        String getName = bundle.getString("Name", "Test");
        String getImageFilePath = bundle.getString("Image", "Test");
        File file = new File (getImageFilePath);

        Name.setText(getName);
        Image.setImageURI(Uri.fromFile(file));
    }
}
