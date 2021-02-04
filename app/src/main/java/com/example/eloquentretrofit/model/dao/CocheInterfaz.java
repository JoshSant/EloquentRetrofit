package com.example.eloquentretrofit.model.dao;

import com.example.eloquentretrofit.model.pojo.Coche;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CocheInterfaz {

    @DELETE("coche/{id}")
    Call<Boolean> deleteCoche(@Path("id") long id);

    @GET("coche")
    Call<ArrayList<Coche>> getCoches();

    @GET("coche")
    Call<ResponseBody> getString();

    @POST("coche")
    Call<Coche> postCoche(@Body Coche coche);

    @PUT("coche/{id}")
    Call<Boolean> putCoche(@Path("id") long id, @Body Coche coche);

}
