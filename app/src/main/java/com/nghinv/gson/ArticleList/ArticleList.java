package com.nghinv.gson.ArticleList;

import android.support.annotation.NonNull;
import android.support.v4.media.MediaMetadataCompat;
import android.widget.TabHost;

import com.android.volley.Cache;
import com.google.gson.annotations.SerializedName;
import com.nghinv.gson.ArticleList.Category.Cate;
import com.nghinv.gson.ArticleList.Tag.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by NghiNV on 04/04/2017.
 */

public class ArticleList {

    @SerializedName("articleList")
    public List<Article> articleList = new ArrayList<>();

    /*   public static Article articleList = new Article();*/
}
