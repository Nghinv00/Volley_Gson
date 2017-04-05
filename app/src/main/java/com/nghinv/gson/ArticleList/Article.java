package com.nghinv.gson.ArticleList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by NghiNV on 05/04/2017.
 */

public class Article {
    @SerializedName("title")
    public String title ;
    @SerializedName("url")
    public String url;

//    public List<Cate> categories;
//    public List<Tag> tags;

    @SerializedName("categories")
    public List<String> categories;

    @SerializedName("tags")
    public List<String> tags;
}