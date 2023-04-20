package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText txtCodProd, txtDesc, txtPrecio;
Button btnInserts, btnUdates, btnDeletes,btnBuscar,btnBuscardescription;

    //bodega es el nombre de la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodProd = findViewById(R.id.edtCodProd);
        txtDesc = findViewById(R.id.edtDescript);
        txtPrecio = findViewById(R.id.edtPrecio);
        btnInserts = findViewById(R.id.btnInsert);
        btnUdates = findViewById(R.id.btnUpdate);
        btnDeletes = findViewById(R.id.btnDelete);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscardescription = findViewById(R.id.btnBuscarDes);

        btnInserts.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega", null,1);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod = txtCodProd.getText().toString();
                String des = txtDesc.getText().toString();
                String pre = txtPrecio.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("codProducto",cod); //codProducto es el nombre del campo en db en "AdminSQliteOpenHelper", y cod es la variable
                informacion.put("descripProd",des);
                informacion.put("precioProd", pre);


                try {
                    bd.insert("productos", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto el producto", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    //pendiente imprimir error
                    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        }));


        btnUdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtCodProd.getText().toString();
                String des=txtDesc.getText().toString();
                String pre=txtPrecio.getText().toString();
                ContentValues informacion =new ContentValues();
                informacion.put("codProducto",cod);
                informacion.put("descripProd",des);
                informacion.put("precioProd",pre);

                int cat=bd.update("productos",informacion,
                        "codProducto="+cod,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el producto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el producto",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtCodProd.getText().toString();

                int cat=bd.delete("productos",
                        "codProducto="+cod,null);
                bd.close();
                txtCodProd.setText("");
                txtDesc.setText("");
                txtPrecio.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el producto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el producto",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String cod=txtCodProd.getText().toString();

                Cursor filas=bd.rawQuery("select descripProd,precioProd " +
                        "from productos where codProducto="+cod,null);

                if(filas.moveToFirst()){
                    txtDesc.setText(filas.getString(0));
                    txtPrecio.setText(filas.getString(1));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });



        btnBuscardescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String des=txtDesc.getText().toString();

                Cursor filas = bd.rawQuery("select codProducto,descripProd,precioProd " +
                        "from productos where descripProd='"+des+"'",null);

                if(filas.moveToFirst()){
                    txtCodProd.setText(filas.getString(0));
                    txtDesc.setText(filas.getString(1));
                    txtPrecio.setText(filas.getString(2));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });
    }
}























