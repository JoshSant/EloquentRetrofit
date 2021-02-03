package com.example.eloquentretrofit.model;

import android.util.Log;

import com.example.eloquentretrofit.model.dao.cocheInterfaz;
import com.example.eloquentretrofit.model.pojo.coche;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cocheFunctions {

    private String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
    private List<coche> listaCoches = new ArrayList<>();

    public void insert(coche coche){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheInterfaz cocheInter = retrofit.create(cocheInterfaz.class);

        Call<coche> request = cocheInter.postCoche(coche);
        request.enqueue(new Callback<coche>() {
            @Override
            public void onResponse(Call<coche> call, Response<coche> response) {
            }

            @Override
            public void onFailure(Call<coche> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
    }

    public void edit(long id, coche coche){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheInterfaz cocheInter = retrofit.create(cocheInterfaz.class);

        Call<Boolean> request = cocheInter.putCoche(id, coche);
        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XYZ",t.getLocalizedMessage());
                Log.v("XYZCoche", coche.toString());
            }
        });
    }

    public void delete(long id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheInterfaz coche = retrofit.create(cocheInterfaz.class);

        Call<Boolean> request = coche.deleteCoche(id);

        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XYZ", t.getMessage());
            }
        });
    }

    public List<coche> mostrar(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheInterfaz coche = retrofit.create(cocheInterfaz.class);

        Call<ArrayList<coche>> request = coche.getCoches();
        request.enqueue(new Callback<ArrayList<coche>>() {
            @Override
            public void onResponse(Call<ArrayList<coche>> call, Response<ArrayList<coche>> response) {
                Log.v("XYZresponse", response.body().toString());
                listaCoches = response.body();
                Log.v("XYZlista", listaCoches.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<coche>> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
        Log.v("XYZlista2", listaCoches.toString());
        return listaCoches;
    }

}
