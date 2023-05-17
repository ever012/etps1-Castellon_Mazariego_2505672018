package sv.edu.utec.crudapp.datos;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import sv.edu.utec.crudapp.MensajesFragment;

public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASE = "BDTIENDA.db";
    static final String NOMBRE_TABLAPR = "proveedores";
    private static final String NOMBRE_TABLAcl = "t_clientes";
    private static final String NOMBRE_TABLApr = "t_productos";

    public BaseHelper(@Nullable MensajesFragment context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + NOMBRE_TABLAPR + "(" +
            "CODPROV INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NOMBPROV TEXT NOT NULL," +
            "TELPROV TEXT NOT NULL," +
            "CORPROV TEXT NOT NULL"

            + ")");
    }

    //aqui se actualiza la version antigua con la nueva version
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + NOMBRE_TABLAPR);
        onCreate(db);

    }
}
