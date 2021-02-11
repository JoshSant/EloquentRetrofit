package com.example.eloquentretrofit.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.pojo.Ventas;
import com.example.eloquentretrofit.view.RecyclerAdapter.RecyclerCochesAdapter;
import com.example.eloquentretrofit.view.RecyclerAdapter.RecyclerVentasAdapter;
import com.example.eloquentretrofit.viewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private Button btInsertar;
    private Button btConsutar;
    private Button btConsutarVentas;
    private RecyclerView recycler;
    private RecyclerCochesAdapter adapterCoches;
    private RecyclerVentasAdapter adapterVentas;
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
        btConsutarVentas = view.findViewById(R.id.btVentas);
        recycler = view.findViewById(R.id.recyclerView);

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
                recycler.setHasFixedSize(true);
                adapterCoches = new RecyclerCochesAdapter(new RecyclerCochesAdapter.CocheDiff());
                Log.v("XYZ", listaCoches.toString());
                viewModel.getListaCoches().observe(getViewLifecycleOwner(), new Observer<List<Coche>>() {
                    @Override
                    public void onChanged(List<Coche> coches) {
                        adapterCoches.submitList(coches);
                        listaCoches = coches;
                    }
                });
                //adapter.submitList(listaCoches);

                recycler.setAdapter(adapterCoches);
                recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        });
        btConsutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler.setHasFixedSize(true);
                adapterVentas = new RecyclerVentasAdapter(new RecyclerVentasAdapter.VentasDiff());
                Log.v("XYZ", listaCoches.toString());
                viewModel.getListaVentas().observe(getViewLifecycleOwner(), new Observer<List<Ventas>>() {
                    @Override
                    public void onChanged(List<Ventas> ventas) {
                        adapterVentas.submitList(ventas);
                        //listaVentas = ventas;
                    }
                });
                //adapter.submitList(listaCoches);

                recycler.setAdapter(adapterVentas);
                recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        });

    }
}