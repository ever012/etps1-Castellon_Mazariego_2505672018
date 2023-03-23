package sv.edu.utec.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView lista;
List<String> descrip;
int[]img; //las imagenes las manejo como enteros
List<String> peliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lsvPelicula);

        peliculas = new ArrayList<String>();
        peliculas.add("Ex Maquina");
        peliculas.add("Extraordinario");
        peliculas.add("Forma de Agua");
        peliculas.add("Interstelar");
        peliculas.add("Jumanji");
        peliculas.add("La llegada");

        descrip = new ArrayList<String>();
        descrip.add("es una pelicula de accion");
        descrip.add("es una pelicula de ficcion");
        descrip.add("es una pelicula de entretenimiento");
        descrip.add("es una pelicula de espacio");
        descrip.add("es una pelicula de Infantil");
        descrip.add("es una pelicula de Accion");

        int [] pictures = {
                R.drawable.imagen1,
                R.drawable.imagen2,
                R.drawable.imagen3,
                R.drawable.imagen4,
                R.drawable.imagen5,
                R.drawable.imagen6,
        };


        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        Adaptador adaptador = new Adaptador(this, R.layout.elemento,peliculas,descrip,pictures);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionó " +peliculas.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}























