package udistrital.edu.co.view;

import javax.swing.JOptionPane;

public class Pedidos {

    public Pedidos(){

    }

    public String cadenas(String string){
        return JOptionPane.showInputDialog(null, string, "Ingreso de datos",JOptionPane.QUESTION_MESSAGE);
    }

    public String cadenas(String mes, String start){
        return (String) JOptionPane.showInputDialog(null, mes, "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, null, start);
    }

    public int enteros(String string){
        return Integer.parseInt(JOptionPane.showInputDialog(null,string,"Ingreso de datos",JOptionPane.QUESTION_MESSAGE)); 
    }

    public int enteros(String mes, String start){
        return Integer.parseInt((String)JOptionPane.showInputDialog(null, mes, "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, null, start));
    }

    public float floats(String string){
        return Float.parseFloat(JOptionPane.showInputDialog(null,string,"Ingreso de datos",JOptionPane.QUESTION_MESSAGE)); 
    }

    public float floats(String mes, String start){
        return Float.parseFloat((String)JOptionPane.showInputDialog(null, mes, "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, null, start));
    }

    public void message(String x ){
        JOptionPane.showMessageDialog(null, x, "INFORMACION",JOptionPane.INFORMATION_MESSAGE);
    }    
}
