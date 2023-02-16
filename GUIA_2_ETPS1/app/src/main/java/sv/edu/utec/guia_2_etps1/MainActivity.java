package sv.edu.utec.guia_2_etps1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edNombre;
TextView twBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNombre=findViewById(R.id.edtNombre);
        twBienvenida=findViewById(R.id.tvwBienvenida);


    }
    public void mensajeBienvenida(View v){
        System.out.println("Bienvenido " + edNombre.getText());
        Toast mensaje= Toast.makeText(this,"Bienvenido " + edNombre.getText(),Toast.LENGTH_LONG);
        mensaje.show();

        //CAMBIAR A OTRO LAYOUT
            twBienvenida.setText("Bienvenido " + edNombre.getText());
        Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
        startActivity(intent);
        //FIN CODIGO

    }

}