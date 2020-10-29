package estefania.com.sqlite.entidades;

public class Usuario {

    public Usuario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    private Integer id;
    private String nombre;
    private String edad;


    public Usuario(Integer id, String nombre, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
}
