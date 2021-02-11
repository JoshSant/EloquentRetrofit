package com.example.eloquentretrofit.model;

import androidx.lifecycle.MutableLiveData;

import com.example.eloquentretrofit.CochesAplication;
import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.pojo.Ventas;

import java.util.List;

public class Repository {

    private MutableLiveData<List<Coche>> listaCoches;
    private MutableLiveData<List<Ventas>> listaVentas;
    private CocheFunctions cocheFunctions;

    public Repository() {
        this.cocheFunctions = new CocheFunctions();
    }

    public MutableLiveData<List<Coche>> getListaCoches() {
        cocheFunctions.mostrar();
        listaCoches = cocheFunctions.listaCoches;
        return listaCoches;
    }

    public MutableLiveData<List<Ventas>> getListaVentas() {
        cocheFunctions.mostrarVentas();
        listaVentas = cocheFunctions.listaVentas;
        return listaVentas;
    }

    public void insert(Coche c) {
        CochesAplication.threadExecutorPool.execute(new Runnable() {
            @Override
            public void run() {
                cocheFunctions.insert(c);
            }
        });
    }

    public void deleteCoche(long id){
        new Thread(){
            @Override
            public void run() {
                cocheFunctions.delete(id);
            }
        }.start();
    }

    public void updateUsuario(long id, Coche coche){
        new Thread(){
            @Override
            public void run() {
                cocheFunctions.edit(id ,coche);
            }
        }.start();
    }

    public void insertVenta(Ventas v) {
        CochesAplication.threadExecutorPool.execute(new Runnable() {
            @Override
            public void run() {
                cocheFunctions.insertVenta(v);
            }
        });
    }

    public void deleteVenta(long id){
        new Thread(){
            @Override
            public void run() {
                cocheFunctions.deleteVentas(id);
            }
        }.start();
    }

}
