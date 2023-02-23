package sv.edu.utec.parcial1_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ususario,contrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Estudiante: Ever Enrique Castellón Mazariego 25-0567-2018*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ususario = findViewById(R.id.edtUser);
        contrasenia = findViewById(R.id.edtPass);
    }
    public void login(View v)
    {
        try {
            if(ususario.getText().toString().isEmpty() || contrasenia.getText().toString().isEmpty())
            {
                Toast.makeText(this, "🚩Recuerda llenar los campos", Toast.LENGTH_LONG).show();
            }


            String user = ususario.getText().toString();
            String pass = contrasenia.getText().toString();

            if (user.equals("parcialETps1") && pass.equals("p4rC14l#tp$")) {
                Intent intent = new Intent(MainActivity.this, segundoActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "🚩“contraseña y usuario no son correctos", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "🚩“contraseña y usuario no son correctos", Toast.LENGTH_LONG).show();
        }

    }

}