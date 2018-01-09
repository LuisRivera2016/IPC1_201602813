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

/**
 *
 * @author Luis Enrique
 */
public class pnlEstaciones extends JPanel{
    private URL url = getClass().getResource("/Graphiz/Estaciones.png");
    Image image = new ImageIcon(url).getImage();
 
    public pnlEstaciones(){
        this.setVisible(false);
    }
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), 100, this);
        
        super.paint(g);
    }
}
