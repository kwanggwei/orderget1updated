package com.jiak.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class CartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_cart, container, false);
        Button add = (Button) v.findViewById(R.id.addbtn);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Order has been added");
                alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Added", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });

        return v;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView Name = (TextView) view.findViewById(R.id.itemname);
        TextView Cost = (TextView) view.findViewById(R.id.itemcost);
        ImageView Image = (ImageView) view.findViewById(R.id.itemimg);

        Bundle bundle = this.getArguments();

        String getName = bundle.getString("Name", "Test");
        int getCost = bundle.getInt("Cost");
        String getImageFilePath = bundle.getString("Image", "Test");
        File file = new File (getImageFilePath);

        Context c = getContext();
        String imageName = getImageFilePath.substring(0,getImageFilePath.length() - 4);
        int id = c.getResources().getIdentifier(imageName,null,c.getPackageName());

        Name.setText(getName);
        Cost.setText("$" +getCost);
        Image.setImageResource(id);
    }


}
