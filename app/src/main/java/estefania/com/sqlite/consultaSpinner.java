package estefania.com.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import estefania.com.sqlite.entidades.Usuario;
import estefania.com.sqlite.utilidades.Utilidades;

public class consultaSpinner extends AppCompatActivity {

    Spinner comboPersonas;
    TextView txtNombre, txtDoc, txtEdad;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_spinner);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        comboPersonas= findViewById(R.id.combo);

        txtNombre=findViewById(R.id.nombre);
        txtDoc=findViewById(R.id.doc);
        txtEdad=findViewById(R.id.edad);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);
        comboPersonas.setAdapter(adaptador);
    }

    private void  consultarListaPersonas()
    {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario persona=null;
        personasList=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext())
        {
            persona=new Usuario();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setEdad(cursor.getString(2));

            personasList.add(persona);

        }
        obtenerLista();

    }

    private void obtenerLista()
    {
        listaPersonas=new ArrayList<String>();
        listaPersonas.add("Selecciona una opción");

        for(int i=0; i<personasList.size();i++)
        {
            listaPersonas.add(personasList.get(i).getId()+" - "+personasList.get(i).getNombre());
        }
    }
}
