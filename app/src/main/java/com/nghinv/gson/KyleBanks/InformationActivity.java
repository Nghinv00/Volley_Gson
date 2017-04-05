package com.nghinv.gson.KyleBanks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.nghinv.gson.MainActivity;
import com.nghinv.gson.R;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {


    ListView lvInfor;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        lvInfor = (ListView) findViewById(R.id.lvInfor);

        for( Post post : MainActivity.posts){
            String s = post.ID + post.author;
            arrayList.add(post.ID + "" + post.author);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvInfor.setAdapter(adapter);

    }
}
