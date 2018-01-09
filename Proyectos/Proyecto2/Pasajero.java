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
public class Pasajero {
    
    String nPasajero;
    int maletas;
    int turnos;
    int documentos;
    
    
    public Pasajero(String nPasajero, int maletas, int turnos, int documentos){
        this.nPasajero = nPasajero;
        this.maletas = maletas;
        this.turnos = turnos;
        this.documentos = documentos;
        
        
    }

    public int getMaletas() {
        return maletas;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getDocumentos() {
        return documentos;
    }

    public void setDocumentos(int documentos) {
        this.documentos = documentos;
    }

    public String getnPasajero() {
        return nPasajero;
    }

    public void setnPasajero(String nPasajero) {
        this.nPasajero = nPasajero;
    }
    
    
}
