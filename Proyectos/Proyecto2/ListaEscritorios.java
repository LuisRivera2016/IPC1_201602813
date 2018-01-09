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
import static listairport.Ventana.jtxConsola;

/**
 *
 * @author Luis Enrique
 */
public class ListaEscritorios {
    
    NodoEscritorios inicio;
    NodoEscritorios fin;
    
    public ListaEscritorios(){
        inicio = fin = null;
    }
    
     public void insertarAlfinal(String nEscritorio, ColaEscritorios pasajeros, PilaDocumentos documentos){
        
        NodoEscritorios temporal = new NodoEscritorios(nEscritorio,pasajeros,documentos, null, null);
        
        if(inicio == null){
            jtxConsola.append("--Escritorios de Registro--");
            jtxConsola.append(System.getProperty("line.separator"));
            temporal.setSiguiente(temporal);
            temporal.setAnterior(temporal);
            inicio = fin  = temporal;
            jtxConsola.append(inicio.getnEscritorio());
            jtxConsola.append(System.getProperty("line.separator"));
           
        }else{
            fin.setSiguiente(temporal);
            temporal.setAnterior(fin);
            temporal.setSiguiente(null);
            
            fin = temporal;
            
            jtxConsola.append(temporal.getnEscritorio());
            jtxConsola.append(System.getProperty("line.separator"));
        }
        
    }
    
    public String getDot(){
        String dot="digraph lista{\nrankdir=LR;\n"
                + "node[shape=record];\n";
        dot+="ncabecera[label=\"Escritorios Registro\"; color=\"blue\"];";
    
        if(inicio!=null){
            dot+="ncabecera->node"+inicio.hashCode()+"\n";
            
        }
        NodoEscritorios aux;
        aux=inicio;
        while(aux!=null){
            dot+=aux.toDot();
            //dot+=aux.getPasajeros().getDot();
            aux=aux.siguiente;
            
        }
        aux=inicio;
        while(aux.siguiente!=null){
           
            dot+="node"+aux.hashCode()+"->node"+aux.siguiente.hashCode()+";\n" ;
            dot+="node"+aux.hashCode()+"->node"+aux.anterior.hashCode()+";\n" ;  
            aux=aux.siguiente;
            
        }
        
        if(aux.siguiente==null){
             dot+="node"+aux.hashCode()+"->node"+aux.anterior.hashCode()+";\n" ;
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
