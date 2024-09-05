package udistrital.edu.co.model;

/**
 * Esta es la sub clase para los estudiantes
 */
public class Estudiante extends Persona  {
    private float promedio;

    public Estudiante(){
    }

    public Estudiante(String nombre, String id, int edad, String facultad, float promedio) {
        super(nombre, id, edad, facultad);
        this.promedio = promedio;
    }

    public float getPromedio() {
        return promedio;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante [promedio=" + promedio + ", nombre=" + nombre + ", id=" + id + ", edad=" + edad
                + ", facultad=" + facultad + "]";
    }

    


}
