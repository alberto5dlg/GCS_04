package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Buscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void goPerfil(View view) {
        Intent i = new Intent(Buscar.this, Perfil.class);
        startActivity(i);
    }

    public void goBuscar(View view) {
        Intent i = new Intent(Buscar.this, Buscar.class);
        startActivity(i);
    }

    public void goHome(View view) {
        Intent i = new Intent(Buscar.this, Home.class);
        startActivity(i);
    }

    public void goEvento(View view) {
        Intent i = new Intent(Buscar.this, Eventos.class);
        startActivity(i);
    }

}
