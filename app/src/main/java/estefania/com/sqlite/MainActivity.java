package estefania.com.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancia de conexión
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        Button btnRegistrar = findViewById(R.id.registrar);
        Button btnConsultar = findViewById(R.id.consultar);
        Button btnConsultarSpinner = findViewById(R.id.spinner);
       Button btnConsultarList = findViewById(R.id.listview);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegistroUsuarios.class);
                startActivityForResult(intent, 0);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), consultar.class);
                startActivityForResult(intent, 0);
            }
        });

        btnConsultarList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), consultaListView.class);
                startActivityForResult(intent, 0);
            }
        });

        btnConsultarSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), consultaSpinner.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}