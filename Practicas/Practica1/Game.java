/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sneak;

import java.util.Scanner;
import java.util.Random;

//variables estaticas

import static sneak.Historial.listajugadores;
import static sneak.Historial.arreglojugadores;
import static sneak.Historial.contador;
/**
 *
 * @author Luis Enrique
 */
public class Game {
        
    // historial
    Historial jugadores = new Historial();
    //
    Scanner entrada = new Scanner(System.in);
    String mapa[][] = new String[35][70];
    String datos[][] = new String [4][2];
    //int contador=1;
    String historial [] = new String[3];
    
    //sneak datos
    
    int posx = 1;
    int posy = 1;
    int movimientos = 0;
    int puntos = 10;
    String nombre, fecha;
    
    public void empezar(){
        System.out.println("Sneak Java");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X              Seleccione una Opcion              X");
        System.out.println("X            Presione 1. para Nuevo Juego         X");
        System.out.println("X              Presione 2. para  Salir            X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        
        try {
            int opcion = entrada.nextInt();
            if(opcion ==1){
                limpiar();
                juego();
            }else if(opcion==2){
            System.out.println("Adios");
        } 
        } catch (Exception e) {
            
            limpiar();
            System.out.println(e);
            System.out.println("Ingrese una Opcion Correcta");
           ;
        
        }
        
    }
    
    //limpiar consola
    public void limpiar(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
    
    //mapa del juego
    public void iniciarmapa(){
        
        //quitarle null al mapa
        
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 70; j++) {
                mapa[i][j]= " ";
                
            }
        }
        
        //escribir laberinto
        
        for (int i = 0; i < 20; i++) {
            Random pos = new Random();
            int pos1 = pos.nextInt(35);
            int pos2 = pos.nextInt(70);
            mapa[pos1][pos2] = "#";
            
        }
        
        //marco del sneak
        //paredes verticales
        for (int i = 0; i < 35; i++) {
            mapa[i][0]="#";
            mapa[i][69]="#";
        }
        
        //paredes horizontales
        for (int i = 0; i < 70; i++) {
            mapa[0][i]="#";
            mapa[34][i]="#";
        }
        
        //fila sneak
        
        for (int i = 1; i < 10; i++) {
            mapa[1][i]=" ";
            
            
        }
        
        //pos inicial sneak
        
        mapa[posx][posy] = "Q";
        
        
        
        //Comida
        //% +10 puntos y aumento
        for (int i = 0; i < 40; i++) {
            Random pos = new Random();
            int pos1 = pos.nextInt(33)+1;
            int pos2 = pos.nextInt(68)+1;
            
            if(mapa[pos1][pos2].equals(" ") ){
                mapa[pos1][pos2] = "%";
            }else{
                i--;
            }
        }
        
        // $ -10 puntos y disminucion
        for (int i = 0; i < 30; i++) {
            Random pos =  new Random();
            int pos1 = pos.nextInt(33)+1;
            int pos2 = pos.nextInt(68)+1;
            if(mapa[pos1][pos2].equals(" ")){
                mapa[pos1][pos2] = "$";
                
            }else{
                i--;
            }
        }
        
        
    }
    
    //imprmir mapa
    
