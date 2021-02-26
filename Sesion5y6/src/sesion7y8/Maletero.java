
package sesion7y8;

import sesion5y6.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maletero {
    private int importanciaTotal;
    private int altoM;
    private int anchoM;
    private String [][] dimension;
    List <Objeto> objetos;
    List <Objeto> solucion;

    public Maletero(int altoM, int anchoM, List <Objeto> objetos) {
        this.importanciaTotal = 0;
        this.altoM = altoM;
        this.anchoM = anchoM;
        this.objetos = new ArrayList <Objeto> (objetos);
        Collections.sort(this.objetos,Collections.reverseOrder());
        this.solucion = new ArrayList <Objeto> ();
        this.dimension = new String [altoM][anchoM];
    }

    public int getImportanciaTotal() {
        return importanciaTotal;
    }
   
    public int getAltoM() {
        return altoM;
    }

    public int getAnchoM() {
        return anchoM;
    }

    public void setImportanciaTotal(int importanciaTotal) {
        this.importanciaTotal = importanciaTotal;
    }

    public void setAltoM(int altoM) {
        this.altoM = altoM;
    }

    public void setAnchoM(int anchoM) {
        this.anchoM = anchoM;
    }   

    public boolean esPosible(Objeto prueba,int x,int y){
        int total = 0;
        for(int i = x;i<x+prueba.getAncho()&& i<dimension.length;i++){
            for(int j = y;j<y+prueba.getAlto() && j<dimension[0].length;j++)
                if(dimension[i][j] == null){
                    total++;
                }
        }
        if(total == prueba.getAncho()*prueba.getAlto()){
            return true;
        }
        prueba.rotar();
        total = 0;
        for(int i = x;i<x+prueba.getAncho()&& i<dimension.length;i++){
            for(int j = y;j<y+prueba.getAlto() && j<dimension[0].length;j++)
                if(dimension[i][j] == null){
                    total++;
                }
        }
        if(total == prueba.getAncho()*prueba.getAlto()){
            return true;
        }
        return false;
    }
       
    public void colocarBulto(Objeto colocar,int x,int y){
        for(int i = x;i<x+colocar.getAncho();i++){
            for(int j = y;j<y+colocar.getAlto();j++){
                dimension[i][j] = colocar.getId();
            }
        }
    }
    
    public void mostrarSolucion(){
        for(int i = 0;i<dimension.length;i++){
            for(int j = 0;j<dimension[0].length;j++){
                System.out.print(dimension[i][j] + "\t");
            }
            System.out.println();
        }
        for(int i = 0;i<solucion.size();i++){
            System.out.println(solucion.get(i).toString());
        }
    }    
}

