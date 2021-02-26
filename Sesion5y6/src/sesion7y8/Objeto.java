
package sesion7y8;

import sesion5y6.*;

public class Objeto implements Comparable<Objeto> {
    private String id;
    private int importancia;
    private int alto;
    private int ancho;

    public Objeto(String id, int importancia, int alto, int ancho) {
        this.id = id;
        this.importancia = importancia;
        this.alto = alto;
        this.ancho = ancho;
    }

    public String getId() {
        return id;
    }
    
    public int getImportancia() {
        return importancia;
    }
    
    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public void rotar (){
        int aux;
        aux = alto;
        alto = ancho;
        ancho = aux;
    }

    @Override
    public String toString() {
        return "Objeto{" + "id=" + id + ", importancia=" + importancia + ", alto=" + alto + ", ancho=" + ancho + '}';
    }
    
    public int compareTo (Objeto object){
        return this.importancia-object.importancia;
    }
    
}
