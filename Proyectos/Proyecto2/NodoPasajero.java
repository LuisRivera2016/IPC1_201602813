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
public class NodoPasajero {
    
    NodoPasajero siguiente;
    Pasajero pasajero;
    
    public NodoPasajero(Pasajero pasajero){
        this(pasajero , null);
        
    }
    
    public NodoPasajero(Pasajero pasajero, NodoPasajero siguiente){
        this.pasajero = pasajero;
        this.siguiente = siguiente;
        
    }

    public NodoPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPasajero siguiente) {
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
