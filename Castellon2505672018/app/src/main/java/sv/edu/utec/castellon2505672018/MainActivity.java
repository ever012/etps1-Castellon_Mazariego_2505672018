package sv.edu.utec.castellon2505672018;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.castellon2505672018.clases.principal;
import com.google.android.material.bottomappbar.BottomAppBar;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNavigat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EL PROBLEMA ESTA AL LLAMAR AL ASIGNAR EL BOTON
        //LA BARRA INFERIOR LA SAQUE DE https://m2.material.io/components/app-bars-bottom/android#bottom-app-bar
        btnNavigat = findViewById(R.id.bottomAppBar);

        btnNavigat.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }




    /*MENU INFERIOR*/

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener = new BottomNavigationView.OnNavigationItemSelectedListener () {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;
            switch (item.getItemId()){
                case R.id.home:
                    seleccionFrag = new principal();
                    break;
                case R.id.search:
                    Toast.makeText(getApplicationContext(), "selecciono search",Toast.LENGTH_LONG).show();
                    break;
                case R.id.contact:
                    Toast.makeText(getApplicationContext(), "selecciono search",Toast.LENGTH_LONG).show();
                    break;
                case R.id.config:
                    Toast.makeText(getApplicationContext(), "selecciono search",Toast.LENGTH_LONG).show();
                    break;
            }

            return true;

        }
    };


















    /*metodo para dar vida al menu superior y que aparezca*/
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones,menu);

        return true;
    }
}