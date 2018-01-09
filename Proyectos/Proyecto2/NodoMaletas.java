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
public class NodoMaletas {
    
    NodoMaletas siguiente;
    NodoMaletas anterior;
    String nMaleta;
    
    public NodoMaletas(){
        siguiente = anterior = null;
        nMaleta = "";
    }
    
    public NodoMaletas(String nMaleta, NodoMaletas siguiente, NodoMaletas anterior){
        this.nMaleta = nMaleta;
        this.siguiente = siguiente;
        this.anterior = anterior;
        
    }

    public NodoMaletas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMaletas siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMaletas getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoMaletas anterior) {
        this.anterior = anterior;
    }

    public String getnMaleta() {
        return nMaleta;
    }

    public void setnMaleta(String nMaleta) {
        this.nMaleta = nMaleta;
    }
    
    public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+this.nMaleta+"\"];\n";
    }
    
}
