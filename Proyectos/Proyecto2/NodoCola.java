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
public class NodoCola {
    
    NodoCola siguiente;
    Pasajero pasajero;
    
    public NodoCola(Pasajero pasajero){
        
        this(pasajero, null);
    }
    
    public NodoCola(Pasajero pasajero, NodoCola siguiente){
        this.siguiente = siguiente;
        this.pasajero = pasajero;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    
    public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+this.pasajero.getnPasajero()+"\"];\n";
    }
}
