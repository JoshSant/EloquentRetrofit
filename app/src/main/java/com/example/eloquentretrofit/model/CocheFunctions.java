package com.example.eloquentretrofit.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.eloquentretrofit.model.dao.CocheInterfaz;
import com.example.eloquentretrofit.model.dao.VentasInterfaz;
import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.pojo.Ventas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocheFunctions {

    private String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
    public MutableLiveData<List<Coche>> listaCoches = new MutableLiveData<>();
    public MutableLiveData<List<Ventas>> listaVentas = new MutableLiveData<>();

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
                Log.v("xyz",t.getLocalizedMessage());
                Log.v("xyzCoche", coche.toString());
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

    public void mostrar(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CocheInterfaz coche = retrofit.create(CocheInterfaz.class);

        Call<ArrayList<Coche>> request = coche.getCoches();
        request.enqueue(new Callback<ArrayList<Coche>>() {
            @Override
            public void onResponse(Call<ArrayList<Coche>> call, Response<ArrayList<Coche>> response) {
                try {
                    Log.v("xyzresponse", response.body().toString());
                    listaCoches.setValue(response.body());
                    Log.v("xyzlista", listaCoches.toString());
                }catch (NullPointerException e){
                    Log.v("xyz", "Vacio");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Coche>> call, Throwable t) {
                Log.v("xyz",t.getMessage());
            }
        });
        Log.v("xyzlista2", listaCoches.toString());
    }

    public void insertVenta(Ventas ventas){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VentasInterfaz ventasInterfaz = retrofit.create(VentasInterfaz.class);

        Call<Ventas> request = ventasInterfaz.postVentas(ventas);
        request.enqueue(new Callback<Ventas>() {
            @Override
            public void onResponse(Call<Ventas> call, Response<Ventas> response) {
            }

            @Override
            public void onFailure(Call<Ventas> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
    }

    /*public void editVentas(long id, Ventas ventas){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VentasInterfaz ventasInterfaz = retrofit.create(VentasInterfaz.class);

        Call<Boolean> request = ventasInterfaz.putVentas(id, ventas);
        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("xyz",t.getLocalizedMessage());
                Log.v("xyzCoche", ventas.toString());
            }
        });
    }*/

    public void deleteVentas(long id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VentasInterfaz ventasInterfaz = retrofit.create(VentasInterfaz.class);

        Call<Boolean> request = ventasInterfaz.deleteVentas(id);

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

    public void mostrarVentas(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VentasInterfaz ventas = retrofit.create(VentasInterfaz.class);

        Call<ArrayList<Ventas>> request = ventas.getVentas();
        request.enqueue(new Callback<ArrayList<Ventas>>() {
            @Override
            public void onResponse(Call<ArrayList<Ventas>> call, Response<ArrayList<Ventas>> response) {
                try {
                    Log.v("xyzresponse", response.body().toString());
                    listaVentas.setValue(response.body());
                    Log.v("xyzlista", listaVentas.toString());
                }catch (NullPointerException e){
                    Log.v("xyz", "Vacio");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Ventas>> call, Throwable t) {
                Log.v("xyz",t.getMessage());
            }
        });
        Log.v("xyzlista2", listaCoches.toString());
    }

}
