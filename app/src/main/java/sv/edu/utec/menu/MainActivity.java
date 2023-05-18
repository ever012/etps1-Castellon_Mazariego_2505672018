package sv.edu.utec.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView.OnNavigationItemSelectedListener {item ->
                when(item.itemId) {
            R.id.item1 -> {
                // Respond to navigation item 1 click
                true
            }
            R.id.item2 -> {
                // Respond to navigation item 2 click
                true
            }
        else -> false
        }
        }


    }


}