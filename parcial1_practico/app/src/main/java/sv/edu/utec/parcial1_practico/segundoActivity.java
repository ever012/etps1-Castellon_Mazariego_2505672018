package sv.edu.utec.parcial1_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class segundoActivity extends AppCompatActivity {
    /*Estudiante: Ever Enrique Castellón Mazariego 25-0567-2018*/
    TextView rsultados;
    EditText peso,altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        rsultados = findViewById(R.id.tvwResultados);
        peso = findViewById(R.id.edtpeso);
        altura = findViewById(R.id.edtAltura);
    }
    public void calcularIMC(View v)
    {
        try {
            Double IMC;
            Double alto = Double.parseDouble(altura.getText().toString());
            Double pesoo = Double.parseDouble(peso.getText().toString());

            IMC = (pesoo)/(alto*alto);

            if (IMC < 10.5) {
                rsultados.setText("Críticamente Bajo de Peso");
            } else if (IMC < 15.9) {
                rsultados.setText("Severamente Bajo de Peso");
            } else if (IMC < 18.5) {
                rsultados.setText("Bajo de Peso");
            } else if (IMC < 25) {
                rsultados.setText("Normal (peso saludable)");
            } else if (IMC < 30) {
                rsultados.setText("Sobrepeso");
            } else if (IMC < 35) {
                rsultados.setText("Obesidad Clase 1 - Moderadamente Obeso");
            } else if (IMC < 40) {
                rsultados.setText("Obesidad Clase 2 - Severamente Obeso");
            } else if (IMC > 40) {
                rsultados.setText("Obesidad Clase 3 - Críticamente Obeso");
            } else {
                rsultados.setText("Recuerda llenar los campos de forma correcta we");
            }
        }catch(Exception e){
            rsultados.setText("Recuerda llenar los campos");
        }

    }
}