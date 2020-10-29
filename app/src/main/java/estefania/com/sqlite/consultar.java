package estefania.com.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import estefania.com.sqlite.utilidades.Utilidades;

public class consultar extends AppCompatActivity {

    EditText campoId, campoNombre, campoEdad;
    Button btnActualizar, btnEliminar;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        //instancia para la conexión
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        campoId=findViewById(R.id.doc);
        campoNombre=findViewById(R.id.nombre);
        campoEdad=findViewById(R.id.edad);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.buscar:
                consultar();
                break;
            case R.id.actualizar:
                actualizar();
                break;
            case R.id.eliminar:
                eliminar();
                break;
        }
    }

    private void consultar()
    {
        SQLiteDatabase db=conn.getReadableDatabase();

        //parametros de consulta
        String[] parametros={campoId.getText().toString()};

        //campos que va a devolver la consulta
        String[] campos={Utilidades.NOMBRE,Utilidades.EDAD};

        try
        {
            //Estructura para la consulta
            Cursor cursor=db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.ID+"=?",parametros,null,null,null);

            //parar en el primer registro que devuelva
            cursor.moveToFirst();

            //mostrar información en los campos

            campoNombre.setText(cursor.getString(0));
            campoEdad.setText(cursor.getString(1));

            cursor.close();
        }

        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "El documento no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }

    private void limpiar()
    {
        campoNombre.setText("");
        campoEdad.setText("");
    }

    private void actualizar()
    {
        SQLiteDatabase db=conn.getReadableDatabase();

        //parametros de consulta
        String[] parametros={campoId.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(Utilidades.NOMBRE, campoNombre.getText().toString());
        valores.put(Utilidades.EDAD, campoEdad.getText().toString());

        db.update(Utilidades.TABLA_USUARIO, valores,Utilidades.ID+"=?",parametros);
        Toast.makeText(getApplicationContext(), "Registro autorizado", Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void eliminar()
    {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO,Utilidades.ID+"=?",parametros);
        Toast.makeText(getApplicationContext(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
        campoId.setText("");
        limpiar();
        db.close();
    }
}
