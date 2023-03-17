package sv.edu.utec.appsupermercadosprecios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class _4_listaPrecios extends AppCompatActivity {
    RecyclerView recyclerViewProductos;
    adaptador_producto adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_lista_precios);

        recyclerViewProductos = findViewById(R.id.rvProducto);
        //recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProductos.setLayoutManager(new GridLayoutManager(this,2)); //muestra el recycleview en grid de 2 columnas, el 2 es la cantidad de columnas
        adaptador = new adaptador_producto(this,getListado());
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "seleccionaste: " +
                        getListado().get(recyclerViewProductos.getChildAdapterPosition(view)).getNombreProducto(),
                        Toast.LENGTH_LONG).show();
            }
        });

        recyclerViewProductos.setAdapter(adaptador);


        recyclerViewProductos.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {

                Toast.makeText(getApplicationContext(),"Selecionar",Toast.LENGTH_SHORT).show();

                return false;
            }
        });



    }

    private ArrayList<modelo_productos> getListado(){
        ArrayList<modelo_productos> modelos=new ArrayList<>();
        modelo_productos modelista = new modelo_productos();
        modelista.setNombreProducto("producto1"); //para texto
        modelista.setPrecioProducto("$1.99"); //para texto
        modelista.setImgProducto(R.drawable.market128px); //para imagen
        modelos.add(modelista);


        modelista = new modelo_productos();
        modelista.setNombreProducto("producto2"); //para texto
        modelista.setPrecioProducto("$2.99"); //para texto
        modelista.setImgProducto(R.drawable.market128px); //para imagen
        modelos.add(modelista);

        modelista = new modelo_productos();
        modelista.setNombreProducto("producto3"); //para texto
        modelista.setPrecioProducto("$3.99"); //para texto
        modelista.setImgProducto(R.drawable.market128px); //para imagen
        modelos.add(modelista);

        modelista = new modelo_productos();
        modelista.setNombreProducto("producto4"); //para texto
        modelista.setPrecioProducto("$4.99"); //para texto
        modelista.setImgProducto(R.drawable.market128px); //para imagen
        modelos.add(modelista);

        return modelos;
    }
}