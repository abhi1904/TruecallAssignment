package com.truecaller.assignment.services;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface TruecallerApi {

    @GET(".")
    Call<String> getTCWebPage();

}
