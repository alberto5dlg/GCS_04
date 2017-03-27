package franciscoguixot.eventosdeportivosapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Eventos extends AppCompatActivity {

    //String eventos[] = new String[10];

    /*
    Integer imageId[] = {
            R.drawable.pic01,
            R.drawable.pic02,
            R.drawable.pic03
    };
    */

    private ArrayList<String> eventos;
    private ArrayAdapter<String> adaptador;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eventos = new ArrayList<String>();
        eventos.add("Torneo Fútbol Semana Santa : Alicante : 01/04/2017");
        eventos.add("Torneo Tenis UA : Alicante : 25/04/2017");
        eventos.add("Torneo Fútbol Erasmus : Alicante : 13/07/2017");

        Intent intent = getIntent();
        Bundle extras;
        extras = intent.getExtras();
        if(extras != null ) {
            eventos.add(extras.get("nombreEvento") + " : " + extras.get("provincia") + " : " + extras.get("fechaInicio"));
        }

        adaptador = new ArrayAdapter<String>(this, R.layout.fila_lista, eventos);

        list = (ListView) findViewById(R.id.lista);
        list.setAdapter(adaptador);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int posicion = position;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(Eventos.this);
                dialogo.setTitle("Añadir evento");
                dialogo.setMessage("¿Desea unirse al evento?");
                dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo, int id) {
                        Intent i = new Intent(Eventos.this, Home.class);
                        i.putExtra("evento", eventos.get(posicion));
                        startActivity(i);
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int posicion = position;

                String[] evento_info = eventos.get(posicion).toString().split(" : ");

                Intent i = new Intent(Eventos.this, InformacionEvento.class);
                i.putExtra("titulo", evento_info[0]);
                i.putExtra("provincia", evento_info[1]);
                i.putExtra("fecha", evento_info[2]);
                startActivity(i);
            }
        });

    }

    public void goCrearEvento(View view) {
        Intent i = new Intent(Eventos.this, CrearEvento.class);
        startActivity(i);
    }
    public void goPerfil(View view) {
        Intent i = new Intent(Eventos.this, Perfil.class);
        startActivity(i);
    }

    public void goBuscar(View view) {
        Intent i = new Intent(Eventos.this, Buscar.class);
        startActivity(i);
    }

    public void goHome(View view) {
        Intent i = new Intent(Eventos.this, Home.class);
        startActivity(i);
    }

    public void goEvento(View view) {
        Intent i = new Intent(Eventos.this, Eventos.class);
        startActivity(i);
    }

    public void goAjustes(View view) {
        Intent i = new Intent(Eventos.this, Ajustes.class);
        startActivity(i);
    }



}
