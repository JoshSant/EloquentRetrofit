package com.example.eloquentretrofit.model;

import android.util.Log;

import com.example.eloquentretrofit.model.dao.CocheInterfaz;
import com.example.eloquentretrofit.model.pojo.Coche;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocheFunctions {

    private String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
    private List<Coche> listaCoches = new ArrayList<>();

    public void insert(Coche coche){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CocheInterfaz cocheInter = retrofit.create(CocheInterfaz.class);

        Call<Coche> request = cocheInter.postCoche(coche);
        request.enqueue(new Callback<Coche>() {
            @Override
            public void onResponse(Call<Coche> call, Response<Coche> response) {
            }

            @Override
            public void onFailure(Call<Coche> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
    }

    public void edit(long id, Coche coche){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CocheInterfaz cocheInter = retrofit.create(CocheInterfaz.class);

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

        CocheInterfaz coche = retrofit.create(CocheInterfaz.class);

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

    public List<Coche> mostrar(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CocheInterfaz coche = retrofit.create(CocheInterfaz.class);

        Call<ArrayList<Coche>> request = coche.getCoches();
        request.enqueue(new Callback<ArrayList<Coche>>() {
            @Override
            public void onResponse(Call<ArrayList<Coche>> call, Response<ArrayList<Coche>> response) {
                Log.v("XYZresponse", response.body().toString());
                listaCoches = response.body();
                Log.v("XYZlista", listaCoches.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Coche>> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
        Log.v("XYZlista2", listaCoches.toString());
        return listaCoches;
    }

}
