package sv.edu.utec.ever_castellonparcial4_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activityMenu extends AppCompatActivity {
ImageView imagenCLiente,imagenVehuclo, imagenCV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imagenCLiente = findViewById(R.id.imgClientes);
        imagenVehuclo = findViewById(R.id.imgVehiculos);
        imagenCV = findViewById(R.id.imgCliVeh);

    }

    public void irACliente(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }

    public void irAVehiculo(View v){
        Intent i = new Intent(getApplicationContext(),activity_Vehiculos.class);
        startActivity(i);
    }
    public void irACV(View v){
        Intent i = new Intent(getApplicationContext(),activity_ClienteVehiculo.class);
        startActivity(i);
    }

}