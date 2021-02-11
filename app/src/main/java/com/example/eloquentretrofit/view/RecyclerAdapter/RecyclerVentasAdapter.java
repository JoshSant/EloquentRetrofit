package com.example.eloquentretrofit.view.RecyclerAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.eloquentretrofit.R;
import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.model.pojo.Ventas;

public class RecyclerVentasAdapter extends ListAdapter<Ventas, RecyclerVentasViewHolder> {

    public RecyclerVentasAdapter(@NonNull DiffUtil.ItemCallback<Ventas> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerVentasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerVentasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVentasViewHolder holder, int position) {
        Ventas current = getItem(position);
        holder.bind(current.toString(), current.getImagen(), current.getId(),
                current.getMatricula(), current.getMarca(), current.getModelo(), current.getFecha());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("matricula", current.getMatricula());
                bundle.putString("marca", current.getMarca());
                bundle.putString("modelo", current.getModelo());
                bundle.putString("imagen", current.getImagen());
                bundle.putString("fecha", current.getFecha());

                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.consultFragment, bundle);
            }
        });
    }

    public static class VentasDiff extends DiffUtil.ItemCallback<Ventas> {

        @Override
        public boolean areItemsTheSame(@NonNull Ventas oldItem, @NonNull Ventas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Ventas oldItem, @NonNull Ventas newItem) {
            return oldItem.getMatricula().equals(newItem.getMatricula());
        }
    }
}
