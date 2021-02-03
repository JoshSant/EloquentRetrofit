package com.example.eloquentretrofit.model;

import com.example.eloquentretrofit.cochesAplication;
import com.example.eloquentretrofit.model.pojo.coche;

import java.util.List;

public class repository {

    private List<coche> listaCoches;
    private cocheFunctions cocheFunctions;

    public repository() {
        this.cocheFunctions = new cocheFunctions();
    }

    public List<coche> getListaCoches() {
        listaCoches = cocheFunctions.mostrar();
        return listaCoches;
    }

    public void insert(coche c) {
        cochesAplication.threadExecutorPool.execute(new Runnable() {
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

    public void updateUsuario(long id, coche coche){
        new Thread(){
            @Override
            public void run() {
                cocheFunctions.edit(id ,coche);
            }
        }.start();
    }

}
