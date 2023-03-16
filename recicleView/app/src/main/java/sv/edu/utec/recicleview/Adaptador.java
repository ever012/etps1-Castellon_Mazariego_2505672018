package sv.edu.utec.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Elementos> {
    Context contexto;
    ArrayList<Modelo> modelos;//el array lo genero en base al Modelo y le pongo de nombre modelo

    public Adaptador(Context context, ArrayList<Modelo> modelos) {
        this.contexto = context;
        this.modelos = modelos;
    }

    @NonNull
    @Override
    public Elementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto.getApplicationContext()).inflate(R.layout.peliculas_listado,null);
        return new Elementos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Elementos holder, int position) {
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvGenPel.setText(modelos.get(position).getGeneroPeli());
        Elementos.imgPel.setImageResource(modelos.get(position).getImgPeli());
        /*Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());
        Elementos.tvnombrePel.setText(modelos.get(position).getNombrePeli());*/
    }


    @Override
    public int getItemCount() { //para que cuente los items
        return modelos.size();
    }
}




























