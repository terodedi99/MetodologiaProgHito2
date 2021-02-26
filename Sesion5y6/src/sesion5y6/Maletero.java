
package sesion5y6;

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
        this.dimension = new String [altoM][anchoM];
    }
   
    public int getAltoM() {
        return altoM;
    }

    public int getAnchoM() {
        return anchoM;
    }

    public void setAltoM(int altoM) {
        this.altoM = altoM;
    }

    public void setAnchoM(int anchoM) {
        this.anchoM = anchoM;
    }   
    public static boolean esPosible(Objeto prueba,int x,int y, String[][] dimension){
        int totalHor = 0;
        int totalVer = 0;
        boolean posible = false;
        for(int i = x;i<x+prueba.getAncho()&& i<dimension.length;i++){
            for(int j = y;j<y+prueba.getAlto() && j<dimension[0].length;j++)
                if(dimension[i][j] == null){
                    totalHor++;
                }
        }
        prueba.rotar();
        for(int i = x;i<x+prueba.getAncho()&& i<dimension.length;i++){
            for(int j = y;j<y+prueba.getAlto() && j<dimension[0].length;j++)
                if(dimension[i][j] == null){
                    totalVer++;
                }
        }
        if(totalVer == prueba.getAncho()*prueba.getAlto()){
            posible = true;
        }
        prueba.rotar();
        if(totalHor == prueba.getAncho()*prueba.getAlto() && !posible){
            posible = true;
        }
        return posible;
    }
       
    public static void colocarBulto(Objeto colocar,int x,int y, String[][] dimension){
        for(int i = x;i<x+colocar.getAncho();i++){
            for(int j = y;j<y+colocar.getAlto();j++){
                dimension[i][j] = colocar.getId();
            }
        }
    }
    
    public void mostrarSolucion(List<Objeto> solucion,String[][] dimension){
        for(int i = 0;i<dimension.length;i++){
            for(int j = 0;j<dimension[0].length;j++){
                System.out.print(dimension[i][j] + "\t");
            }
            System.out.println();
        }
        for(int i = 0;i<solucion.size();i++){
            System.out.println(solucion.get(i).toString());
            this.importanciaTotal += solucion.get(i).getImportancia();
        }
        System.out.println("La importancia total del maletero es de :"+this.importanciaTotal);
    }
}