    public void imprimir(){
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 70; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println("");
        }
    }
    
    //mover sneak
    public void movimiento(String movimiento){
        
        //movimineto hacia arriba
        if(movimiento.toLowerCase().equals("w")){
            if(mapa[posy-1][posx].equals("#")){
                posy-=0;
            }else{
                posy--;
                mapa[posy+1][posx]=" ";
                movimientos++;
            }
            
            if(mapa[posy-1][posx].equals("%")){
                puntos+=10;
            }
            if(mapa[posy-1][posx].equals("$")){
                puntos-=10;
            }
        }
        
        //movimineto izquierda
        
        if(movimiento.toLowerCase().equals("a")){
            
            if(mapa[posy][posx-1].equals("#")){
                posx-=0;
                
            }else{
                posx--;
                mapa[posy][posx+1]=" ";
                movimientos++;
            }
            
            if(mapa[posy][posx-1].equals("%")){
                puntos+=10;
            }
            if(mapa[posy][posx-1].equals("$")){
                puntos-=10;
            }
        }
        
        //movimiento hacia abajo
        
        if(movimiento.toLowerCase().equals("s")){
            
            if(mapa[posy+1][posx].equals("#")){
                posy+=0;
            }else{
                posy++;
                mapa[posy-1][posx]=" ";
                movimientos++;
            }
            
            if(mapa[posy+1][posx].equals("%")){
                puntos+=10;
            }
            if(mapa[posy+1][posx].equals("$")){
                puntos-=10;
            }
        }
        
        //movimiento hacia la derechas
        
        if(movimiento.toLowerCase().equals("d")){
            if(mapa[posy][posx+1].equals("#")){
                posx+=0;
            }else{
                posx++;
                mapa[posy][posx-1]=" ";
                movimientos++;
            }
            
            if(mapa[posy][posx+1].equals("%")){
                puntos+=10;
            }
            if(mapa[posy][posx+1].equals("$")){
                puntos-=10;
            }
        }
        
        if(puntos<=0){
            limpiar();
            System.out.println("Juego Perdido");
            historial();
            menu();
        }
        
        if(puntos>=100){
            limpiar();
            System.out.println("Juego Ganado");
            historial();
            menu();
        }
    }
    
    
    //vector datos del jugador
    
    public void datos(){
    
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                datos[i][j]=" ";
            }
        }
        
        datos[0][0]="Jugador:  ";
        datos[0][1]=nombre;
        datos[1][0]="Fecha de Nacimiento:  ";
        datos[1][1]=fecha;
        datos[2][0]="Movimientos: ";
        datos[2][1]=Integer.toString(movimientos);
        datos[3][0]="Punteo: ";
        datos[3][1]=Integer.toString(puntos);
          //asignacion();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(datos[i][j]);
            }
            System.out.println(" ");
        }
        
         System.out.println("Puntos por Comida: " + "% +10 Puntos  "+ "$ -10 Puntos");
         System.out.println("Se Gana el juego si se tienen 100 Puntos  "+" Se Pierde el juego si se tienen 0 Puntos");
         System.out.println("Presione: "+"M "+"para Pausar el Juego e ir a Menu para ver el Historial ó Salir del juego ");
    }
    
    //Historial nombre y punto de jugadores
    
    public void historial(){
        
      
        for (int i = 0; i < 3; i++) {
           
                historial[i]= " ";
            
            
        }
        
        historial[0]="Jugador ";
        historial[1]="Fecha de Nacimiento ";
        historial[2]="Punteo ";
         for (int j = 0; j < 3; j++) {
                System.out.print(historial[j]);
                
            }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i <contador; i++) {
            
            System.out.println(listajugadores[i].getNombre()+"       "+listajugadores[i].getFecha()+"        "+
                 listajugadores[i].getPunteo())   ;
            
        }
        
        //imprimir historial
        
       
           
           
            
        
    }
    
    //Menu opciones
    
    public void menu(){
        
        
        System.out.println("                        MENU                        ");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X               Seleccione una Opcion              X");
        System.out.println("X             Presione M para continuar            X");
        System.out.println("X            Presione N para nuevo juego           X");
        System.out.println("X              Presione X para Salir               X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        String opcion = entrada.next();
        
        
        if(opcion.equalsIgnoreCase("m")){
            
               if(puntos<=0 || puntos>=100){
                   limpiar();
                   if(puntos<=0){
                       System.out.println("No puede Continuar ya que Perdio el Juego");
                       historial();
                       menu(); 
                   }else if(puntos>=100){
                       System.out.println("No puede Continuar ya que Gano el Juego");
                       historial();
                      menu();  
                   }
                    
             }else{
            limpiar();
            System.out.println("Movimientos: " + "W. Arriba --"+ "A. Izquierda --"+ "S. Abajo --"+"D. Derecha");
           imprimir();
        String movimiento = "";
        while(!movimiento.equalsIgnoreCase("x") || puntos>0 || puntos< 100){
            movimiento = entrada.next();
            movimiento(movimiento);
            limpiar();
             System.out.println("Movimientos: " + "W. Arriba --"+ "A. Izquierda --"+ "S. Abajo --"+"D. Derecha");
            mapa[posy][posx]="Q";
            imprimir();
            datos();
           
        
            if(movimiento.equalsIgnoreCase("m")){
               
                limpiar();
                System.out.println("Historial: ");
               
                historial();
                menu();
                  
            }
            
            
         
        }
        }
        }
        
        if(opcion.equalsIgnoreCase("n")){
           // asignacion();
            posx=1;
            posy=1;
            movimientos=0;
            puntos= 10;
            //contador++;
            /*if(contador>10){
                contador=1;
            }*/
            
            juego();
            
        }
        
        if(opcion.equalsIgnoreCase("x")){
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("X                      Adios                       X");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.exit(0);
        }
        
        if(!opcion.equalsIgnoreCase("m") || !opcion.equalsIgnoreCase("n")  || !opcion.equalsIgnoreCase("x") ){
             
            limpiar();
            System.out.println("Historial: ");
            historial();
            menu();
        }
    }
    
    //datos y vector de datos juego
    public void juego(){
        
         System.out.println("Ingrese su Nombre");
        
        nombre = entrada.next();
        System.out.println("Ingrese su fecha de Nacimiento");
        fecha = entrada.next();
        iniciarmapa();
         System.out.println("Movimientos: " + "W. Arriba --"+ "A. Izquierda --"+ "S. Abajo --"+"D. Derecha");
        imprimir();
        String movimiento = "";
        while(!movimiento.equalsIgnoreCase("m") || puntos>0 || puntos< 100){
            movimiento = entrada.next();
            movimiento(movimiento);
            limpiar();
            System.out.println("Movimientos: " + "W. Arriba --"+ "A. Izquierda --"+ "S. Abajo --"+"D. Derecha");
            mapa[posy][posx]="P";
            imprimir();
            datos();
            jugadores.agregarJugador(nombre, puntos, fecha, movimientos);
             
        
            if(movimiento.equalsIgnoreCase("m")){
           
                limpiar();
                System.out.println("Historial: ");
                historial();
                menu();
                
            }
            
            
         
        }
    }
    
    //mandar datos a historial
    
    public void asignacion(String nombre, int puntos, String fecha, int movimientos){
        this.nombre= nombre;
        this.puntos= puntos;
        this.fecha=fecha;
        this.movimientos=movimientos;
        
        
        
    }
    
}
