package franciscoguixot.eventosdeportivosapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Registro extends AppCompatActivity {

    private EditText nombre;
    private EditText apellidos;
    private EditText nombreUsuario;
    private EditText contraseña;
    private EditText contraseñaRepetida;
    private EditText email;
    private EditText localidad;
    private EditText provincia;
    private EditText pais;
    private EditText fechaNac;

    public MainActivity main;

    Button btnFoto;
    ImageView imagenPerfil;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Registro");
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.editText3);
        apellidos = (EditText) findViewById(R.id.editText4);
        nombreUsuario = (EditText) findViewById(R.id.editText5);
        contraseña = (EditText) findViewById(R.id.editText6);
        contraseñaRepetida = (EditText) findViewById(R.id.editText7);
        email = (EditText) findViewById(R.id.editText8);
        localidad = (EditText) findViewById(R.id.editText9);
        provincia = (EditText) findViewById(R.id.editText10);
        pais = (EditText) findViewById(R.id.editText11);
        fechaNac = (EditText) findViewById(R.id.editText12);

        btnFoto = (Button) findViewById(R.id.button8);
        imagenPerfil = (ImageView) findViewById(R.id.imageView);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }

    public void goPerfil(View view) {
        if (nombre.getText().toString().equals("") || apellidos.getText().toString().equals("")
                || nombreUsuario.getText().toString().equals("") || contraseña.getText().toString().equals("")
                || contraseñaRepetida.getText().toString().equals("") || email.getText().toString().equals("")
                || localidad.getText().toString().equals("") || provincia.getText().toString().equals("")
                || pais.getText().toString().equals("") || fechaNac.getText().toString().equals("")) {

            Toast toast1 = Toast.makeText(getApplicationContext(), "Hay que rellenar todos los campos", Toast.LENGTH_LONG);
            toast1.show();

        } else {
            if (contraseña.getText().toString().equals(contraseñaRepetida.getText().toString())) {
                Intent i = new Intent(Registro.this, Perfil.class);
                i.putExtra("nombre", nombre.getText().toString());
                i.putExtra("apellidos", apellidos.getText().toString());
                i.putExtra("nombreUsuario", nombreUsuario.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("edad", fechaNac.getText().toString());
                i.putExtra("ciudad", provincia.getText().toString());
                i.putExtra("pais", pais.getText().toString());
                startActivity(i);
            } else {
                Toast toast2 = Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden,vuelve a introducirlas", Toast.LENGTH_LONG);
                toast2.show();
            }

        }
    }

    public void goLogin(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Está seguro que desea cancelar el registro?")
                .setTitle("CANCELAR")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i1 = new Intent(Registro.this, MainActivity.class);
                        startActivity(i1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alerta.create();
        alerta.show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagenPerfil.setImageBitmap(imageBitmap);
        }
    }
}
