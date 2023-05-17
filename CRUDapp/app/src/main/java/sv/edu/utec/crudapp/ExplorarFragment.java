package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sv.edu.utec.crudapp.Adaptadores.LstProveedoresAdapter;
import sv.edu.utec.crudapp.EntProveedores.EntProveedores;
import sv.edu.utec.crudapp.datos.Proveedores;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExplorarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExplorarFragment extends Fragment {
RecyclerView listaProveedores;
Context context;
ArrayList<EntProveedores> AListProve;

    public ExplorarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_explorar, container, false);
        listaProveedores = view.findViewById(R.id.rcvLstProveedores);

        listaProveedores.setLayoutManager(new LinearLayoutManager(context));

        Proveedores dbProve = new Proveedores(context);

        AListProve = new ArrayList<>();

        LstProveedoresAdapter adapter = new LstProveedoresAdapter(dbProve.mostrarProveedores());
        listaProveedores.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}