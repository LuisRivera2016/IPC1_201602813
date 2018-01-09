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
public class NodoEscritorios {
    
    
    String nEscritorio;
    NodoEscritorios siguiente;
    NodoEscritorios anterior;
    ColaEscritorios pasajeros;
    PilaDocumentos documentos;
    
    public NodoEscritorios (){
        siguiente = anterior = null;
        pasajeros = null;
        documentos = null;
    }
    
    public NodoEscritorios(String nEscritorio,ColaEscritorios pasajeros, PilaDocumentos documentos, NodoEscritorios siguiente, NodoEscritorios anterior){
        this.nEscritorio = nEscritorio;
        this.pasajeros = pasajeros;
        this.documentos = documentos;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoEscritorios getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEscritorios siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEscritorios getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEscritorios anterior) {
        this.anterior = anterior;
    }

    public ColaEscritorios getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ColaEscritorios pasajeros) {
        this.pasajeros = pasajeros;
    }

    public PilaDocumentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(PilaDocumentos documentos) {
        this.documentos = documentos;
    }

    public String getnEscritorio() {
        return nEscritorio;
    }

    public void setnEscritorio(String nEscritorio) {
        this.nEscritorio = nEscritorio;
    }
    
    
     public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+this.nEscritorio+"\"];\n";
    }
}
