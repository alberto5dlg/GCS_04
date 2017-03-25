package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class Perfil extends AppCompatActivity{

    private TextView nombre;
    private TextView usuario;
    private TextView email;
    private TextView edad;
    private TextView ciudad;
    private TextView pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (TextView) findViewById(R.id.textView19);
        usuario = (TextView) findViewById(R.id.textView21);
        email = (TextView) findViewById(R.id.textView24);
        edad = (TextView) findViewById(R.id.textView26);
        ciudad = (TextView) findViewById(R.id.textView28);
        pais = (TextView) findViewById(R.id.textView30);



        Intent intent = getIntent();
        Bundle extras;
        extras = intent.getExtras();
        if(extras != null ) {
            nombre.setText(extras.get("nombre") + " " + extras.get("apellidos"));
            usuario.setText((String) extras.get("nombreUsuario"));
            email.setText((String) extras.get("email"));
            edad.setText((String) extras.get("edad"));
            ciudad.setText((String) extras.get("ciudad"));
            pais.setText((String) extras.get("pais"));
        }


    }

    public void goPerfil(View view) {
        Intent i = new Intent(Perfil.this, Perfil.class);
        startActivity(i);
    }

    public void goBuscar(View view) {
        Intent i = new Intent(Perfil.this, Buscar.class);
        startActivity(i);
    }

    public void goHome(View view) {
        Intent i = new Intent(Perfil.this, Home.class);
        startActivity(i);
    }

    public void goEvento(View view) {
        Intent i = new Intent(Perfil.this, Eventos.class);
        startActivity(i);
    }

    public void goAjustes(View view) {
        Intent i = new Intent(Perfil.this, Ajustes.class);
        startActivity(i);
    }


}
