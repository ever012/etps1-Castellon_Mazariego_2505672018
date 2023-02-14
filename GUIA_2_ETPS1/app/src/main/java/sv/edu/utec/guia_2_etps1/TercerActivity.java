package sv.edu.utec.guia_2_etps1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class TercerActivity extends AppCompatActivity {
    EditText precio_prod;
    TextView resultado;
    //desde aqui
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2); //nombre del layour "pantalla2"
        //hasta aqui

        precio_prod = findViewById(R.id.edtPrecio);
        resultado = findViewById(R.id.tvwResultado);

    }
    public void calcular(View v){
        try{
            resultado.setText("");
            Double precio = Double.parseDouble(precio_prod.getText().toString());
            Double calculoIVA;
            Double IVA = 0.134; //13.4%
            String resul = "";
            DecimalFormat df = new DecimalFormat("0.00"); //Especifico que la salida de un formato con solo 2 decimales
                calculoIVA =  precio * IVA;
                resul = String.valueOf(precio + calculoIVA);
                resultado.append("El IVA es de: $" + df.format(calculoIVA) + "\n");
                resultado.append("El precio final con IVA: $" + df.format(Double.valueOf(resul))); //lo convierto a double porque sino me da error
        }catch (Exception e)
        {
            resultado.setText("Debe introducir el precio del producto");
        }

    }

    public void regresar(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(TercerActivity.this, SegundoActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }
}
