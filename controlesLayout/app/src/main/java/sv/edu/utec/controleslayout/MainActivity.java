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
import android.widget.Toast;

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

        rbFem = findViewById(R.id.rbnFemenino); //R = recursos
        rbMas = findViewById(R.id.rbnMasculino);
        rbOtr = findViewById(R.id.rbnOtros);


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
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");  //ese text1 es un texto temporal
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
        edtInfo.setText(""); //limpio el edit text para una nueva ejecucion
        String datos = "";
        String seleccion = spnPais.getSelectedItem().toString();
        //get traer
        //set enviar
        String nombre = edtNombres.getText().toString();
        String apellidos = edtApellidos.getText().toString();
        String genero = "";
        String info = "";

        if(rbMas.isChecked()==false && rbFem.isChecked()==false && rbOtr.isChecked()==false){
            genero = "Seleccione el registro";
            Toast mensaje = Toast.makeText(this, "🚨 Seleccione un genero",Toast.LENGTH_SHORT);//la informacion a mostrar será bassada en mi conexto actual por eso el "this"
            mensaje.show();

        }

        if(rbMas.isChecked()==true)
        {
            genero = "Masculino";
        } else if(rbFem.isChecked()==true) {
            genero = "Femenino";
        } else if(rbOtr.isChecked()==true) {
            genero = "Otros";
        }


        if(seleccion.equals("Seleccione un Pais"))
        {
            edtInfo.append("No selecciono ningun pais");
        }
        else{
            if(seleccion.equals("Guatemala"))
            {
                datos = "Guatemala";

            } else if (seleccion.equals("Guatemala"))
            {
                datos = "Guatemala";

            }
            else if (seleccion.equals("El Salvador"))
            {
                datos = "El Salvador";

            }
            else if (seleccion.equals("Honduras"))
            {
                datos = "Honduras";

            }
            else if (seleccion.equals("Nicaragua"))
            {
                datos = "Nicaragua";

            }
            else if (seleccion.equals("Costa Rica"))
            {
                datos = "Costa Rica";

            }
            else if (seleccion.equals("Panamá"))
            {
                datos = "Panamá";

            }
            info = "Los datos ingresados son los siguientes: \n" +
                    "Nombre : " + nombre + "\n" +
                    "Apellido : " + apellidos+ "\n" +
                    "Genero : " + genero+ "\n" +
                    "Pais : " + datos;

            edtInfo.append(info);
        }
    }
}













































