import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

public class Dice extends JComponent{
	RoundRectangle2D shape;
	private Ellipse2D.Double circle;
	private int antal = 1;

	public Dice(){
		shape = new RoundRectangle2D.Double(0.0, 0.0, 12.0, 12.0, 5.0, 5.0);
		setBounds(100, 100, 14, 14);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(new Color(239, 239, 246));
		g2d.fill(shape);
		g2d.setPaint(Color.black);
		g2d.draw(shape);
		if(antal == 1){
			circle = new Ellipse2D.Double(4,4,3,3);
			g2d.fill(circle);
		}
		else if(antal == 2){
			circle = new Ellipse2D.Double(1,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,7,3,3);
			g2d.fill(circle);
		}
		else if(antal == 3){
			circle = new Ellipse2D.Double(1,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(4,4,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,7,3,3);
			g2d.fill(circle);
		}
		else if(antal == 4){
			circle = new Ellipse2D.Double(1,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(1,7,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,7,3,3);
			g2d.fill(circle);
		}
		else if(antal == 5){
			circle = new Ellipse2D.Double(1,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(1,7,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,7,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(4,4,3,3);
			g2d.fill(circle);
		}
		else if(antal == 6){
			circle = new Ellipse2D.Double(1,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(4,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,1,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(1,7,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(4,7,3,3);
			g2d.fill(circle);
			circle = new Ellipse2D.Double(7,7,3,3);
			g2d.fill(circle);
		}
		repaint();

	}
	public void settAntal(int i){
		antal = i;
	}
	
	public int getAntal(){
		return antal;
	}
}
	
	