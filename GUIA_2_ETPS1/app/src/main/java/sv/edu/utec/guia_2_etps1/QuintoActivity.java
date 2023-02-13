package sv.edu.utec.guia_2_etps1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuintoActivity extends AppCompatActivity {
    //desde aqui
    EditText edValor;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idd_a_n); //nombre del layour "pantalla2"
        //hasta aqui

        edValor = findViewById(R.id.edtValorN);
        result = findViewById(R.id.tvwRespuestas);

    }
    public void calcular4(View v){
        try{
            Integer valor = Integer.parseInt(edValor.getText().toString());
            Integer calculo1,calculo2,calculo3;
            String resultado;
            calculo1 = valor + 77;
            calculo2 = valor - 3;
            calculo3 = valor * 2;
            resultado = String.valueOf("Valor inicial de N = " + valor + "\n" +
                    "• N + 77 = " + calculo1 + "\n" +
                    "• N - 3 = " + calculo2 + "\n" +
                    "• N * 2 = " + calculo3 + "\n"
            );
            result.setText(resultado);
        }catch(Exception e)
        {
            result.setText("**DEBE INGRESAR UN VALOR NUMERICO");
        }

    }

    public void regresar(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(QuintoActivity.this, SegundoActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }
}
