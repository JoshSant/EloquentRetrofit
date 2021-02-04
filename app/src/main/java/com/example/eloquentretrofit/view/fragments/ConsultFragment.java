package com.example.eloquentretrofit.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eloquentretrofit.R;

public class ConsultFragment extends Fragment {

    private TextView tvMatricula;
    private TextView tvMarca;
    private TextView tvModelo;
    private TextView tvCaballos;
    private ImageView imgCoche;
    private Button btVolver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvMatricula = view.findViewById(R.id.tvMatricula);
        tvMarca = view.findViewById(R.id.tvMarca);
        tvModelo = view.findViewById(R.id.tvModelo);
        tvCaballos = view.findViewById(R.id.tvCaballos);
        imgCoche = view.findViewById(R.id.imgCocheFrgm);
        btVolver = view.findViewById(R.id.btVolver);

        String matricula = getArguments().getString("matricula");
        String marca = getArguments().getString("marca");
        String modelo = getArguments().getString("modelo");
        String caballos = String.valueOf(getArguments().getInt("caballos"));
        String imagen = getArguments().getString("imagen");

        tvMatricula.setText(matricula);
        tvMarca.setText(marca);
        tvModelo.setText(modelo);
        tvCaballos.setText(caballos);
        Glide.with(view.getContext()).load(imagen).into(imgCoche);

        NavController navController = Navigation.findNavController(view);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.FirstFragment);
            }
        });
    }
}