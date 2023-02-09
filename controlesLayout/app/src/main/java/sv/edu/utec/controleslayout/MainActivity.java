package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
Spinner spnPais;
EditText edtNombres, edtApellidos,edtInfo;
RadioButton rbFem,rbMas,rbOtr;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombres = findViewById(R.id.edtNombres);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtInfo = findViewById(R.id.edtMultiLine);
        spnPais = findViewById(R.id.spnPais);

        String[]opciones={"Seleccione un Pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panamá"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spnPais.setAdapter(adaptador);
    }

    public void almacenar(View v)
    {
        String datos = "";
        String seleccion = spnPais.getSelectedItem().toString();
        if(seleccion.equals("Seleccione un Pais"))
        {
            datos = "No selecciono ningun pais";
        }
        else{
            if(seleccion.equals("Guatemala"))
            {
                datos = "Guatemala";
                edtInfo.append(datos);
            } else if (seleccion.equals("Guatemala"))
            {
                datos = "Guatemala";
                edtInfo.append(datos);
            }
            edtInfo.append(datos);
            //08/02/2023
        }
    }
}













































