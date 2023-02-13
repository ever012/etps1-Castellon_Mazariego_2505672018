package sv.edu.utec.guia_2_etps1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CuartoActivity extends AppCompatActivity {
    Spinner spsignos;
    EditText edNum1,edNum2;
    TextView tvresultado;
    //desde aqui
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadorapolacainversaapp); //nombre del layour "pantalla2"
        //hasta aqui
        edNum1 = findViewById(R.id.edtNum1);
        edNum2 = findViewById(R.id.edtNum2);
        tvresultado = findViewById(R.id.tvwRespuesta);
        spsignos = findViewById(R.id.spnSignos);

        String[]opciones={"Seleccione una Operación","+: suma los dos operandos.","-: resta los operandos.","*: multiplica los operandos.","/: divide los operandos."};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spsignos.setAdapter(adaptador);

    }
    public void calcular2(View v){
        try {
            String resultado = "";
            Double calculo;
            Double numero1 = Double.valueOf(edNum1.getText().toString());
            Double numero2 = Double.valueOf(edNum2.getText().toString());
            String seleccion = spsignos.getSelectedItem().toString();

            switch (seleccion){
                case "Seleccione una Operación":
                    resultado = "No seleccionó ninguna operación";
                    break;
                case "+: suma los dos operandos.":
                    calculo = numero1 + numero2;
                    resultado = "La suma es: " + Integer.valueOf(calculo.intValue());
                    break;
                case "-: resta los operandos.":
                    calculo = numero1 - numero2;
                    resultado = "La resta es: " + Integer.valueOf(calculo.intValue());
                    break;
                case "*: multiplica los operandos.":
                    calculo = numero1 * numero2;
                    resultado = "La multiplicación es: " + Integer.valueOf(calculo.intValue());
                    break;
                case "/: divide los operandos.":
                    calculo = numero1 / numero2;
                    resultado = "La división es: " + String.valueOf(calculo);
                    break;
                default:
                    resultado = "Operación inválida";
            }

            tvresultado.setText(resultado);
        }catch (Exception e)
        {
            tvresultado.setText("*ASEGURESE QUE LOS CAMPOS NO ESTEN VACIOS*");
        }

    }

    public void regresar(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(CuartoActivity.this, SegundoActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }
}
