package sv.edu.utec.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.menuopciones.clases.CamFragment;
import sv.edu.utec.menuopciones.clases.FavFragment;
import sv.edu.utec.menuopciones.clases.PrincipalFragment;
import sv.edu.utec.menuopciones.clases.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNavi = findViewById(R.id.btnNav);

        btnNavi.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener = new BottomNavigationView.OnNavigationItemSelectedListener () {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    seleccionFrag = new PrincipalFragment();
                    break;
                case R.id.nav_fav:
                    seleccionFrag = new FavFragment();
                    break;
                case R.id.nav_cam:
                    seleccionFrag = new CamFragment();
                    break;
                case R.id.nav_src:
                    seleccionFrag = new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContent, seleccionFrag).commit();

            return true;

        }
    };

    /*metodo para dar vida al menu y que aparezca*/
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items)
    {
        Intent intent = new Intent(this, sumar.class);
        switch (items.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this, "Seleccionó la opcion 1" + 1,Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Seleccionó la opcion 2" + 2,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Seleccionó la opcion 3" + 3,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion4:
                Toast.makeText(this, "Seleccionó la opcion 4" + 4,Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onOptionsItemSelected(items);

    }
}