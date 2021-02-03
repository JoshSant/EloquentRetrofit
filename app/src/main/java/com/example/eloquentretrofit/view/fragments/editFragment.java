package com.example.eloquentretrofit.view.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.coche;
import com.example.eloquentretrofit.viewModel.androidViewModel;

public class editFragment extends Fragment {

    private EditText etMatricula;
    private EditText etMarca;
    private EditText etModelo;
    private EditText etImagen;
    private EditText etCaballos;
    private Button btEditar;

    private androidViewModel androidViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidViewModel = new ViewModelProvider(this).get(androidViewModel.class);

        etMatricula = view.findViewById(R.id.etEditMatricula);
        etMarca = view.findViewById(R.id.etEditMarca);
        etModelo = view.findViewById(R.id.etEditModelo);
        etImagen = view.findViewById(R.id.etEditImagen);
        etCaballos = view.findViewById(R.id.etEditCaballos);
        btEditar = view.findViewById(R.id.btEditarFrgm);

        long id = getArguments().getLong("id");
        String matricula = getArguments().getString("matricula");
        String marca = getArguments().getString("marca");
        String modelo = getArguments().getString("modelo");
        String imagen = getArguments().getString("foto");
        String caballos = String.valueOf(getArguments().getInt("caballos"));

        etMatricula.setText(matricula);
        etMarca.setText(marca);
        etModelo.setText(modelo);
        etImagen.setText(imagen);
        etCaballos.setText(caballos);

        view.findViewById(R.id.btEditarFrgm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etMatricula.getText()) ||
                        TextUtils.isEmpty(etMarca.getText()) ||
                        TextUtils.isEmpty(etModelo.getText()) ||
                        TextUtils.isEmpty(etImagen.getText()) ||
                        TextUtils.isEmpty(etCaballos.getText()) ) {
                    Toast.makeText( view.getContext(),"Rellena todos los campos", Toast.LENGTH_LONG).show();
                }else{

                    String matricula = etMatricula.getText().toString();
                    String marca = etMarca.getText().toString();
                    String modelo = etModelo.getText().toString();
                    String foto = etImagen.getText().toString();
                    int caballos = Integer.parseInt(etCaballos.getText().toString());

                    coche coche = new coche(matricula,marca,modelo,foto,caballos);

                    androidViewModel.updateUsuario(id, coche);

                    /*String url = "https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    cocheInterfaz cocheInter = retrofit.create(cocheInterfaz.class);

                    Call<Boolean> request = cocheInter.putCoche(id, coche);
                    request.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Log.v("XYZ",t.getLocalizedMessage());
                            Log.v("XYZCoche", coche.toString());
                        }
                    });*/
                    NavHostFragment.findNavController(editFragment.this)
                            .navigate(R.id.FirstFragment);
                }
            }
        });
    }
}