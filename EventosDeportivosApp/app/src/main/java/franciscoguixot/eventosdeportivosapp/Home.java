package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {

    private TextView name;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (TextView) findViewById(R.id.textView14);
        username = (TextView) findViewById(R.id.textView15);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String datoNombre = (String) extras.get("nombre");
        String datoApellidos = (String) extras.get("apellidos");
        String datoUsername = (String) extras.get("nombreUsuario");

        name.setText(datoNombre + " " + datoApellidos);
        username.setText(datoUsername);
    }

}
