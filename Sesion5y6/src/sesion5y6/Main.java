
package sesion5y6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        Maletero maletero = leerDatos();
        
        List<Objeto> objetos = new ArrayList<Objeto>(maletero.objetos);
        List<Objeto> solucion = new ArrayList<Objeto>();
        String[][] dimension = new String [maletero.getAltoM()][maletero.getAnchoM()]; 
        Voraz(objetos,solucion,dimension,maletero);
        maletero.mostrarSolucion(solucion,dimension);
    }
    
    public static void Voraz(List<Objeto> objetos, List<Objeto> solucion, String[][] dimension,Maletero maletero) {
        Collections.sort(objetos,Collections.reverseOrder());
        for (int k=0; k<objetos.size(); k++){
        boolean colocado=false;
            for (int i=0; i<dimension.length && !colocado; i++){
                for (int j=0; j<dimension[0].length && !colocado; j++){
                    if(dimension[i][j]==null && Maletero.esPosible(objetos.get(k),i,j,dimension)){
                        Maletero.colocarBulto(objetos.get(k),i,j,dimension);
                        solucion.add(objetos.get(k));
                        colocado=true;
                    }
                }
            }
        }
        maletero.solucion = new ArrayList<Objeto> (solucion);
    }
    
    
    public static Maletero leerDatos() {
        Maletero maletero = null; 
        ArrayList<Objeto> objetos = new ArrayList();
        try {
            Scanner scanner = new Scanner(new FileReader("datos.txt"));
            scanner.next();
            //recojo los datos del maletero
            String datosMaletero = scanner.next();
            String[] atributosMaletero = datosMaletero.split(";");
            //creo el objeto maletero
            scanner.next();
            String datosObjeto;
            String[] atributos;
            Objeto objeto;
            //recojo los datos de todos los objetos
            while(scanner.hasNext()){
                datosObjeto = scanner.next();
                atributos = datosObjeto.split(";");
                objeto = new Objeto(atributos[0],Integer.valueOf(atributos[1]),Integer.valueOf(atributos[2]),Integer.valueOf(atributos[3]));
                objetos.add(objeto);
            }
            maletero = new Maletero (Integer.valueOf(atributosMaletero[0]),Integer.valueOf(atributosMaletero[1]), objetos);
            
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return maletero;
    }                    
   
}
