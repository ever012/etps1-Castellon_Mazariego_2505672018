package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

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

        // FORMA 1
        /*String[]opciones={"Seleccione un Pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panamá"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spnPais.setAdapter(adaptador);

         */

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){

            public View getView(int position, View contenido, ViewGroup parent)
            {
                View vista=super.getView(position,contenido,parent); //voy a heredar de la vista es decir una llamada recursiva
                if(position == getCount()){
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");
                    ((TextView)vista.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }
                return vista;

            }
            public int getCount() {
                return super.getCount()-1; //le digo que se llame el solo
            }

        };

        //llenando adaptador
        //esto se aplica por ejemplo para base de datos
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptador.add("Guatemala");
        adaptador.add("El Salvador");
        adaptador.add("Honduras");
        adaptador.add("Nicaragua");
        adaptador.add("Costa Rica");
        adaptador.add("Panamá");
        adaptador.add("Seleccione un Pais"); //Este es el elemento a quitar del spinner
        spnPais.setAdapter(adaptador);
        spnPais.setSelection(adaptador.getCount());


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













































