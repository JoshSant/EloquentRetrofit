package com.example.eloquentretrofit.model;

import com.example.eloquentretrofit.CochesAplication;
import com.example.eloquentretrofit.model.pojo.Coche;

import java.util.List;

public class Repository {

    private List<Coche> listaCoches;
    private CocheFunctions cocheFunctions;

    public Repository() {
        this.cocheFunctions = new CocheFunctions();
    }

    public List<Coche> getListaCoches() {
        listaCoches = cocheFunctions.mostrar();
        return listaCoches;
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

}
