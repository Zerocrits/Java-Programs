import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Corner extends Place{
	protected String typ;
	
	public Corner(int n, int x, int y, String a, String t){
		super(n, x, y, a);
		setBounds(x, y, 60, 60);
		typ = t;
	}
	
	public String getNamn(){
		return typ;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(Color.black);
		rect = new Rectangle2D.Double(0, 0, 60, 60);
		g2d.draw(rect);
		g2d.setPaint(Color.black);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 8));
		g2d.drawString(typ, 4, 25);
		if(!players.isEmpty()){
			int px = 10;
			int py = 5;
			for(Player p : players){
				add(p);
				p.setPosition(px, py);
				if(align.equals("up") || align.equals("down"))
					py+=20;
				else if(align.equals("left") || align.equals("right"))
					px+=20;
			}
		}
	}
}
		
		