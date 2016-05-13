import java.awt.*;
import javax.swing.*;

public class BildPanel extends JPanel{
	Image bild;
	
	public BildPanel(Image fil){
		setLayout(null);
		bild = fil;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bild, 0, 0, this);
		repaint();
	}
}