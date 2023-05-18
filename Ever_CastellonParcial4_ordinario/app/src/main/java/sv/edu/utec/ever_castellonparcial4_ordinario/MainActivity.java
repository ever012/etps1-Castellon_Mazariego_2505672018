package sv.edu.utec.ever_castellonparcial4_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.ever_castellonparcial4_ordinario.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText edtId,edtNombre,edtApellido,EdtDireccion,edtCiudad;
Button btnInsert,btnUpdate,btnDelete,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtIdCliente);
        edtNombre = findViewById(R.id.edtNombreCliente);
        edtApellido = findViewById(R.id.edtApellidoCliente);
        EdtDireccion = findViewById(R.id.edtDireccionCliente);
        edtCiudad = findViewById(R.id.edtCiudadCliente);
        btnInsert = findViewById(R.id.btnInsertar);
        btnUpdate = findViewById(R.id.btnActualizar);
        btnDelete = findViewById(R.id.btnEliminar);
        btnSearch = findViewById(R.id.btnBuscar);




        btnInsert.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo", null,1);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();
                String name = edtNombre.getText().toString();
                String lastname = edtApellido.getText().toString();
                String address = EdtDireccion.getText().toString();
                String city = edtCiudad.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("ID_Cliente",id);
                informacion.put("sNombreCliente",name);
                informacion.put("sApellidosCliente", lastname);
                informacion.put("sDireccionCliente", address);
                informacion.put("sCiudadCliente", city);

                try {
                    bd.insert("MD_Clientes", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto el cliente", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        }));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo",null,2);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();
                String name = edtNombre.getText().toString();
                String lastname = edtApellido.getText().toString();
                String address = EdtDireccion.getText().toString();
                String city = edtCiudad.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("ID_Cliente",id);
                informacion.put("sNombreCliente",name);
                informacion.put("sApellidosCliente", lastname);
                informacion.put("sDireccionCliente", address);
                informacion.put("sCiudadCliente", city);

                int cat=bd.update("MD_Clientes",informacion,
                        "ID_Cliente="+id,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el cliente",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el cliente",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();

                int cat=bd.delete("MD_Clientes",
                        "ID_Cliente="+id,null);
                bd.close();
                edtId.setText("");
                edtNombre.setText("");
                edtApellido.setText("");
                EdtDireccion.setText("");
                edtCiudad.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el cliente",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el cliente",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//BUSCAR POR ID
                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "BDClienteVehiculo",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String idCliente=edtId.getText().toString();

                Cursor filas=bd.rawQuery("select sNombreCliente,sApellidosCliente,sDireccionCliente," +
                        "sCiudadCliente " + "from MD_Clientes where ID_Cliente="+idCliente,null);

                if(filas.moveToFirst()){
                    edtNombre.setText(filas.getString(0));
                    edtApellido.setText(filas.getString(1));
                    EdtDireccion.setText(filas.getString(2));
                    edtCiudad.setText(filas.getString(3));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el cliente",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });
    }
}