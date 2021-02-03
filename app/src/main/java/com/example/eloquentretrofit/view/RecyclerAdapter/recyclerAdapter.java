package com.example.eloquentretrofit.view.RecyclerAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.eloquentretrofit.model.pojo.coche;
import com.example.eloquentretrofit.R;

public class recyclerAdapter extends ListAdapter<coche, recyclerViewHolder> {

    public recyclerAdapter(@NonNull DiffUtil.ItemCallback<coche> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return recyclerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewHolder holder, int position) {
        coche current = getItem(position);
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

    public static class CocheDiff extends DiffUtil.ItemCallback<coche> {

        @Override
        public boolean areItemsTheSame(@NonNull coche oldItem, @NonNull coche newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull coche oldItem, @NonNull coche newItem) {
            return oldItem.getMatricula().equals(newItem.getMatricula());
        }
    }

}
