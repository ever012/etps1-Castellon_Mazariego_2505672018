package sv.edu.utec.appsupermercadosprecios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new adaptador_producto(this,getListado());
        recyclerViewProductos.setAdapter(adaptador);

        /*mrecyclerView.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Toast.makeText(getApplicationContext(), "prueba",Toast.LENGTH_LONG).show();
                                             }
                                         });
*/
        /*recyclerViewProductos.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(),"Selecionar",Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/

        recyclerViewProductos.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                // Obtiene la posición del elemento seleccionado
                int position = rv.getChildAdapterPosition(rv.findChildViewUnder(e.getX(), e.getY()));

                // Muestra un mensaje de toast con el elemento seleccionado
                Toast.makeText(rv.getContext(), "Seleccionó " + rv.getAdapter().getItemId(position), Toast.LENGTH_LONG).show();

                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                // No se utiliza
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                // No se utiliza
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