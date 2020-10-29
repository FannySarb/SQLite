package estefania.com.sqlite.utilidades;

public class Utilidades {
    //creación de query

    public static final String TABLA_USUARIO="usuario";
    public static final String ID="id";
    public static final String NOMBRE="nombre";
    public static final String EDAD="edad";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"("+ID+" "+"INTEGER, "+NOMBRE+" TEXT,"+EDAD+" TEXT)";
}
