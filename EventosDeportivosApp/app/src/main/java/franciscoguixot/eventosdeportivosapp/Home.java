package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void goCrearEvento(View view) {
        Intent i = new Intent(Home.this, CrearEvento.class);
        startActivity(i);
    }

    public void goPerfil(View view) {
        Intent i = new Intent(Home.this, Perfil.class);
        startActivity(i);
    }

    public void goBuscar(View view) {
        Intent i = new Intent(Home.this, Buscar.class);
        startActivity(i);
    }

    public void goHome(View view) {
        Intent i = new Intent(Home.this, Home.class);
        startActivity(i);
    }

    public void goEvento(View view) {
        Intent i = new Intent(Home.this, Eventos.class);
        startActivity(i);
    }

}
