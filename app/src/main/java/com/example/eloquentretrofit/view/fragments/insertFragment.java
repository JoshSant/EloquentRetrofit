package com.example.eloquentretrofit.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.coche;
import com.example.eloquentretrofit.viewModel.androidViewModel;

public class insertFragment extends Fragment {

    private EditText etMatricula;
    private EditText etMarca;
    private EditText etModelo;
    private EditText etImagen;
    private EditText etCaballos;
    private Button btInsertar;

    private androidViewModel androidViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidViewModel = new ViewModelProvider(this).get(androidViewModel.class);

        etMatricula = view.findViewById(R.id.etInsertMatricula);
        etMarca = view.findViewById(R.id.etInsertMarca);
        etModelo = view.findViewById(R.id.etInsertModelo);
        etImagen = view.findViewById(R.id.etInsertImagen);
        etCaballos = view.findViewById(R.id.etInsertCaballos);
        btInsertar = view.findViewById(R.id.btInsertFrgm);

        btInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etMatricula.getText()) ||
                        TextUtils.isEmpty(etMarca.getText()) ||
                        TextUtils.isEmpty(etModelo.getText()) ||
                        TextUtils.isEmpty(etImagen.getText()) ||
                        TextUtils.isEmpty(etCaballos.getText()) ) {
                    Toast.makeText( v.getContext(),"Rellena todos los campos", Toast.LENGTH_LONG).show();
                }else{

                    String matricula = etMatricula.getText().toString();
                    String marca = etMarca.getText().toString();
                    String modelo = etModelo.getText().toString();
                    String foto = etImagen.getText().toString();
                    int caballos = Integer.parseInt(etCaballos.getText().toString());

                    coche coche = new coche(matricula,marca,modelo,foto,caballos);

                    androidViewModel.insert(coche);

                    /*String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    cocheInterfaz cocheInter = retrofit.create(cocheInterfaz.class);

                    Call<com.example.eloquentretrofit.model.pojo.coche> request = cocheInter.postCoche(coche);
                    request.enqueue(new Callback<com.example.eloquentretrofit.model.pojo.coche>() {
                        @Override
                        public void onResponse(Call<com.example.eloquentretrofit.model.pojo.coche> call, Response<com.example.eloquentretrofit.model.pojo.coche> response) {
                        }

                        @Override
                        public void onFailure(Call<com.example.eloquentretrofit.model.pojo.coche> call, Throwable t) {
                            Log.v("XYZ",t.getMessage());
                        }
                    });*/
                    NavHostFragment.findNavController(insertFragment.this)
                            .navigate(R.id.FirstFragment);
                }
            }
        });

    }
}