package sv.edu.utec.crudapp.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.crudapp.EntProveedores.EntProveedores;
import sv.edu.utec.crudapp.R;

public class LstProveedoresAdapter extends RecyclerView.Adapter<LstProveedoresAdapter.ProveedoresViewHolder> {

    ArrayList<EntProveedores> listaprove;


    public int LstProveedoresAdapter() {
    return listaprove.size();
    }

    @NonNull
    @Override
    public LstProveedoresAdapter.ProveedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext().inflate(R.layout.lista_proveedores,null,false));
        return new ProveedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstProveedoresAdapter.ProveedoresViewHolder holder, int position) {
        holder.viewNombre.setText(listaprove.get(position).getNOMBPROV());
        holder.ViewTelefono.setText(listaprove.get(position).getTELPROV());
        holder.viewCorreo.setText(listaprove.get(position).getCORPROV());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProveedoresViewHolder extends RecyclerView.ViewHolder{
        TextView viewNombre, ViewTelefono, viewCorreo;

        public ProveedoresViewHolder(View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.edtNOMBPROV);
            ViewTelefono = itemView.findViewById(R.id.edtTELPROV);
            viewCorreo = itemView.findViewById(R.id.edtCORPROV);
        }
    }
}
