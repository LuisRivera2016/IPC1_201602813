/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listairport;

/**
 *
 * @author Luis Enrique
 */
public class NodoAviones {
    
    
    NodoAviones siguiente;
    NodoAviones anterior;
    Avion avion;
    
    
    public NodoAviones(){
        
        siguiente = anterior = null;
        avion = null;
        
    }
    
    public NodoAviones(Avion avion, NodoAviones siguiente, NodoAviones anterior){
        this.avion = avion;
       
        this.siguiente = siguiente;
        this.anterior = anterior;
        
        
    }

    public NodoAviones getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAviones siguiente) {
        this.siguiente = siguiente;
    }

    public NodoAviones getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoAviones anterior) {
        this.anterior = anterior;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    
     public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+this.avion.getnAvion()+"\"];\n";
    }
    
    
    
}
