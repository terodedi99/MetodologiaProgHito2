
package sesion7y8;

import sesion5y6.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        Maletero maletero = leerDatos();
        maletero.mostrarSolucion();
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
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return maletero;
    }                    
   
}
