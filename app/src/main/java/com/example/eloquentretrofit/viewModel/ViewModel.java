package com.example.eloquentretrofit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.Repository;
import com.example.eloquentretrofit.model.pojo.Ventas;

import java.util.List;

public class ViewModel extends androidx.lifecycle.AndroidViewModel {

    private Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public MutableLiveData<List<Coche>> getListaCoches() {
        return repository.getListaCoches();
    }
    public MutableLiveData<List<Ventas>> getListaVentas() {
        return repository.getListaVentas();
    }

    public void insert(Coche c) {
        repository.insert(c);
    }

    public void deleteCoche(long id) {
        repository.deleteCoche(id);
    }

    public void updateUsuario(long id, Coche coche){
        repository.updateUsuario(id, coche);
    }

    public void insertVenta(Ventas v) {
        repository.insertVenta(v);
    }

    public void deleteVenta(long id) {
        repository.deleteVenta(id);
    }
}
