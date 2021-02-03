package com.example.eloquentretrofit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.eloquentretrofit.model.pojo.coche;
import com.example.eloquentretrofit.model.repository;

import java.util.List;

public class androidViewModel extends AndroidViewModel {

    private repository repository;

    public androidViewModel(@NonNull Application application) {
        super(application);
        repository = new repository();
    }

    public List<coche> getListaCoches() {
        return repository.getListaCoches();
    }

    public void insert(coche c) {
        repository.insert(c);
    }

    public void deleteCoche(long id) {
        repository.deleteCoche(id);
    }

    public void updateUsuario(long id, coche coche){
        repository.updateUsuario(id, coche);
    }
}
