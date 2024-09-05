package udistrital.edu.co.model;
import java.io.Serializable;

/**
 * Esta es la super clase para los dos tipo de personas a manejar
 */
public class Persona implements Serializable{
    protected String nombre;
    protected String id;
    protected int edad;
    protected String facultad;

    public Persona(){}

    public Persona(String nombre, String id, int edad, String facultad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.facultad = facultad;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    
    
}
