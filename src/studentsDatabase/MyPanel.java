package studentsDatabase;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MyPanel extends JPanel{
	public void paintComponent(Graphics g){  
        super.paintComponent(g);  
        Image image = new ImageIcon("lib/image0.jpg").getImage();  
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
    } 
}