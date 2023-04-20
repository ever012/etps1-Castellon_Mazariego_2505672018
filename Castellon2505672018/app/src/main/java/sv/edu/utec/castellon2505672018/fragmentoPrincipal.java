package sv.edu.utec.castellon2505672018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.castellon2505672018.Helper.AdminSQLiteOpenHelper;

public class fragmentoPrincipal extends AppCompatActivity {
    EditText txtcontac, txtNombre, txtApellido, txtTelefono, txtCorreo;
    Button btnInserts, btnUdates, btnDeletes,btnBuscar,btnBuscarNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_principal);

        txtcontac = findViewById(R.id.edtCod);
        txtNombre = findViewById(R.id.edtNombre);
        txtApellido = findViewById(R.id.edtApellido);
        txtTelefono = findViewById(R.id.edtTelefono);
        txtCorreo = findViewById(R.id.edtCorreo);
        btnInserts = findViewById(R.id.btnInsert);
        btnUdates = findViewById(R.id.btnUpdate);
        btnDeletes = findViewById(R.id.btnDelete);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscarNombre = findViewById(R.id.btnBuscarNom);

        btnInserts.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial", null,1);

                SQLiteDatabase bd= admin.getWritableDatabase();
                String contac = txtcontac.getText().toString();
                String nom = txtNombre.getText().toString();
                String ape = txtApellido.getText().toString();
                String tel = txtTelefono.getText().toString();
                String corr = txtCorreo.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("codContac",contac); //codProducto es el nombre del campo en db en "AdminSQliteOpenHelper", y cod es la variable
                informacion.put("Nombre",nom);
                informacion.put("Apellidos",ape);
                informacion.put("Teléfono", tel);
                informacion.put("Correo", corr);


                try {
                    bd.insert("Contactos", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto", Toast.LENGTH_LONG).show();
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
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String contac = txtcontac.getText().toString();
                String nom = txtNombre.getText().toString();
                String ape = txtApellido.getText().toString();
                String tel = txtTelefono.getText().toString();
                String corr = txtCorreo.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("codContac",contac); //codProducto es el nombre del campo en db en "AdminSQliteOpenHelper", y cod es la variable
                informacion.put("Nombre",nom);
                informacion.put("Apellidos",ape);
                informacion.put("Teléfono", tel);
                informacion.put("Correo", corr);



                int cat=bd.update("Contactos",informacion,
                        "codContac="+contac,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtcontac.getText().toString();

                int cat=bd.delete("Contactos",
                        "codContac="+cod,null);
                bd.close();
                txtcontac.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtTelefono .setText("");
                txtCorreo.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro",Toast.LENGTH_LONG).show();

                }
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String cod=txtcontac.getText().toString();

                Cursor filas=bd.rawQuery("select descripProd,precioProd " +
                        "from Contactos where codProducto="+cod,null);

                if(filas.moveToFirst()){
                    txtNombre.setText(filas.getString(0));
                    txtApellido.setText(filas.getString(1));
                    txtTelefono .setText(filas.getString(2));
                    txtCorreo.setText(filas.getString(3));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });



        btnBuscarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String des=txtNombre.getText().toString();

                Cursor filas = bd.rawQuery("select codProducto,descripProd,precioProd " +
                        "from Contactos where descripProd='"+des+"'",null);

                if(filas.moveToFirst()){
                    txtcontac.setText(filas.getString(0));
                    txtNombre.setText(filas.getString(1));
                    txtApellido.setText(filas.getString(2));
                    txtTelefono .setText(filas.getString(3));
                    txtCorreo.setText(filas.getString(4));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });
    }
}