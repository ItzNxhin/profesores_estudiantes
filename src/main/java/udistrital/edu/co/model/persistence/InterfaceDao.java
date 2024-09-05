package udistrital.edu.co.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface InterfaceDao <Type>{ 
 
    ArrayList<String> read();
    boolean create (Type x) throws IOException; 
    boolean delete (String x) throws IOException;
    boolean find(Type x );
    boolean update(Type x, Type y) throws IOException;
    Type findID(String id);
}
                  