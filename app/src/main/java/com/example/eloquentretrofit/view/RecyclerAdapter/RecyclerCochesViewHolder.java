package com.example.eloquentretrofit.view.RecyclerAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.Ventas;
import com.example.eloquentretrofit.viewModel.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecyclerCochesViewHolder extends RecyclerView.ViewHolder{

    private final ImageView imgCoche;
    private final TextView tvDatos;
    private Button btEditar;
    private Button btBorrar;
    private Button btVender;
    public final ConstraintLayout layout;
    private final View view;

    private ViewModel viewModel;

    public RecyclerCochesViewHolder(@NonNull View itemView){
        super(itemView);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) itemView.getContext()).get(ViewModel.class);

        view = itemView;
        this.imgCoche=itemView.findViewById(R.id.imgCoche);
        this.tvDatos=itemView.findViewById(R.id.tvDatos);
        this.btEditar = itemView.findViewById(R.id.btEditar);
        this.btBorrar = itemView.findViewById(R.id.btBorrar);
        this.btVender = itemView.findViewById(R.id.btVender);
        this.layout=itemView.findViewById(R.id.ConstraintLayoutItem);
    }

    @SuppressLint("ResourceType")
    public void bind(String text, String imagCoche, long id, String matricula,
                     String marca, String modelo, int caballos){
            tvDatos.setText(text);
            Glide.with(view.getContext()).load(imagCoche).into(imgCoche);

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteCoche(id);
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("id", id);
                bundle.putString("matricula", matricula);
                bundle.putString("marca", marca);
                bundle.putString("modelo", modelo);
                bundle.putString("foto", imagCoche);
                bundle.putInt("caballos", caballos);

                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.EditFragment, bundle);
            }
        });
        btVender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date = new Date();

                String fecha = dateFormat.format(date);

                Ventas ventas = new Ventas(marca, modelo, matricula, imagCoche, fecha);
                viewModel.insertVenta(ventas);
                viewModel.deleteCoche(id);
            }
        });

    }

    public static RecyclerCochesViewHolder create(ViewGroup parent){
            View view= LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_recycler,parent,false);
            return new RecyclerCochesViewHolder(view);
    }
}
