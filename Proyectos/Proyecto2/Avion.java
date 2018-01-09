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
public class Avion {
    
    String tipo;
    String nAvion;
    int pasajeros;
    int tDesabordaje;
    int tMantenimiento;
    
    
    
    public Avion(String nAvion, String tipo, int pasajeros, int tDesabordaje, int tMantenimiento){
        
        this.nAvion = nAvion;
        this.tipo = tipo;
        this.pasajeros = pasajeros;
        this.tDesabordaje = tDesabordaje;
        this.tMantenimiento = tMantenimiento;
        
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int gettDesabordaje() {
        return tDesabordaje;
    }

    public void settDesabordaje(int tDesabordaje) {
        this.tDesabordaje = tDesabordaje;
    }

    public int gettMantenimiento() {
        return tMantenimiento;
    }

    public void settMantenimiento(int tMantenimiento) {
        this.tMantenimiento = tMantenimiento;
    }

    public String getnAvion() {
        return nAvion;
    }

    public void setnAvion(String nAvion) {
        this.nAvion = nAvion;
    }
    
    
    
    
}
