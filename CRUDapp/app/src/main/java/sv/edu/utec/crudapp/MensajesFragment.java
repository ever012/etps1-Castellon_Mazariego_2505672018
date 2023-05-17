package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.crudapp.datos.BaseHelper;
import sv.edu.utec.crudapp.datos.Provedores;
import sv.edu.utec.crudapp.datos.Proveedores;


public class MensajesFragment extends Fragment {

    EditText txtNomProv,txtTelProv,txtCorrProv;
    TextView tvMensajes;
    Button btnGuardar;
    Context context;
    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity =new AppCompatActivity();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_mensajes, container, false);

        View view=inflater.inflate(R.layout.fragment_mensajes, container, false);
        txtNomProv=view.findViewById(R.id.edtNOMPROV);
        txtTelProv=view.findViewById(R.id.edtTELPROV);
        txtCorrProv=view.findViewById(R.id.edtCORPROV);
        btnGuardar=view.findViewById(R.id.btnGuardar);
        tvMensajes=view.findViewById(R.id.tvMensaje);

        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Proveedores baseProv = new Proveedores(context);

                long codiSave=baseProv.insertProveedor(txtNomProv.getText().toString(),txtTelProv.getText().toString(),txtCorrProv.getText().toString());
                if(codiSave>0){
                    tvMensajes.append("Registro insertado");
                }
                else{
                    tvMensajes.append("Error en insertar");
                }
            }
        });

        txtNomProv.setText("Prueba");
        // Inflate the layout for this fragment
        return view;
    }
}