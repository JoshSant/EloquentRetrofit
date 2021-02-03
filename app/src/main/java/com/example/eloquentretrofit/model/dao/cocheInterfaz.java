package com.example.eloquentretrofit.model.dao;

import com.example.eloquentretrofit.model.pojo.coche;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface cocheInterfaz {

    @DELETE("coche/{id}")
    Call<Boolean> deleteCoche(@Path("id") long id);

    @GET("coche")
    Call<ArrayList<coche>> getCoches();

    @GET("coche")
    Call<ResponseBody> getString();

    @POST("coche")
    Call<coche> postCoche(@Body coche coche);

    @PUT("coche/{id}")
    Call<Boolean> putCoche(@Path("id") long id, @Body coche coche);

}
