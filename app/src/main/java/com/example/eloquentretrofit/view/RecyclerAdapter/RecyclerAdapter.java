package com.example.eloquentretrofit.view.RecyclerAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.eloquentretrofit.model.pojo.Coche;
import com.example.eloquentretrofit.R;

public class RecyclerAdapter extends ListAdapter<Coche, RecyclerViewHolder> {

    public RecyclerAdapter(@NonNull DiffUtil.ItemCallback<Coche> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Coche current = getItem(position);
        holder.bind(current.toString(), current.getImagen(), current.getId(),
                current.getMatricula(), current.getMarca(), current.getModelo(), current.getCaballos());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("matricula", current.getMatricula());
                bundle.putString("marca", current.getMarca());
                bundle.putString("modelo", current.getModelo());
                bundle.putString("imagen", current.getImagen());
                bundle.putInt("caballos", current.getCaballos());

                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.consultFragment, bundle);
            }
        });
    }

    public static class CocheDiff extends DiffUtil.ItemCallback<Coche> {

        @Override
        public boolean areItemsTheSame(@NonNull Coche oldItem, @NonNull Coche newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Coche oldItem, @NonNull Coche newItem) {
            return oldItem.getMatricula().equals(newItem.getMatricula());
        }
    }

}
