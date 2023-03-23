package sv.edu.utec.listview;

import android.content.Context;
import android.text.Layout;
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
    List<String> pelicula;
    List<String> descrip;
    int[]pictures;
//en el contexto agrego todos los elementos que quiero que vaya a recibir

    public Adaptador(Context contexto, int layout, List<String> pelicula, List<String> descrip, int[] imagenes) {
        this.contexto = contexto;
        this.layout = layout;
        this.pelicula = pelicula;
        this.descrip = descrip;
        this.pictures = imagenes;
    }

    @Override
    public int getCount() {
        return pelicula.size(); //da el tamaño de cada elemento que va a generar
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

        TextView txtPeli = v.findViewById(R.id.textView);
        txtPeli.setText(pelicula.get(position));

        TextView txtDescrip = v.findViewById(R.id.textView2);
        txtDescrip.setText(descrip.get(position));

        ImageView img = v.findViewById(R.id.imageView1);
        img.setImageResource(pictures[position]);


        return null;
    }
}
