package com.example.eloquentretrofit.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.coche;
import com.example.eloquentretrofit.model.dao.cocheInterfaz;
import com.example.eloquentretrofit.view.RecyclerAdapter.recyclerAdapter;
import com.example.eloquentretrofit.viewModel.androidViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class firstFragment extends Fragment {

    private Button btInsertar;
    private Button btConsutar;
    private RecyclerView recycler;
    private recyclerAdapter adapter;
    private List<coche> listaCoches = new ArrayList<>();

    private androidViewModel androidViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidViewModel = new ViewModelProvider(this).get(androidViewModel.class);

        btInsertar = view.findViewById(R.id.btInsertar);
        btConsutar = view.findViewById(R.id.btConsultar);
        recycler = view.findViewById(R.id.recyclerView);

        listaCoches = androidViewModel.getListaCoches();

        /*String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheInterfaz coche = retrofit.create(cocheInterfaz.class);

        Call<ArrayList<com.example.eloquentretrofit.model.pojo.coche>> request = coche.getCoches();
        request.enqueue(new Callback<ArrayList<com.example.eloquentretrofit.model.pojo.coche>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.eloquentretrofit.model.pojo.coche>> call, Response<ArrayList<com.example.eloquentretrofit.model.pojo.coche>> response) {
                Log.v("XYZ", response.body().toString());
                listaCoches = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.eloquentretrofit.model.pojo.coche>> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });*/

        btInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(firstFragment.this)
                        .navigate(R.id.InsertFragment);
            }
        });

        btConsutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCoches = androidViewModel.getListaCoches();
                recycler.setHasFixedSize(true);
                adapter = new recyclerAdapter(new recyclerAdapter.CocheDiff());
                Log.v("XYZ", listaCoches.toString());
                adapter.submitList(listaCoches);

                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        });

    }
}