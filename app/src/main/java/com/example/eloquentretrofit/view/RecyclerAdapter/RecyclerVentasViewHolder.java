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

public class RecyclerVentasViewHolder extends RecyclerView.ViewHolder{

    private final ImageView imgCoche;
    private final TextView tvDatos;
    private Button btBorrar;
    public final ConstraintLayout layout;
    private final View view;

    private ViewModel viewModel;

    public RecyclerVentasViewHolder(@NonNull View itemView){
        super(itemView);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) itemView.getContext()).get(ViewModel.class);

        view = itemView;
        this.imgCoche=itemView.findViewById(R.id.imagenVenta);
        this.tvDatos=itemView.findViewById(R.id.tvVenta);
        this.btBorrar = itemView.findViewById(R.id.btBorrarVenta);
        this.layout=itemView.findViewById(R.id.constraintVenta);
    }

    @SuppressLint("ResourceType")
    public void bind(String text, String imagCoche, long id, String matricula,
                     String marca, String modelo, String fecha){
        tvDatos.setText(text);
        Glide.with(view.getContext()).load(imagCoche).into(imgCoche);

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteVenta(id);
            }
        });

    }

    public static RecyclerVentasViewHolder create(ViewGroup parent){
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ventas,parent,false);
        return new RecyclerVentasViewHolder(view);
    }
}
