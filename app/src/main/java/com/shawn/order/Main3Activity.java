package com.shawn.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    String[] MAINCOURSES = {"Chargrilled Chicken", "Black Pepper Chicken", "Crispy Fried Chicken",
            "Teriyaki Chicken", "Lemon Lime Chicken", "Double Up Chicken", "Seafood Pasta"};
    String[] DESCRIPTION = {"Chargrilled sauce", "Black Pepper sauce", "Crispy Fried", "Teriyaki sauce",
            "Lemon Lime sauce", "Choice of 2 chicken", "Seafood soup based"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        ListView listView=(ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return MAINCOURSES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView2_description);

            textView_name.setText(MAINCOURSES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
}
