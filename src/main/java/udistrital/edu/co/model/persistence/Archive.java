package udistrital.edu.co.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import udistrital.edu.co.model.Estudiante;
import udistrital.edu.co.model.Profesor;

public class Archive {
    
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private File fE = new File("Data/estudentes.dat");
    private File fP = new File("Data/teachers.dat");

    

    public Archive(){
        if(!fE.exists()) {
			try {
				fE.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
        }
        if(!fP.exists()) {
			try {
				fP.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Estudiante> leerEstudiantes() throws IOException, ClassNotFoundException{
        ArrayList<Estudiante> x = new ArrayList<>();
		if(fE.length() != 0) {
            in = new ObjectInputStream(new FileInputStream(fE));
            ArrayList<EstudianteDTO> y = (ArrayList<EstudianteDTO>)in.readObject();
            x = MapHandler.dtoeststoEST(y);
		}
		return x;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Profesor> leerProfesores() throws IOException, ClassNotFoundException{
        ArrayList<Profesor> x = new ArrayList<>();
		if(fP.length() != 0) {
            in = new ObjectInputStream(new FileInputStream(fP));
            ArrayList<ProfesorDTO> data = (ArrayList<ProfesorDTO>)in.readObject();
            x = MapHandler.dtoeststoPRF(data);
		}
		return x;
    }

    public void guardarEstudiantes(ArrayList<Estudiante> x) throws IOException{
        out = new ObjectOutputStream(new FileOutputStream(fE));
        ArrayList<EstudianteDTO> y =  MapHandler.eststoDTO(x);
        out.writeObject(y);
        out.close();
    }

    public void guardarProfesores(ArrayList<Profesor> x) throws IOException{
        out = new ObjectOutputStream(new FileOutputStream(fP));
        ArrayList<ProfesorDTO> y = MapHandler.prftoDTO(x);
        out.writeObject(y);
        out.close();
    }

    public File getfE() {
        return fE;
    }

    public void setfE(File fE) {
        this.fE = fE;
    }

    public File getfP() {
        return fP;
    }

    public void setfP(File fP) {
        this.fP = fP;
    }




}
