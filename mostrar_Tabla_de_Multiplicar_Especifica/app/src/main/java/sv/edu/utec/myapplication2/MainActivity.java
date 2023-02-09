package sv.edu.utec.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edtValor,edtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValor = findViewById(R.id.edtTabla);
        edtResultado = findViewById(R.id.edtResultado);


    }
    public void Tabla(View v)
    {
        //saber de qué tabla voy a mostrar la informacion
        int valTabla = Integer.parseInt(edtValor.getText().toString());
        int resultados;
        String Resultado="";
        edtResultado.setText(Resultado);
        for(int i=0;i<=10; i++)
        {
            resultados=valTabla*i;
            Resultado = String.valueOf(resultados);
            edtResultado.append(valTabla +"* " +i + "= " + Resultado + "\n");
        }
    }
}