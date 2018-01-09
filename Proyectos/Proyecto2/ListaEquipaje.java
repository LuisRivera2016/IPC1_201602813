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
public class ListaEquipaje {
    
    NodoMaletas inicio;
    NodoMaletas fin;
    int tamaño;
    public ListaEquipaje(){
        inicio = fin = null;
    }
    
    public void insertarFinal(String maleta){
        
        NodoMaletas temporal = new NodoMaletas(maleta, null, null);
        if(inicio == null){
            
            temporal.setSiguiente(temporal);
            temporal.setAnterior(temporal);
            inicio = temporal;
            fin = inicio;
            
        }else{
            temporal.setAnterior(fin);
            fin.setSiguiente(temporal);
            inicio.setAnterior(temporal);
            temporal.setSiguiente(inicio);
            fin = temporal;
        }
        tamaño++;
    }
    public void eliminarPosicion(int posicion){
        if(posicion == 1 ){
            if (tamaño == 1){
                inicio = null;
                fin =  null;
                tamaño = 0;
                return;
            }
            
            inicio = inicio.getSiguiente();
            inicio.setAnterior(fin);
            fin.setSiguiente(inicio);
            tamaño--;
            return;
        }
        if(posicion == tamaño){
            
            fin = fin.getAnterior();
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
            tamaño--;
        }
        
        NodoMaletas temporal = inicio.getSiguiente();
        for (int i = 2; i <= tamaño; i++) {
            
            if(i == posicion){
                
                NodoMaletas anterior = temporal.getAnterior();
                NodoMaletas siguiente =  temporal.getSiguiente();
                
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
                tamaño--;
                return;
            }
            
            temporal = temporal.getSiguiente();
        }
    }
    
     public String getDot(){
        String dot="digraph lista{\nrankdir=UD;\n"
                + "node[shape=record];\n";
        dot+="ncabecera[label=\"Equipaje\"; color=\"blue\"];";
    
        if(inicio!=null){
            dot+="ncabecera->node"+inicio.hashCode()+"\n";
            
        }
         
        NodoMaletas aux;
        aux=inicio;
        while(aux.siguiente!=inicio){
            dot+=aux.toDot();
             
            aux=aux.siguiente;
            
        }
        aux=inicio;
        while(aux.siguiente!=inicio){
           
             if(aux.siguiente== inicio){
            dot+="node"+aux.hashCode()+"->node"+inicio.anterior.hashCode()+";\n" ;
            dot+="node"+aux.hashCode()+"->node"+fin.siguiente.hashCode()+";\n" ; 
           
       }
            dot+="node"+aux.hashCode()+"->node"+aux.siguiente.hashCode()+";\n" ;
            dot+="node"+aux.hashCode()+"->node"+aux.anterior.hashCode()+";\n" ;  
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
