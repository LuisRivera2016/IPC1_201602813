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
public class ListaEstaciones {
    
    NodoEstaciones inicio;
    NodoEstaciones fin;
    
    
    public ListaEstaciones(){
        inicio = fin = null;
    }
    
     public void insertarAlfinal(String nEstacion, ListaAviones aviones){
        
        if(inicio== null && fin ==null){
            inicio = fin = new NodoEstaciones(nEstacion,aviones,null);
        }else{
            fin = fin.siguiente = new NodoEstaciones(nEstacion);
        }
    } 
     
     public String getDot(){
        String dot="digraph lista{\nrankdir=LR;\n"
                + "node[shape=record];\n";
        dot+="ncabecera[label=\"Mantenimiento\"; color=\"blue\"];";
        if(inicio!=null){
            dot+="ncabecera->node"+inicio.hashCode()+"\n";
          
        }
        NodoEstaciones aux;
        
        aux=inicio;
        //dot+=aux.getAviones().getDot()+";\n" ;
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
