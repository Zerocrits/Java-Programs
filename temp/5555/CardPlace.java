import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;

public class CardPlace extends Place{
	protected String typeCard;
	private TexturePaint bild;
	private Rectangle rect2;
	
	public CardPlace(int n, int x, int y, String a, String name, BufferedImage b){
		super(n, x, y, a);
		typeCard = name;
		if(align.equals("right") || align.equals("left"))
			rect2 = new Rectangle(20, 5, 30, 30);
		else if(align.equals("down") || align.equals("up"))
			rect2 = new Rectangle(5, 20, 30, 30);
		bild = new TexturePaint(b, rect2);
	}
	
	public String getNamn(){
		return typeCard;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(Color.black);
		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		g2d.draw(rect);
		g2d.setPaint(bild);
		g2d.fill(rect2);
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
		
		
		
