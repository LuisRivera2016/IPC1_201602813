/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listairport;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luis Enrique
 */
public class Ventana extends JFrame implements ActionListener{

    
    public JTabbedPane jtpOpciones = new JTabbedPane();
    public static JPanel pnlConsola = new JPanel();
    public static JPanel pnlGraphiz = new JPanel();
    //paneles Imagenes
    
    public static pnlAviones pnlAviones = new pnlAviones();
    public static pnlPasajeros pnlPasajeros = new pnlPasajeros();
    public static pnlEscritorios pnlEscritorios = new pnlEscritorios();
    public static pnlEquipaje pnlEquipaje = new pnlEquipaje();
    public static pnlEstaciones pnlEstaciones = new pnlEstaciones();
    
    //url
    public static URL url ;
    public static    Image image ;
    //
    public static JButton btnAviones = new JButton("Llegada de Aviones");
    public static JButton btnPasajeros = new JButton("Desabordaje");
    public static JButton btnEscritorios = new JButton("Escritorio de Registros");
    public static JButton btnEquipaje = new JButton("Equipaje");
    public static JButton btnEstaciones = new JButton("Mantenimiento");
    
    public static JLabel lbFondo = new JLabel();
    
    JScrollPane scroll = new JScrollPane();
    //
    
    //Consola
    public static JTextArea jtxConsola = new JTextArea();
    public JScrollPane jsBarra = new JScrollPane(jtxConsola);
    
    public JLabel lblAviones = new JLabel("Ingrese el Numero de Aviones");
    public JLabel lblEscritorios = new JLabel("Ingrese el Numero de Escritorios");
    public JLabel lblMantenimiento = new JLabel("Ingrese el Numero de Estaciones de Mantenimiento");
    
    public JTextField txfAviones = new JTextField();
    public JTextField txfEscritorios = new JTextField();
    public JTextField txfMantenimiento = new JTextField();
    
    public JButton btnSiguiente = new JButton("Siguiente Paso");
    public JButton btnTerminar = new JButton("Terminar Simulacion");
    public JButton btnVerificar = new JButton("Iniciar Simulacion");
    
    //
    
    //variables inicio
    
    public static int numeroAviones;
    public static int numeroEscritorios;
    public static int numeroEstaciones;
    
    //
    
    //variables Simulacion
    
    //aviones
    public static String nAvion;
    public static int contadorA = 1;
    public static String tamaño;
    public static int pasajeros;
    public static int tDesabordaje;
    public static int tMantenimiento;
    
    //pasajeros
    public static String nPasajero;
    public static int maletas;
    public static int turnos;
    public static int documentos;
    public static int contadorP = 1;
    
    //maletas totales
    public static int nMaletas = 0;
    public static int nMaletasPasajero = 0;
    public static String nombreMaleta ="";
    public static int nMaleta= 1;
    //
    public static String nEstacion;
    public static int contadorE=1;
    //
    char Abecedario= 'A';
    char Letra ;
    String nEscritorio;
    int contadorEsc = 0;
    //Listas
    
    ListaAviones Aviones = new ListaAviones();
    ColaPasajeros Pasajeros = new ColaPasajeros();
    ListaEstaciones Estaciones = new ListaEstaciones();
    ListaEscritorios Escritorios = new ListaEscritorios();
    ListaEquipaje Equipaje = new ListaEquipaje();
    
    ColaEscritorios cEscritorios;
    PilaDocumentos pDocumentos;
    
