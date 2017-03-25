package franciscoguixot.eventosdeportivosapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CrearEvento extends AppCompatActivity {

    private EditText nombreEvento;
    private EditText precio;
    private EditText deporte;
    private EditText provincia;
    private EditText fechaInicio;
    private EditText direccion;
    private EditText numeroEquipos;
    private EditText numeroJugadores;

    Button crear;
    Button btnFoto;
    ImageView imagenEvento;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombreEvento = (EditText) findViewById(R.id.editText14);
        precio = (EditText) findViewById(R.id.editText16);
        deporte = (EditText) findViewById(R.id.editText15);
        provincia = (EditText) findViewById(R.id.editText22);
        fechaInicio = (EditText) findViewById(R.id.editText17);
        direccion = (EditText) findViewById(R.id.editText19);
        numeroEquipos = (EditText) findViewById(R.id.editText20);
        numeroJugadores = (EditText) findViewById(R.id.editText21);

        crear = (Button) findViewById(R.id.button7);
        btnFoto = (Button) findViewById(R.id.button9);

        imagenEvento = (ImageView) findViewById(R.id.imageView4);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }


    public void crearEvento(View view) {
        if (nombreEvento.getText().toString().equals("") || precio.getText().toString().equals("") ||
                deporte.toString().equals("") || provincia.toString().equals("") || fechaInicio.getText().toString().equals("") ||
                direccion.getText().toString().equals("") ||
                numeroEquipos.getText().toString().equals("") || numeroJugadores.getText().toString().equals("")) {

            Toast toast1 = Toast.makeText(getApplicationContext(), "Hay que rellenar todos los campos", Toast.LENGTH_LONG);
            toast1.show();

        } else {
            Intent i = new Intent(CrearEvento.this, Eventos.class);
            i.putExtra("nombreEvento", nombreEvento.getText().toString());
            i.putExtra("provincia", provincia.getText().toString());
            i.putExtra("fechaInicio", fechaInicio.getText().toString());
            startActivity(i);
        }
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
            imagenEvento.setImageBitmap(imageBitmap);
        }
    }
}
