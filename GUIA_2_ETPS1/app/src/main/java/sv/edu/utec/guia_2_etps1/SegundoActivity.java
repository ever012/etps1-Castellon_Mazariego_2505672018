package sv.edu.utec.guia_2_etps1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundoActivity extends AppCompatActivity {

    //desde aqui
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_apps); //nombre del layour "pantalla2"
    //hasta aqui


    }
    public void layoutIVA(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(SegundoActivity.this, TercerActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }
    public void layoutCalculadoraPolacaInversaApp(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(SegundoActivity.this, CuartoActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }
    public void layoutIDD(View v){
        //CAMBIAR A OTRO LAYOUT
        Intent intent = new Intent(SegundoActivity.this, QuintoActivity.class);
        startActivity(intent);
        //FIN CODIGO
    }

}
