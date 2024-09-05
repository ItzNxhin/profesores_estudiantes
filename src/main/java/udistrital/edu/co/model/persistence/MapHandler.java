package udistrital.edu.co.model.persistence;

import java.util.ArrayList;

import udistrital.edu.co.model.Estudiante;
import udistrital.edu.co.model.Profesor;

public class MapHandler {

    public static EstudianteDTO estudianteToDTO(Estudiante x){
        EstudianteDTO y = new EstudianteDTO();
        y.setNombre(x.getNombre());
        y.setId(x.getId());
        y.setEdad(x.getEdad());
        y.setFacultad(x.getFacultad());
        y.setPromedio(x.getPromedio());
        return y;
    }
    public static Estudiante dTOToEstudiante(EstudianteDTO x){
        return new Estudiante(x.getNombre(), x.getId(), x.getEdad(), x.getFacultad(), x.getPromedio());
    }
    public static ProfesorDTO profesorToDTO(Profesor x){
        ProfesorDTO y = new ProfesorDTO();
        y.setNombre(x.getNombre());
        y.setId(x.getId());
        y.setEdad(x.getEdad());
        y.setFacultad(x.getFacultad());
        y.setPuntosSalariales(x.getPuntosSalariales());
        return y;
    }
    public static Profesor dTOToProfesor(ProfesorDTO x){
        return new Profesor(x.getNombre(), x.getId(), x.getEdad(), x.getFacultad(), x.getPuntosSalariales());
    }

    public static ArrayList<EstudianteDTO> eststoDTO(ArrayList<Estudiante>  x){
        ArrayList<EstudianteDTO> data = new ArrayList<>();
        if(!x.isEmpty()) for(Estudiante i : x){
            data.add(estudianteToDTO(i));
        }
        return data;
    }

    public static ArrayList<Estudiante> dtoeststoEST(ArrayList<EstudianteDTO>  x){
        ArrayList<Estudiante> data = new ArrayList<>();
        if(!x.isEmpty()) for(EstudianteDTO i : x){
            data.add(dTOToEstudiante(i));
        }
        return data;
    }

    public static ArrayList<ProfesorDTO> prftoDTO(ArrayList<Profesor>  x){
        ArrayList<ProfesorDTO> data = new ArrayList<>();
        if(!x.isEmpty()) for(Profesor i : x){
            data.add(profesorToDTO(i));
        }
        return data;
    }

    public static ArrayList<Profesor> dtoeststoPRF(ArrayList<ProfesorDTO>  x){
        ArrayList<Profesor> data = new ArrayList<>();
        if(!x.isEmpty()) for(ProfesorDTO i : x){
            data.add(dTOToProfesor(i));
        }
        return data;
    }
}
 