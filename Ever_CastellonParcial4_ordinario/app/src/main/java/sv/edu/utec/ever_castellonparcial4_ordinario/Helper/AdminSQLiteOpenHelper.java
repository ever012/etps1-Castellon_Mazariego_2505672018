package sv.edu.utec.ever_castellonparcial4_ordinario.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="BDClienteVehiculo.db";

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS MD_Clientes (ID_Cliente int primary key, " +
                "sNombreCliente text, sApellidosCliente text,sDireccionCliente text,sCiudadCliente text)");

        db.execSQL("CREATE TABLE IF NOT EXISTS MD_Vehiculos (ID_Vehiculo int primary key, " +
                "sMarca text, sModelo text)");

        db.execSQL("CREATE TABLE IF NOT EXISTS MD_ClienteVehiculo (ID_Cliente int, " +
                "ID_Vehiculo int, sMatricula text, iKilometros text," +
                "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente)," +
                "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculos(ID_Vehiculo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Aquí puedes escribir el código para manejar las actualizaciones de la base de datos
        // según la versión antigua (oldVersion) y la nueva versión (newVersion).
        // Puedes usar estructuras condicionales como if o switch para determinar qué cambios realizar.

        // Ejemplo de código para una actualización de la versión 1 a la versión 2:
        if (oldVersion == 1 && newVersion == 2) {
            // Agrega una nueva columna a la tabla MD_Vehiculos
            db.execSQL("ALTER TABLE MD_Vehiculos ADD COLUMN sColor TEXT");
        }

        // Ejemplo de código para una actualización de la versión 2 a la versión 3:
        if (oldVersion == 2 && newVersion == 3) {
            // Elimina la tabla MD_ClienteVehiculo y crea una nueva tabla con cambios
            db.execSQL("DROP TABLE IF EXISTS MD_ClienteVehiculo");
            db.execSQL("CREATE TABLE MD_ClienteVehiculo (ID_Cliente INTEGER, " +
                    "ID_Vehiculo INTEGER, sMatricula TEXT, iKilometros TEXT, " +
                    "sFechaRegistro TEXT, " +
                    "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente), " +
                    "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculos(ID_Vehiculo))");
        }

        // ... Puedes agregar más bloques de código según tus necesidades

        // Recuerda que debes asegurarte de mantener la integridad de los datos
        // durante las actualizaciones de la base de datos.
    }
}
