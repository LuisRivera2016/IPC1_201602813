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
public class Historial {
    
    public static Jugador listajugadores[];
    public static int contador = 0;
    public static String[] arreglojugadores = new String[4];
    
    
    public Historial(){
        
        listajugadores = new Jugador [100+contador];
    }
    
    public void agregarJugador(String nombre, int punteo, String fecha, int movimientos){
        
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setPunteo(punteo);
        jugador.setFecha(fecha);
        jugador.setMovimientos(movimientos);
        listajugadores[contador]= jugador;
        contador++;
        
        //arreglo string
        
        arreglojugadores[0]=jugador.getNombre();
        arreglojugadores[1]=Integer.toString(jugador.getPunteo());
        arreglojugadores[2]=jugador.getFecha();
        arreglojugadores[3]=Integer.toString(jugador.getMovimientos());
    }
}
