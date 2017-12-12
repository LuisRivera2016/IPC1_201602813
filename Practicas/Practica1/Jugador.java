/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sneak;

/**
 *
 * @author Luis Enrique
 */
public class Jugador {
      
    String nombre;
    int punteo;
    String fecha;
    int movimientos;

    
    
    
    public Jugador(){
      nombre="";
      punteo=10;
      fecha="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
    
   
}
