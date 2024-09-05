package udistrital.edu.co.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Consola(){
        
    }
    
    public int menu() throws IOException{
        System.out.println("---------------CONDOR--------------------");
        System.out.println("1. G. Profesor");
        System.out.println("2. G. Estudiante");
        System.out.println("3. Salir");

        return Integer.parseInt(in.readLine());
    }

    public int gestion(String x) throws IOException{
        System.out.println("---------------CONDOR ("+x+")--------------------");
        System.out.println("1. Leer todos");
        System.out.println("2. Agregar");
        System.out.println("3. Eliminar");
        System.out.println("4. Editar");

        return Integer.parseInt(in.readLine());
    }

    public String leerCadena(String x) throws IOException{
        System.out.println(x);
        return in.readLine();
    }

    public int leerInt(String x) throws IOException{
        System.out.println(x);
        return Integer.parseInt(in.readLine());
    }

    public float leerFloat(String x) throws IOException{
        System.out.println(x);
        return Float.parseFloat(in.readLine());
    }

    public void error() {
        System.out.println("Ingreso errorneo, vuelva a intentarlo");
        return;
    }

    public void imprimir(String x) {
        System.out.println(x);
        return;
    }
}
