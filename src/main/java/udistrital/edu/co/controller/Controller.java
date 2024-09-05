package udistrital.edu.co.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import udistrital.edu.co.model.Estudiante;
import udistrital.edu.co.model.Profesor;
import udistrital.edu.co.model.persistence.EstudentDAO;
import udistrital.edu.co.model.persistence.TeacherDAO;
import udistrital.edu.co.view.Consola;
import udistrital.edu.co.view.Pedidos;
import udistrital.edu.co.view.Ventana;
import udistrital.edu.co.view.VentanaEstudiantes;
import udistrital.edu.co.view.VentanaProfesores;

public class Controller implements ActionListener {

    
    ArrayList<String> ids;

    Ventana main;
    VentanaEstudiantes vE;
    VentanaProfesores vP;
    Pedidos inputs;

    int op = 0;
    Consola vista;
    EstudentDAO gE;
    TeacherDAO gP;

    public Controller(){
        
        ids = new ArrayList<>();
        vista = new Consola();
        
        try{
            gE = new EstudentDAO();
            gP = new TeacherDAO();
            vE = new VentanaEstudiantes(listaPersonas(gE.read()));
            vP = new VentanaProfesores(listaPersonas(gP.read()));

        } catch (ClassNotFoundException | IOException e) {
            vista.imprimir(e.getLocalizedMessage());
        }
        ids();
        inputs = new Pedidos();
        main = new Ventana();
        
        //Action listeners de todos los botones 
        main.buttonEst.addActionListener(this);
        main.buttonProf.addActionListener(this);
        vE.btnSalir.addActionListener(this);
        vE.btnVolver.addActionListener(this);
        vP.btnSalir.addActionListener(this);
        vP.btnVolver.addActionListener(this);
        vE.btnAgregar.addActionListener(this);
        vE.btnEliminar.addActionListener(this);
        vE.btnEdiar.addActionListener(this);
        vP.btnAgregar.addActionListener(this);
        vP.btnEliminar.addActionListener(this);
        vP.btnEdiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == main.buttonEst){
            main.setVisible(false);
            vE.setVisible(true);
        }
        else if (e.getSource() == main.buttonProf){
            main.setVisible(false);
            vP.setVisible(true);
        }
        else if(e.getSource() == vE.btnVolver){
            vE.setVisible(false);
            main.setVisible(true);
        }
        else if(e.getSource() == vP.btnVolver){
            vP.setVisible(false);
            main.setVisible(true);
        }
        else if (e.getSource() == vE.btnSalir || e.getSource() == vP.btnSalir){
            main.dispose();
            vP.dispose();
            vE.dispose();
        }
        //Gestion estudiantes
        else if (e.getSource() == vE.btnAgregar){
            agregarEstudiante();
        }
        else if (e.getSource() == vE.btnEliminar){
            eliminarEstudiante();
        }
        else if (e.getSource() == vE.btnEdiar){
            editarEstudiante();
        }
        //Gestion profesores
        else if (e.getSource() == vP.btnAgregar){
            agregarProfesor();
        }
        else if (e.getSource() == vP.btnEliminar){
            eliminarProfesor();
        }
        else if (e.getSource() == vP.btnEdiar){
            editarProfesor();
        }
    }

    //Verificacion de existencia de una persona
    private boolean existencia(String x){
        if(ids.contains(x)) {
            inputs.message("Esta persona ya existe");
            return true;
        }
        return false;
    }

    //Identificacion de estudiantes y profesores en la misma lista
    private void ids(){
        ids.clear();
        if(!gE.ids().isEmpty()) ids.addAll(gE.ids());
        if(!gP.ids().isEmpty()) ids.addAll(gP.ids());
    }

    //Gestion: Create estudiante
    private void agregarEstudiante() {
        try {
            String id = inputs.cadenas("Ingrese la identificacion del estudiante");
            if(existencia(id)) return;

            String name = inputs.cadenas("Ingrese el nombre del estudiante");   
            int edad = inputs.enteros("Ingrese la edad del estudiante");
            String fact =  inputs.cadenas("Ingrese la facultad del estudiante");
            float prom = inputs.floats("Ingrese el promedio del estudiante");
            gE.create(new Estudiante(name, id, edad, fact, prom));   
            ids();
            vE.sbwrite(listaPersonas(gE.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        }     
    }

    //Gestion: Delete estudiante
    private void eliminarEstudiante() {
        try {
            String id = inputs.cadenas("Ingrese la identificacion del estudiante a eliminar"); 
            boolean x = gE.delete(id);   
            if(x) inputs.message("Se elimino el estudiante");
            else inputs.message("El estudiante no existe");
            vE.sbwrite(listaPersonas(gE.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        }     
    }

    //Gestion: Update estudiante
    private void editarEstudiante(){
        try {
            String id = inputs.cadenas("Ingrese la identificacion del estudiante a editar");
            if(gE.findID(id)==null) inputs.message("El estudiante no existe");
            else{
                String name = inputs.cadenas("Nombre del estudiante", gE.findID(id).getNombre());   
                int edad = inputs.enteros("Ingrese la edad del estudiante", String.valueOf(gE.findID(id).getEdad()));
                String fact =  inputs.cadenas("Ingrese la facultad del estudiante", gE.findID(id).getFacultad());
                float prom = inputs.floats("Ingrese el promedio del estudiante",String.valueOf(gE.findID(id).getPromedio()));
                boolean x = gE.update(gE.findID(id), new Estudiante(name, id, edad, fact, prom));   
                if(x) inputs.message("Se edito el estudiante");
                else inputs.message("Ocurrio un error");
            }
            
            vE.sbwrite(listaPersonas(gE.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        } 
    }

    //Gestion: Create profesor
    private void agregarProfesor() {
        try {
            String id = inputs.cadenas("Ingrese la identificacion del profesor");
            if(existencia(id)) return;

            String name = inputs.cadenas("Ingrese el nombre del profesor");   
            int edad = inputs.enteros("Ingrese la edad del profesor");
            String fact =  inputs.cadenas("Ingrese la facultad del profesor");
            int pt = inputs.enteros("Ingrese los puntos salariales del profesor");
            gP.create(new Profesor(name, id, edad, fact, pt));   
            ids();
            vP.sbwrite(listaPersonas(gP.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        }     
    }

    //Gestion: Delete estudiante
    private void eliminarProfesor() {
        try {
            String id = inputs.cadenas("Ingrese la identificacion del profesor a eliminar"); 
            boolean x = gP.delete(id);   
            if(x) inputs.message("Se elimino el profesor");
            else inputs.message("El profesor no existe");
            vP.sbwrite(listaPersonas(gP.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        }     
    }

    //Gestion: Update estudiante
    private void editarProfesor(){
        try {
            String id = inputs.cadenas("Ingrese la identificacion del profesor a editar");
            if(gP.findID(id)==null) inputs.message("El profesor no existe");
            else{
                String name = inputs.cadenas("Nombre del profesor", gP.findID(id).getNombre());   
                int edad = inputs.enteros("Ingrese la edad del profesor", String.valueOf(gP.findID(id).getEdad()));
                String fact =  inputs.cadenas("Ingrese la facultad del profesor", gP.findID(id).getFacultad());
                int pt = inputs.enteros("Ingrese el promedio del profesor",String.valueOf(gP.findID(id).getPuntosSalariales()));
                boolean x = gP.update(gP.findID(id), new Profesor(name, id, edad, fact, pt));   
                if(x) inputs.message("Se edito el profesor");
                else inputs.message("Ocurrio un error");
            }
            
            vE.sbwrite(listaPersonas(gE.read()));
        } catch (Exception e) {
            vista.imprimir(e.getMessage());
        } 
    }

    //Gestion: Read
    private DefaultListModel<String> listaPersonas(ArrayList<String> x) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        if(gE.read()!=null) for(String i : x){
            listModel.addElement(i);
        }
        return listModel;
    }
}
