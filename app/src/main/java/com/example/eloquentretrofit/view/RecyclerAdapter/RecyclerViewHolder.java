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
import com.example.eloquentretrofit.viewModel.ViewModel;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private final ImageView imgCoche;
    private final TextView tvDatos;
    private Button btEditar;
    private Button btBorrar;
    public final ConstraintLayout layout;
    private final View view;

    private ViewModel viewModel;

    public RecyclerViewHolder(@NonNull View itemView){
        super(itemView);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) itemView.getContext()).get(ViewModel.class);

        view = itemView;
        this.imgCoche=itemView.findViewById(R.id.imgCoche);
        this.tvDatos=itemView.findViewById(R.id.tvDatos);
        this.btEditar = itemView.findViewById(R.id.btEditar);
        this.btBorrar = itemView.findViewById(R.id.btBorrar);
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
                /*String url="https://informatica.ieszaidinvergeles.org:9038/laravel/miCocheApp/public/api/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                cocheInterfaz coche = retrofit.create(cocheInterfaz.class);

                Call<Boolean> request = coche.deleteCoche(id);

                request.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.v("XYZ", t.getMessage());
                    }
                });*/
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

    }

    public static RecyclerViewHolder create(ViewGroup parent){
            View view= LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_recycler,parent,false);
            return new RecyclerViewHolder(view);
    }
}
