package com.example.eloquentretrofit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.Repository;

import java.util.List;

public class AndroidViewModel extends androidx.lifecycle.AndroidViewModel {

    private Repository repository;

    public AndroidViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public List<Coche> getListaCoches() {
        return repository.getListaCoches();
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
}
