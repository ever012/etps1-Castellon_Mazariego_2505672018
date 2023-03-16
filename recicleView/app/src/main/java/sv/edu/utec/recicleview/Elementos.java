package sv.edu.utec.recicleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder {//ViewHolder permite poner una clase sobre otra
    static ImageView imgPel;
    static TextView tvnombrePel, tvGenPel;
    public Elementos(@NonNull View itemView) {
        super(itemView);

        imgPel = itemView.findViewById(R.id.imvPelicula);
        tvnombrePel = itemView.findViewById(R.id.tvTitulo);
        tvGenPel = itemView.findViewById(R.id.tvGenero);
    }

}
