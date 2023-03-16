package sv.edu.utec.appsupermercadosprecios;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptador_producto extends RecyclerView.Adapter<elementos_productos> {

    Context contexto;
    ArrayList<modelo_productos> modelos;//el array lo genero en base al Modelo y le pongo de nombre modelo

    public adaptador_producto(Context context, ArrayList<modelo_productos> modelos) {
        this.contexto = context;
        this.modelos = modelos;
    }

    @NonNull
    @Override
    public elementos_productos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto.getApplicationContext()).inflate(R.layout.activity_productos,null);
        return new elementos_productos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull elementos_productos holder, int position) {
        elementos_productos.tvTituloProducto.setText(modelos.get(position).getNombreProducto());
        elementos_productos.imgProducto.setImageResource(modelos.get(position).getImgProducto());
        elementos_productos.tvTituloProducto.setText(modelos.get(position).getPrecioProducto());
    }


    @Override
    public int getItemCount() { //para que cuente los items
        return modelos.size();
    }
}


















































