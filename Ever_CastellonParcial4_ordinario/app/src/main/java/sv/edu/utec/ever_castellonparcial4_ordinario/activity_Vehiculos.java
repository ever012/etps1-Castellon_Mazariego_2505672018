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

public class activity_Vehiculos extends AppCompatActivity {
    EditText edtId, edtMarca, edtModelo;
    Button btnInsert,btnUpdate,btnDelete,btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculos);

        edtId = findViewById(R.id.edtIdVehiculo);
        edtMarca = findViewById(R.id.edtMarca);
        edtModelo = findViewById(R.id.edtModelo);
        btnInsert = findViewById(R.id.btnInsertar2);
        btnUpdate = findViewById(R.id.btnActualizar2);
        btnDelete = findViewById(R.id.btnEliminar2);
        btnSearch = findViewById(R.id.btnBuscar2);


        btnInsert.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo1", null,1);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();
                String mark = edtMarca.getText().toString();
                String model = edtModelo.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("ID_Vehiculo",id);
                informacion.put("sMarca",mark);
                informacion.put("sModelo", model);

                try {
                    bd.insert("MD_Vehiculos", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto el Vehiculo", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "No se inserto el Vehiculo"+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        }));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo1",null,2);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();
                String mark = edtMarca.getText().toString();
                String model = edtModelo.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("ID_Vehiculo",id);
                informacion.put("sMarca",mark);
                informacion.put("sModelo", model);

                int cat=bd.update("MD_Vehiculos",informacion,
                        "ID_Vehiculo="+id,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el Vehiculo",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el Vehiculo",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"BDClienteVehiculo1",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String id = edtId.getText().toString();

                int cat=bd.delete("MD_Vehiculos",
                        "ID_Vehiculo="+id,null);
                bd.close();
                edtId.setText("");
                edtMarca.setText("");
                edtModelo.setText("");


                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el Vehiculo",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el Vehiculo",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//BUSCAR POR ID
                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "BDClienteVehiculo1",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String idVehiculo = edtId.getText().toString();

                Cursor filas=bd.rawQuery("select sMarca,sModelo " +
                        "from MD_Vehiculos where ID_Vehiculo="+idVehiculo,null);

                if(filas.moveToFirst()){
                    edtMarca.setText(filas.getString(0));
                    edtModelo.setText(filas.getString(1));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el Vehiculo",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });


    }
}