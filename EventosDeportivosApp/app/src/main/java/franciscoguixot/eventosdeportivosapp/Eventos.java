package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Eventos extends AppCompatActivity {

    String eventos[] = {
            "Torneo Fútbol Semana Santa",
            "Torneo Tenis UA",
            "Torneo Fútbol Sala Interurbanizaciones"
    };

    Integer imageId[] = {
            R.drawable.pic01,
            R.drawable.pic02,
            R.drawable.pic03
    };

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CustomList adapter = new CustomList(Eventos.this, eventos, imageId);

        list = (ListView) findViewById(R.id.lista);
        list.setAdapter(adapter);
    }

    public void goCrearEvento(View view) {
        Intent i = new Intent(Eventos.this, CrearEvento.class);
        startActivity(i);
    }


}
