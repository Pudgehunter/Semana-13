package co.domi.semana13;

public class Usuario {
    private String id;
    //private String nombre;
    private String nombreUsuario;
    //private int telefono;

    public Usuario(){}

    public Usuario(String nombreUsuario, String id) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
