import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Street extends Place{
	protected String namn;
	protected int kostnad;
	protected Color col;
	
	public Street(int n, int x, int y, String a, String name, int kost, Color c){
		super(n, x, y, a);
		namn = name;
		kostnad=kost;
		col = c;
		setToolTipText(namn);
	}
	
	public String getNamn(){
		return namn;
	}
	
	public int getKost(){
		return kostnad;
	}
	
	public Color getCol(){
		return col;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(borderColor);
		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		g2d.draw(rect);
		g2d.setPaint(col);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(1, 1, 1, 1);
		if(align.equals("down")){
			rect = new Rectangle2D.Double(2, 2, 37, 19);
			rect2 = new Rectangle2D.Double(0, 0, 40, 20);
		}
		else if(align.equals("up")){
			rect = new Rectangle2D.Double(2, 40, 37, 18);
			rect2 = new Rectangle2D.Double(0, 40, 40, 20);
		}
		else if(align.equals("left")){
			rect = new Rectangle2D.Double(42, 2, 17, 37);
			rect2 = new Rectangle2D.Double(42, 0, 20, 40);
		}
		else if(align.equals("right")){
			rect = new Rectangle2D.Double(2, 2, 17, 37);
			rect2 = new Rectangle2D.Double(0, 0, 20, 40);
		}
		g2d.setPaint(col);
		g2d.fill(rect);
		g2d.setPaint(Color.black);
		g2d.draw(rect2);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 8));
		if(align.equals("right")){
			g2d.drawString(namn, 22, 25);
			g2d.drawString(String.valueOf(kostnad), 22, 35);
		}
		else if(align.equals("down")){
			g2d.drawString(namn, 10, 30);
			g2d.drawString(String.valueOf(kostnad), 10, 40);
		}
		else{
			g2d.drawString(namn, 4, 25);
			g2d.drawString(String.valueOf(kostnad), 4, 35);
		}
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
	
	public String toString(){
		return namn;
	}
}
		
		
		

	