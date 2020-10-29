package estefania.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import estefania.com.sqlite.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //ejecución de query
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    // cada que la app se ejecuta verifica si ya existe una versión de la bd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS usuarios");
    onCreate(db);
    }
}
