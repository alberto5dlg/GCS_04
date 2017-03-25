package franciscoguixot.eventosdeportivosapp;

/**
 * Created by Alberto on 25/3/17.
 */

public class Usuarios {

    public String nombre;
    public String apellido;
    public String contrasenya;
    public String email;
    public String pais;
    public String usuario;
    public float valoracion;
    public String localidad;
    public String edad;

    public Usuarios() {
        this.valoracion = 0.0f;
    }

    public Usuarios(String nombre, String apellido, String contrasenya, String email, String pais
                    ,String usuario, String localidad, String edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenya = contrasenya;
        this.email = email;
        this.pais = pais;
        this.usuario = usuario;
        this.localidad = localidad;
        this.edad = edad;
        this.valoracion = 0.0f;
    }

}
