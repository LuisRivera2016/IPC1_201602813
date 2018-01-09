/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listairport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Luis Enrique
 */
public class PilaDocumentos {
    
    NodoPila inicio;
    NodoPila fin;
    int nDocumentos;
    
    public PilaDocumentos(){
        inicio = fin = null;
        nDocumentos = 0;
    }
    
    
    public void insertarAlfrente(int documentos){
        
        if(inicio == null && fin == null){
            inicio = fin = new NodoPila(documentos);
            //System.out.println("Cancion añadida: "+Cancion);
            nDocumentos += inicio.getDocumentos();
                    
        }else{
            inicio = new NodoPila(documentos, inicio);
            nDocumentos += inicio.getDocumentos();
            //System.out.println("Cancion añadida: "+Cancion.toString());
        }
     
    }
    
      public int eliminarDelinicio(){
        int documento= 0;
        if(inicio==null || fin == null ){
            System.out.println("Pila Vacia");
        }else{
              documento = inicio.getDocumentos();
              
            if(inicio == fin){
                inicio = fin = null;
                nDocumentos -= inicio.getDocumentos();
            }else{
                inicio = inicio.siguiente;
                 nDocumentos -= inicio.getDocumentos();
            }
        }
        return documento;
    }
      
       public String getDot(){
        String dot="digraph lista{\nrankdir=UD;\n"
                + "node[shape=record];\n";
        dot+="ncabecera[label=\"Documentos\"; color=\"blue\"];";
        if(inicio!=null){
            dot+="ncabecera->node"+inicio.hashCode()+"\n";
        }
        NodoPila aux;
        aux=inicio;
        while(aux!=null){
            dot+=aux.toDot();
            aux=aux.siguiente;
        }
        aux=inicio;
        while(aux.siguiente!=null){
            dot+="node"+aux.hashCode()+"->node"+aux.siguiente.hashCode()+";\n" ;
            aux=aux.siguiente;
        }
        dot+="}";
        return dot;
    }
    
    public void crearArchivo(String nombre, String contenido){
        FileWriter archivo = null;
        PrintWriter escritor=null;
        try{         
            archivo=new FileWriter(nombre);
            escritor = new PrintWriter(archivo);
            escritor.println(contenido);
        }catch(IOException e){e.printStackTrace();            
        }finally{
            try{
                if(archivo!=null){archivo.close();}
            }catch(Exception ex){ex.printStackTrace();}
       }
    }
    
    public void generarPNG(String nombre){
        try{
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("dot -Tpng "+nombre+".dot -o "+"src/Graphiz/"+nombre+".png");
            try{
                Thread.sleep(500);
            }catch(Exception ex){ex.printStackTrace(); }
            File file = new File(nombre+".png");
            
            //Desktop.getDesktop().open(file);        
        }catch(Exception e){}
    }
    
    public void graficar(String nombre){        
        crearArchivo(nombre+".dot", getDot());
        generarPNG(nombre);
    }
}
