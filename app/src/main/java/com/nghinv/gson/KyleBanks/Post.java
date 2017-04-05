package com.nghinv.gson.KyleBanks;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by NghiNV on 04/04/2017.
 */

public class Post {
    public Post(){

    }
    @SerializedName("id")
    public int ID;
    @SerializedName("date")
    Date dateCreateed;

    public String title;
    public String author;
    public String url;
    public  String body;
}
