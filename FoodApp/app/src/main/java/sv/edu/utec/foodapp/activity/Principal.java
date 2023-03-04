package sv.edu.utec.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import sv.edu.utec.foodapp.R;

public class Principal extends AppCompatActivity {
    TextView tvUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //recibo la informacion del intent del activity_main
        Bundle bundle = getIntent().getExtras();
        tvUsuario = findViewById(R.id.tvwUsuario);
        String informacion = "Hola, " + bundle.getString("usuario");
        tvUsuario.setText(informacion);

    }
}