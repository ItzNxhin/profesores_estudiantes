package udistrital.edu.co.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import udistrital.edu.co.model.Estudiante;

public class EstudentDAO implements InterfaceDao <Estudiante> {

    ArrayList<Estudiante> list;
    private Archive aR;
    
    public EstudentDAO() throws IOException, ClassNotFoundException{
        aR = new Archive();
        actualizar();
    }

    public void actualizar() throws IOException, ClassNotFoundException{
        list = aR.leerEstudiantes();
    }

    public ArrayList<String> read() {
        ArrayList<String > r = new ArrayList<>();
        if (!list.isEmpty()) for(Estudiante x : list){
            r.add(x.toString());
        }
        return r;
    }

    @Override
    public boolean create(Estudiante x) throws IOException {
        if(!find(x)){
            list.add(x);
            rWrite();   
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String x) throws IOException {
        if(findID(x)!=null){
            list.remove(findID(x));
            rWrite();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Estudiante x, Estudiante y) throws IOException {
        if(find(x)){
            list.remove(x);
            list.add(y);
            rWrite();
            return true;
        }
        return false;
    }

    @Override
    public boolean find(Estudiante x) {
        if (!list.isEmpty()) for(Estudiante i : list){
            if(i.getId().equals(x.getId())) return true;
        }
        return false;
    }

    @Override
    public Estudiante findID(String id) {
        if (!list.isEmpty()) for(Estudiante i : list){
            if(i.getId().equals(id)) return i;
        }
        return null;
    }

    public ArrayList<String> ids() {
        ArrayList<String > r = new ArrayList<>();
        if (!list.isEmpty()) for(Estudiante x : list){
            r.add(x.getId());
        }
        return r;
    }

    private void rWrite() throws IOException{
        aR.getfE().delete();
        aR.getfE().createNewFile();
        aR.guardarEstudiantes(list);
    } 
    
}
