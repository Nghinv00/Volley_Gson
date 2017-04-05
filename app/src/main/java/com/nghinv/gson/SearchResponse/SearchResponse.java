package com.nghinv.gson.SearchResponse;

import com.nghinv.gson.Result.Result;

import java.util.List;

/**
 * Created by NghiNV on 04/04/2017.
 */

public class SearchResponse {

    public List<Result> entities;   // tập các dối tượng chứa thông tin convert to Gson
    public String query;        //  thuộc tính
    public SearchResponse responseData; // Đối tượng
}
