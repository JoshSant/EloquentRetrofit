package com.example.eloquentretrofit.model.dao;

import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.pojo.Ventas;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VentasInterfaz {

    @DELETE("ventas/{id}")
    Call<Boolean> deleteVentas(@Path("id") long id);

    @GET("ventas")
    Call<ArrayList<Ventas>> getVentas();

    @GET("ventas")
    Call<ResponseBody> getString();

    @POST("ventas")
    Call<Ventas> postVentas(@Body Ventas ventas);

    @PUT("ventas/{id}")
    Call<Boolean> putVentas(@Path("id") long id, @Body Ventas ventas);

}
