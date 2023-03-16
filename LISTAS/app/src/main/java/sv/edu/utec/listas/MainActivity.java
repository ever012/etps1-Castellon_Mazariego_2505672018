package sv.edu.utec.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lstDias;
ArrayAdapter<CharSequence> adaptador; //necesario para colocar elementos en un listview, este adapter solo aceptará elementos "CharSequence o cadenas de texto"
ArrayAdapter adaptadores;
    ArrayList<String> listaEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDias = findViewById(R.id.lvListaDias);
        //este adaptador crea un recurso y usa los datos de arregloDias pero antes le especifica que es un arreglo
        //"android.R.layout.simple_list_item_1": Es el diseño predeterminado que se utiliza para mostrar los elementos de la lista. En este caso, se utiliza un diseño simple proporcionado
        // por el sistema operativo Android
        /*adaptador = ArrayAdapter.createFromResource(this,R.array.arregloDias,android.R.layout.simple_list_item_1);

        //ahora el listview va a recibir el adaptador
        lstLista.setAdapter(adaptador);*/

        listaEmpleados = new ArrayList<>();
        listaEmpleados.add("Juan");
        listaEmpleados.add("carla");
        listaEmpleados.add("Roberto");
        listaEmpleados.add("Maria");
        listaEmpleados.add("Daniela");
        listaEmpleados.add("José");
        for (int i = 0; i < 100; i++)
        {
            listaEmpleados.add("Jazmin " + i);
        }
        adaptadores = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaEmpleados); //los objetos lo va a obtener del contexto actual y va a llenarse con los datos del arreglo "listaEmpleados"
        lstDias.setAdapter(adaptadores);


        //creo la escucha, que me va a generar cuando de clic a un elemento
        lstDias.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //del parent o pariente es donde obtengo la posicion de lo que hice click
                Toast.makeText(parent.getContext(), "Seleccionó " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }
        });















    }
}