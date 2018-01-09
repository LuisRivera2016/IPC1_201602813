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
public class NodoPila {
    
    NodoPila siguiente;
    int documentos;
    
    
    public NodoPila(int documentos){
        this(documentos,null);
    }
    
    public NodoPila(int documentos, NodoPila siguiente){
        this.documentos = documentos;
        this.siguiente = siguiente;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

    public int getDocumentos() {
        return documentos;
    }

    public void setDocumentos(int documentos) {
        this.documentos = documentos;
    }
    
    public String toDot(){        
        return "node"+this.hashCode()+"[label=\""+"Documentos "+this.documentos+"\"];\n";
    }
}
