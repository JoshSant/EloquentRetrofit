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
import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.view.RecyclerAdapter.RecyclerAdapter;
import com.example.eloquentretrofit.viewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private Button btInsertar;
    private Button btConsutar;
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private List<Coche> listaCoches = new ArrayList<>();

    private ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        btInsertar = view.findViewById(R.id.btInsertar);
        btConsutar = view.findViewById(R.id.btConsultar);
        recycler = view.findViewById(R.id.recyclerView);

        listaCoches = viewModel.getListaCoches();

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
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.InsertFragment);
            }
        });

        btConsutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCoches = viewModel.getListaCoches();
                recycler.setHasFixedSize(true);
                adapter = new RecyclerAdapter(new RecyclerAdapter.CocheDiff());
                Log.v("XYZ", listaCoches.toString());
                adapter.submitList(listaCoches);

                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        });

    }
}