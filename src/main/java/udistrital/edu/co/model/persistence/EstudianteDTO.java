package udistrital.edu.co.model.persistence;

import java.io.Serializable;

public class EstudianteDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String id;
    private int edad;
    private String facultad;
    private float promedio; 
    
    public float getPromedio() {
        return promedio;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
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
