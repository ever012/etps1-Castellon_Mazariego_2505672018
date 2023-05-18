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

public class activity_ClienteVehiculo extends AppCompatActivity {
    EditText edtIdClien, edtIdVehic, edtmatric, edtKilomet;
    Button btnInsert,btnUpdate,btnDelete,btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_vehiculo);


        edtIdClien = findViewById(R.id.edtIdClient3);
        edtIdVehic = findViewById(R.id.edtIdCar);
        edtmatric = findViewById(R.id.edtMatricula);
        edtKilomet = findViewById(R.id.edtKilometros);
        btnInsert = findViewById(R.id.btnInsertar3);
        btnUpdate = findViewById(R.id.btnActualizar3);
        btnDelete = findViewById(R.id.btnEliminar3);
        btnSearch = findViewById(R.id.btnBuscar3);


        btnInsert.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo2", null,1);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String idcliente = edtIdClien.getText().toString();
                String idvehiculo = edtIdVehic.getText().toString();
                String matricula = edtmatric.getText().toString();
                String kilometros = edtKilomet.getText().toString();


                ContentValues informacion = new ContentValues();
                informacion.put("ID_Cliente",idcliente);
                informacion.put("ID_Vehiculo",idvehiculo);
                informacion.put("sMatricula", matricula);
                informacion.put("iKilometros", kilometros);

                try {
                    bd.insert("MD_ClienteVehiculo", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto la informacion", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "No se inserto la informacion"+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        }));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo2",null,2);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String idcliente = edtIdClien.getText().toString();
                String idvehiculo = edtIdVehic.getText().toString();
                String matricula = edtmatric.getText().toString();
                String kilometros = edtKilomet.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("ID_Cliente",idcliente);
                informacion.put("ID_Vehiculo",idvehiculo);
                informacion.put("sMatricula", matricula);
                informacion.put("iKilometros", kilometros);

                int cat=bd.update("MD_ClienteVehiculo",informacion,
                        "ID_Cliente="+idcliente,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico la informacion",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico la informacion",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//ELIMINAR POR ID CLIENTE
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo2",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String idcliente3 = edtIdClien.getText().toString();

                int cat=bd.delete("MD_ClienteVehiculo",
                        "ID_Cliente="+idcliente3,null);
                bd.close();
                edtIdClien.setText("");
                edtIdVehic.setText("");
                edtmatric.setText("");
                edtKilomet.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro la informacion",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro la informacion",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//BUSCAR POR ID
                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "BDClienteVehiculo2",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String idCliente3=edtIdClien.getText().toString();

                Cursor filas=bd.rawQuery("select ID_Vehiculo,sMatricula,iKilometros " +
                        "from MD_ClienteVehiculo where ID_Cliente="+idCliente3,null);

                if(filas.moveToFirst()){
                    edtIdVehic.setText(filas.getString(0));
                    edtmatric.setText(filas.getString(1));
                    edtKilomet.setText(filas.getString(2));
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