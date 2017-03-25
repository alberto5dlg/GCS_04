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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Usuarios user = new Usuarios("Alberto", "De Lucas", "pepe", "alberto5dlg@gmail.com", "España", "alberto5dlg", "Benidorm", "23");
    private Usuarios user2 = new Usuarios("Fernando", "Marin", "adios", "f3rchu@gmail.com", "España", "f3rchu", "Alicante", "22");
    public Usuarios createUser;

    public String userReg;
    private EditText login;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goRegistro(View view) {
        Intent i = new Intent(MainActivity.this, Registro.class);
        startActivity(i);
    }

    public void goEventos(View view) {
        login = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

        if(!login.getText().equals("") && !login.getText().equals("")) {

            if (user.usuario.equals(login.getText().toString()) && user.contrasenya.equals(pass.getText().toString())) {
                userReg = "user";
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
            }
            else if (user2.usuario.equals(login.getText().toString()) && user2.contrasenya.equals(pass.getText().toString())) {
                userReg = "user2";
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
            }
            else {
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setMessage("Algun dato incorrecto");
                alerta.create();
                alerta.show();
            }

        } else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Algun dato incorrecto");
            alerta.create();
            alerta.show();
        }
    }
}