    //
    public Ventana(){
        
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("ListAirport");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(950, 700);
        this.setLocationRelativeTo(null);
        
        numeroAviones = 0;
        numeroEscritorios = 0;
        numeroEstaciones = 0;
        //pnlConsola
        
        pnlConsola.setSize(945,695);
        pnlConsola.setLayout(null);
        
        jsBarra.setBounds(400, 0,  540, 630);
        jsBarra.setPreferredSize(new Dimension(800,400));
        
        lblAviones.setBounds(100, 10, 200, 30);
        lblEscritorios.setBounds(100, 90, 200, 30);
        lblMantenimiento.setBounds(50, 170, 300, 30);
        
        txfAviones.setBounds(110, 40, 150, 40);
        txfEscritorios.setBounds(110, 120, 150, 40);
        txfMantenimiento.setBounds(110, 200, 150, 40);
        
        btnSiguiente.setBounds(30, 350, 150, 30);
        btnSiguiente.addActionListener(this);
        btnTerminar.setBounds(210, 350, 150, 30);
        btnTerminar.addActionListener(this);
        btnVerificar.setBounds(120, 300, 150, 30);
        btnVerificar.addActionListener(this);
        
        
        
        pnlConsola.add(btnSiguiente);
        pnlConsola.add(btnTerminar);
        pnlConsola.add(btnVerificar);
        
        pnlConsola.add(txfAviones);
        pnlConsola.add(txfEscritorios);
        pnlConsola.add(txfMantenimiento);
        
        pnlConsola.add(lblAviones);
        pnlConsola.add(lblEscritorios);
        pnlConsola.add(lblMantenimiento);
        pnlConsola.add(jsBarra);
        
        //
        
        //Graphiz
        pnlGraphiz.setBounds(0, 0, 945, 695);
        pnlGraphiz.setLayout(null);
        
        btnAviones.setBounds(120, 30, 150, 30);
        btnAviones.addActionListener(this);
        btnPasajeros.setBounds(120, 80, 150, 30);
        btnPasajeros.addActionListener(this);
        btnEscritorios.setBounds(100, 130, 200, 30);
        btnEscritorios.addActionListener(this);
        btnEquipaje.setBounds(120, 180, 150, 30);
        btnEquipaje.addActionListener(this);
        btnEstaciones.setBounds(120, 230, 150, 30);
        btnEstaciones.addActionListener(this);
        
        lbFondo.setBounds(0, 0, 540, 630);
        
        pnlAviones.setBounds(400, 0, 540, 630);
        pnlAviones.setLayout(null);
        pnlAviones.add(lbFondo);
       
        
        pnlPasajeros.setBounds(400, 0, 540, 630);
        pnlPasajeros.setLayout(null);
        pnlPasajeros.add(lbFondo);
        
        pnlEscritorios.setBounds(400, 0, 540, 640);
        pnlEscritorios.setLayout(null);
        
        pnlEquipaje.setBounds(400, 0, 540, 630);
        pnlEquipaje.setLayout(null);
        
        pnlEstaciones.setBounds(400, 0, 540, 630);
        pnlEstaciones.setLayout(null);
        pnlEstaciones.add(lbFondo);
        
        
        pnlGraphiz.add(btnAviones);
        pnlGraphiz.add(btnPasajeros);
        pnlGraphiz.add(btnEscritorios);
        pnlGraphiz.add(btnEquipaje);
        pnlGraphiz.add(btnEstaciones);
        
        pnlGraphiz.add(pnlAviones);
        pnlGraphiz.add(pnlPasajeros);
         pnlGraphiz.add(pnlEscritorios);
       pnlGraphiz.add(pnlEquipaje);
        pnlGraphiz.add(pnlEstaciones);
        //
        
        jtpOpciones.setBounds(0,0,945,695);
        jtpOpciones.addTab("Consola",pnlConsola);
        jtpOpciones.addTab("Graphiz",pnlGraphiz);
        this.add(jtpOpciones);
      
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        
        if(evento.getSource()==btnSiguiente){
            
            
        }
        
        if(evento.getSource()== btnTerminar){
            
            
        }
        
        if(evento.getSource() == btnVerificar){
            
            
            if(txfAviones.getText().trim().equals("") || txfEscritorios.getText().trim().equals("") 
                    || txfMantenimiento.getText().trim().equals("") ){
                JOptionPane.showMessageDialog(null, "Debe ingresar Todos los Datos", "Error", JOptionPane.WARNING_MESSAGE);

                
            }else{
                
                try{
            numeroAviones = Integer.parseInt(txfAviones.getText());
            numeroEscritorios = Integer.parseInt(txfEscritorios.getText());
            numeroEstaciones = Integer.parseInt(txfMantenimiento.getText());
            generadorSimulacion();
	}catch(NumberFormatException ex){
        	//System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Debe ingresar solo Numeros", "Error", JOptionPane.WARNING_MESSAGE);
    	}
            
                
                
                
            }
            
            
            
        
        
        }
        
        if(evento.getSource()==btnAviones){
          
           
           
            
            pnlGraphiz.repaint();
           pnlAviones.repaint();
            pnlPasajeros.setVisible(false);
            pnlEscritorios.setVisible(false);
            pnlEquipaje.setVisible(false);
            pnlEstaciones.setVisible(false);
             pnlAviones.setVisible(true);
        }
        
        if(evento.getSource()==btnPasajeros){
            
            
            pnlGraphiz.repaint();
            pnlPasajeros.repaint();
            pnlAviones.setVisible(false);
            pnlPasajeros.setVisible(true);
            pnlEscritorios.setVisible(false);
            pnlEquipaje.setVisible(false);
            pnlEstaciones.setVisible(false);
        }
        
        if(evento.getSource()==btnEscritorios){
            
       
           
            pnlAviones.setVisible(false);
            pnlPasajeros.setVisible(false);
            pnlEscritorios.setVisible(true);
            pnlEquipaje.setVisible(false);
            pnlEstaciones.setVisible(false);
        }
        
        if(evento.getSource()==btnEquipaje){
            
            
             pnlEquipaje.repaint();
            pnlAviones.setVisible(false);
            pnlPasajeros.setVisible(false);
            pnlEscritorios.setVisible(false);
            pnlEquipaje.setVisible(true);
            pnlEstaciones.setVisible(false);
        }
        
        if(evento.getSource()==btnEstaciones){
            
           
            pnlEstaciones.repaint();
            pnlGraphiz.repaint();
            pnlAviones.setVisible(false);
            pnlPasajeros.setVisible(false);
            pnlEscritorios.setVisible(false);
            pnlEquipaje.setVisible(false);
            pnlEstaciones.setVisible(true);
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void generadorSimulacion(){
        
        
        Random random = new Random();
        
        //llegada de aviones
        for (int i = 0; i< numeroAviones; i++) {
            
            
            int tamA = random.nextInt(2)+1;
            switch(tamA){
                case 1:
                    tamaño = "Pequeño";
                    break;
                case 2:
                    tamaño = "Mediano";
                    break;
                case 3:
                    tamaño = "Grande";
                    break;
            }
            
            if(tamaño == "Pequeño"){
                pasajeros = random.nextInt(5)+5;
                tDesabordaje = 1;
                tMantenimiento = random.nextInt(2)+1;
                
            }else if(tamaño == "Mediano"){
                pasajeros = random.nextInt(10)+15;
                tDesabordaje = 2;
                tMantenimiento = random.nextInt(2)+2;
            }else{
                pasajeros = random.nextInt(10)+30;
                tDesabordaje = 3;
                tMantenimiento = random.nextInt(3)+3;
            }
            
            nAvion = "Avion"+contadorA;
            
              
            Aviones.insertarAlfinal(new Avion(nAvion,tamaño,pasajeros,tDesabordaje,tMantenimiento));
            contadorA++;
            jtxConsola.append("Desabordando: ");
            jtxConsola.append(System.getProperty("line.separator"));
             
            
            
            for (int j = 0; j < pasajeros; j++) {
                
                maletas = random.nextInt(3)+1;
                documentos = random.nextInt(9)+1;
                turnos = random.nextInt(2)+1;
                nPasajero = "Pasajero"+contadorP;
                
                nMaletas+=maletas;
               // System.out.println("maletas "+nMaletas);
                //System.out.println("maletas pas "+maletas);
                
                for (int k = 0; k < maletas; k++) {
                    nombreMaleta = "Maleta"+nMaleta;
                    Equipaje.insertarFinal(nombreMaleta);
                    nMaleta++;
                    
                }
                
                
                Pasajeros.insertarAlfinal(new Pasajero(nPasajero,maletas,turnos,documentos));
                contadorP++;
                
                
           
            }
            
               
        }
        
        for (int i = 0; i < numeroEscritorios; i++) {
            
            
            Letra = (char)(Abecedario+contadorEsc);
            nEscritorio = "Escritorio"+Letra;
            
           
            Escritorios.insertarAlfinal(nEscritorio, new ColaEscritorios(),new PilaDocumentos());
            
            contadorEsc++;
            
        }
        for (int k = 0; k < numeroEstaciones; k++) {
            
            nEstacion = "Estacion"+contadorE;
            
            Estaciones.insertarAlfinal(nEstacion, Aviones);
            contadorE++;
        }
        
        
       
        
        Aviones.graficar("Aviones");
        Pasajeros.graficar("Pasajeros");
        Estaciones.graficar("Estaciones");
        Escritorios.graficar("Escritorios");
        Equipaje.graficar("Equipaje");
    }
   
        
    
    
}
