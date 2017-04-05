package com.nghinv.gson.ArticleList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nghinv.gson.R;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;

public class JsonList extends AppCompatActivity {

    final String url ="http://hmkcode.appspot.com/rest/controller/get.json";
    RequestQueue requestQueue;
    Gson gson = new Gson();
    Button btnBai3;
    public static List<ArticleList> articleLists;
    ArticleList at;
    ArrayAdapter<ArticleList> adapter;
    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 =(TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);

        btnBai3 = (Button) findViewById(R.id.btnGetDataBai3);
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

    }

    private void fetchData() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response", response.toString());
                        articleLists = Arrays.asList(gson.fromJson(response.toString(), ArticleList.class));
                        Log.d("Response", articleLists.toString());
                        
                        txt1.setText("SNBB");
//                        int size = articleLists.size();     // thông tin số bản ghi trên service
                        /*for( ArticleList artlist : articleLists){

                            txt1.setText("SNBB");
                        }*/

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.ReSponse", error.toString());
                    }
                });
                requestQueue.add(request);
    }
}
