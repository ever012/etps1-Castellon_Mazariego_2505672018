package sv.edu.utec.crudapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.crudapp.datos.BaseHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra = findViewById(R.id.toolbar);
        drwLayout = findViewById(R.id.drawableLayout);
        navView = findViewById(R.id.navigator);


//24/04/2023
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drwLayout,tlBarra,R.string.open,R.string.close);
        //navView = findViewById(R.id.)

        //el listener es el que nos va a sincronizar con la busqueda
        drwLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white)); //pa que muestre flecha para esconder y mostrar


        BaseHelper basehelper = new BaseHelper(this);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        if(db != null){ //si es distinto a nulo significa que ya existe
            Toast.makeText(this, "base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Error en crear la base de datos", Toast.LENGTH_LONG).show();
        }


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mensaje:
                        drwLayout.closeDrawer(GravityCompat.START); //pa que cierre el menu
                        Toast.makeText(getApplicationContext(),"mensaje",Toast.LENGTH_SHORT).show();
                        fragmentosR(new MensajesFragment());
                        break;
                    case R.id.comentarios:
                        drwLayout.closeDrawer(GravityCompat.START); //pa que cierre el menu
                        Toast.makeText(getApplicationContext(),"comentarios",Toast.LENGTH_SHORT).show();
                        fragmentosR(new ComentariosFragment());
                        break;
                    case R.id.enviar:
                        drwLayout.closeDrawer(GravityCompat.START); //pa que cierre el menu
                        Toast.makeText(getApplicationContext(),"enviar",Toast.LENGTH_SHORT).show();
                        fragmentosR(new EnviarFragment());
                        break;
                    case R.id.compartir:
                        drwLayout.closeDrawer(GravityCompat.START); //pa que cierre el menu
                        Toast.makeText(getApplicationContext(),"compartir",Toast.LENGTH_SHORT).show();
                        fragmentosR(new CompartirFragment());
                        break;
                    case R.id.explorar:
                        drwLayout.closeDrawer(GravityCompat.START); //pa que cierre el menu
                        Toast.makeText(getApplicationContext(),"encontrar",Toast.LENGTH_SHORT).show();
                        fragmentosR(new ExplorarFragment());
                        break;
                }


                return true;
            }
        });
    }

    //esto va a generar los fragmentos de la carpeta recursos
    private void fragmentosR(Fragment fragment){

        //con esta instancia puedo llamar a cada uno de los fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();
    }

}








































