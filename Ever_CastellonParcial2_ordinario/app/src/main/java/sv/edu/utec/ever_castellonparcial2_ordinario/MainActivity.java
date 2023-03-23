package sv.edu.utec.ever_castellonparcial2_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    int[]img; //las imagenes las manejo como enteros
    List<String> Empleado;
    List<String> Cargo;
    List<String> Compania;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lsvEmpleado);

        Empleado = new ArrayList<String>();
        Empleado.add("Alexander Pierrot");
        Empleado.add("Carlos Lopez");
        Empleado.add("Sara Bonz");
        Empleado.add("Liliana Clarence");
        Empleado.add("Benito Peralta");
        Empleado.add("Juan Jaramillo");
        Empleado.add("Christian Steps");
        Empleado.add("Aleza Giraldo");
        Empleado.add("Linda Murillo");
        Empleado.add("Lizeth Astrada");


        Cargo = new ArrayList<String>();
        Cargo.add("CEO");
        Cargo.add("Asistente");
        Cargo.add("Directora de Marketing");
        Cargo.add("Diseñadora de Producto");
        Cargo.add("Supervisor de Ventas");
        Cargo.add("CEO");
        Cargo.add("CTO");
        Cargo.add("Lead Programmer");
        Cargo.add("Directora de Marketing");
        Cargo.add("CEO");

        Compania = new ArrayList<String>();
        Compania.add("Insures S.O.");
        Compania.add("Hospital Blue");
        Compania.add("Electrcal Parts Itd");
        Compania.add("Creativa App");
        Compania.add("Neumáticos Press");
        Compania.add("Banco Nacional");
        Compania.add("Cooperativa Verde");
        Compania.add("Frutisofy");
        Compania.add("Seguros Boliver");
        Compania.add("Concesionario Motolox");

        int [] imagenes = {
                R.drawable.lead_photo_1,
                R.drawable.lead_photo_2,
                R.drawable.lead_photo_3,
                R.drawable.lead_photo_4,
                R.drawable.lead_photo_5,
                R.drawable.lead_photo_6,
                R.drawable.lead_photo_7,
                R.drawable.lead_photo_8,
                R.drawable.lead_photo_9,
                R.drawable.lead_photo_10,
        };


        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        Adaptador adaptador = new Adaptador(this, R.layout.elemento,Empleado,Cargo,Compania,imagenes);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionó " +Empleado.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}