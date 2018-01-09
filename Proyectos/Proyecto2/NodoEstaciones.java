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
public class NodoEstaciones {
    
    public NodoEstaciones siguiente;
    public ListaAviones aviones;
    public String nEstacion;
    
    public NodoEstaciones(String nEstacion, NodoEstaciones siguiente){
        this(nEstacion,null, siguiente);
    }
    public NodoEstaciones(String nEstacion,ListaAviones aviones, NodoEstaciones siguiente){
        this.nEstacion = nEstacion;
        this.aviones = aviones;
        this.siguiente = siguiente;
    }
    public NodoEstaciones(String nEstacion){
        this.nEstacion = nEstacion;
    }

    public NodoEstaciones getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstaciones siguiente) {
        this.siguiente = siguiente;
    }

    public ListaAviones getAviones() {
        return aviones;
    }

    public void setAviones(ListaAviones aviones) {
        this.aviones = aviones;
    }

    public String getnEstacion() {
        return nEstacion;
    }

    public void setnEstacion(String nEstacion) {
        this.nEstacion = nEstacion;
    }
    
    
    
    public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+this.nEstacion+"\"];\n";
    }
    
}
