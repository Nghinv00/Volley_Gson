package com.nghinv.gson.Result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NghiNV on 04/04/2017.
 */

public class Result {

    @SerializedName("responseData")
    public String responseData;
    @SerializedName("responseDetails")
    public String responseDetails;
    @SerializedName("responseStatus")
    public String responseStatus;
}
