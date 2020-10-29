package estefania.com.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import estefania.com.sqlite.utilidades.Utilidades;

public class RegistroUsuarios extends AppCompatActivity {

    EditText campoId, campoNombre, campoEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId=findViewById(R.id.id);
        campoNombre=findViewById(R.id.nombre);
        campoEdad=findViewById(R.id.edad);

    }

    public void onClick(View view)
    {
        //registrarUsuarios();
        registrarUsuariosSql();
    }

    private void registrarUsuarios()
    {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues valores=new ContentValues();
        valores.put(Utilidades.ID,campoId.getText().toString());
        valores.put(Utilidades.NOMBRE,campoNombre.getText().toString());
        valores.put(Utilidades.EDAD,campoEdad.getText().toString());


        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.ID,valores);

        Toast.makeText(getApplicationContext(),"Registro #"+idResultante,Toast.LENGTH_SHORT).show();

        db.close();
    }

    private void registrarUsuariosSql()
    {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        String insert = "INSERT INTO " +Utilidades.TABLA_USUARIO+"("+Utilidades.ID+","+Utilidades.NOMBRE+","+Utilidades.EDAD+")VALUES ('"+campoId.getText().toString()+"','"+campoNombre.getText().toString()+"', '"+campoEdad.getText().toString()+"')";
        db.execSQL(insert);


        Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
