package franciscoguixot.eventosdeportivosapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ArrayList<String> eventos;
    private ArrayAdapter<String> adaptador;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eventos = new ArrayList<String>();

        Intent intent = getIntent();
        Bundle extras;
        extras = intent.getExtras();
        if(extras != null ) {
            eventos.add(extras.get("evento").toString());
        }

        adaptador = new ArrayAdapter<String>(this, R.layout.fila_lista, eventos);

        list = (ListView) findViewById(R.id.lv1);
        list.setAdapter(adaptador);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int posicion = position;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(Home.this);
                dialogo.setTitle("Eliminar evento");
                dialogo.setMessage("¿Desea eliminar el evento de su lista?");
                dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo, int id) {
                        eventos.remove(posicion);
                        adaptador.notifyDataSetChanged();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo, int id) {
                    }
                });
                dialogo.show();

                return false;
            }
        });
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
