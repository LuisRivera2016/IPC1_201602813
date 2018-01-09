/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listairport;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Enrique
 */
public class pnlPasajeros extends JPanel {
    private URL url = getClass().getResource("/Graphiz/Pasajeros.png");
    Image image = new ImageIcon(url).getImage();
   
    public pnlPasajeros(){
        this.setVisible(false);
    }
    public void paint(Graphics g){
        g.drawImage(image, 200, 0, 200, getHeight(), this);
        
        super.paint(g);
    }
}
