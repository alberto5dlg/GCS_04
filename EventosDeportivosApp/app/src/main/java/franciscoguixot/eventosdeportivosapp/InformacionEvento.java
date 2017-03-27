package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class InformacionEvento extends AppCompatActivity {

    private TextView titulo;
    private TextView fecha;
    private TextView provincia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_evento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo = (TextView) findViewById(R.id.textView19);
        provincia = (TextView) findViewById(R.id.textView23);
        fecha = (TextView) findViewById(R.id.textView26);


        Intent intent = getIntent();
        Bundle extras;
        extras = intent.getExtras();
        if(extras != null ) {
            titulo.setText((String) extras.get("titulo"));
            provincia.setText((String) extras.get("provincia"));
            fecha.setText((String) extras.get("fecha"));
        }

    }

    public void goPerfil(View view) {
        Intent i = new Intent(InformacionEvento.this, Perfil.class);
        startActivity(i);
    }

    public void goBuscar(View view) {
        Intent i = new Intent(InformacionEvento.this, Buscar.class);
        startActivity(i);
    }

    public void goHome(View view) {
        Intent i = new Intent(InformacionEvento.this, Home.class);
        startActivity(i);
    }

    public void goEvento(View view) {
        Intent i = new Intent(InformacionEvento.this, Eventos.class);
        startActivity(i);
    }

    public void goAjustes(View view) {
        Intent i = new Intent(InformacionEvento.this, Ajustes.class);
        startActivity(i);
    }

}
