package sv.edu.utec.ever_castellonparcial2_ordinario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    int layout;
    List<String> Empleado;
    List<String> Cargo;
    List<String> Compania;
    int[]pictures;

    public Adaptador(Context contexto, int layout, List<String> empleado, List<String> cargo, List<String> compania, int[] pictures) {
        this.contexto = contexto;
        this.layout = layout;
        Empleado = empleado;
        Cargo = cargo;
        Compania = compania;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return Empleado.size(); //da el tamaño de cada elemento que va a generar
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);
        v = layoutInflater.inflate(R.layout.elemento, null);//lo voy a generar en "elemento"

        TextView txtEmpleado = v.findViewById(R.id.tvNombre);
        txtEmpleado.setText(Empleado.get(position));

        TextView txtCargo = v.findViewById(R.id.tvCargo);
        txtCargo.setText(Cargo.get(position));

        TextView txtCompania = v.findViewById(R.id.tvCompania);
        txtCompania.setText(Compania.get(position));

        ImageView img = v.findViewById(R.id.imgvFotografia);
        img.setImageResource(pictures[position]);


        return v;
    }
}
