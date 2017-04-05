package com.nghinv.gson;

import android.content.Intent;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nghinv.gson.ArticleList.JsonList;
import com.nghinv.gson.KyleBanks.InformationActivity;
import com.nghinv.gson.KyleBanks.Post;
import com.nghinv.gson.Result.Result;
import com.nghinv.gson.SearchResponse.SearchResponse;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String url =  "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blogs%27";
    private static final String ENDPOINT = "https://kylewbanks.com/rest/posts.json";
    TextView txtQuery, txtList;
    RequestQueue requestQueue;
    ArrayAdapter<String> adapter;
    public static String Json, Gson, Error1;

    TextView data1, data2, txt1;
    Button btnData1;
    Gson gsonBai2 = new Gson();

    public static List<Post> posts;
    public static List<SearchResponse> search;
    public static List<Result> result;
    public ArrayList<Result> arrresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gsonBai2 = gsonBuilder.create();

        txt1 = (TextView) findViewById(R.id.txt1);
        txtQuery = (TextView) findViewById(R.id.txtQuery);
        txtList =(TextView) findViewById(R.id.txtList);
        Button btnGetData = (Button) findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
            }
        });

        data1 = (TextView) findViewById(R.id.data1);
        data2 = (TextView) findViewById(R.id.data2);
        btnData1 = (Button) findViewById(R.id.btnGetData1);
        btnData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

        Button btnBai3 = (Button) findViewById(R.id.btnBai3);
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JsonList.class);
                startActivity(intent);
            }
        });

    }

    private void fetchData() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,
                onPostsLoaded,onPostsError );
        requestQueue.add(request);
    }
    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            /*  public static List<Post> posts; */
            posts = Arrays.asList(gsonBai2.fromJson(response, Post[].class));

            Log.e("PostActivity", "Kich thuoc: "+ posts.size() + " posts loaded");
            for( Post post : posts){

                Log.w("PostActivity", post.ID + ": " + post.title);
            }
            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(intent);

        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("PostActivity", error.toString());
        }
    };

    private void GetData() {
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonobject) {
                        Log.d("Response", jsonobject.toString());
                        Json = jsonobject.toString();
                        ConvertToGson(Json);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.ReSponse", error.toString());
                        Error1 = error.toString();

                    }
                });
//        txtQuery.setText(Json);
        requestQueue.add(getRequest);
    }

    private void ConvertToGson(String strObject) {

        Gson gson = new Gson();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        result = Arrays.asList(gson.fromJson(strObject, Result.class));
       //  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
        for( Result rs : result){

            //arrresult.addAll(result);

            txt1.setText("responseData: " + rs.responseData);
            txtList.setText("responseDetails: " + rs.responseDetails);
            txtQuery.setText("responseStatus: " + rs.responseStatus);
        }
    }
}
