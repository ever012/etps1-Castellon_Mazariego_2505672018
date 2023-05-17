package sv.edu.utec.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.crudapp.EntProveedores.EntProveedores;
import sv.edu.utec.crudapp.MensajesFragment;

public class Proveedores extends BaseHelper {
    MensajesFragment context;
    public Proveedores(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    /*
     "CODPROV INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NOMBPROV TEXT NOT NULL," +
            "TELPROV TEXT NOT NULL," +
            "CORPROV TEXT NOT NULL"
     */

    public long insertProveedor(String NOMBPROV, String TELPROV, String CORPROV) {
        long codigo = 0;
        try{
            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();
            valoresProv.put("NOMBPROV", NOMBPROV);
            valoresProv.put("TELPROV", TELPROV);
            valoresProv.put("CORPROV", CORPROV);

            codigo = bd.insert(NOMBRE_TABLAPR, null, valoresProv);
            return codigo;
        }catch (Exception ex){
            ex.toString();
        }

        return codigo;
    }
    public ArrayList<EntProveedores> mostrarProveedores(){
        BaseHelper basehelper = new BaseHelper(context);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        ArrayList<EntProveedores> listarProveedores = new ArrayList<>();
        EntProveedores entProveedores = null;
        Cursor cursorProveedor;

        cursorProveedor = db.rawQuery("SELECT CODPROV,NOMBPROV,TELPROV,CORPROV FROM " + NOMBRE_TABLAPR, null);
        if(cursorProveedor.moveToFirst())
        {
            do{
                entProveedores = new EntProveedores();
                entProveedores.getCODPROV(cursorProveedor.getInt(0));
                entProveedores.getNOMBPROV(cursorProveedor.getString(1));
                entProveedores.getTELPROV(cursorProveedor.getString(2));
                entProveedores.getCORPROV(cursorProveedor.getString(3));
                listarProveedores.add(entProveedores);

                //EL INGENIERO COMPLETO ESTE PROYECTO ASI QUE DE AHI SACARLO :(
            }
            while (cursorProveedor.moveToNext());
        }
        cursorProveedor.close();
        return listarProveedores;
    }

}
