import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

//This is the purchaseable STREETS

public class Street extends Place
{
	protected String name;
	protected int cost;
	protected Color color;

	public Street(int n, int x, int y, String a, String name, int cost, Color c)
	{
		super(n, x, y, a);
		this.name = name;
		this.cost = cost;
		color = c;
		setToolTipText(name + "($" + cost + ")");
	}

	public String getName()
	{
		return name;
	}

	public int getCost()
	{
		return cost;
	}

	public Color getColor()
	{
		return color;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(borderColor);
		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		g2d.draw(rect);
		g2d.setPaint(color);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(1, 1, 1, 1);
		if(align.equals("down"))
		{
			rect = new Rectangle2D.Double(2, 2, 58, 19);
			rect2 = new Rectangle2D.Double(0, 0, 59, 20);
		}
		else if(align.equals("up"))
		{
			rect = new Rectangle2D.Double(2, 2, 58, 19);
			rect2 = new Rectangle2D.Double(0, 0, 59, 20);
		}
		else if(align.equals("left"))
		{
			rect = new Rectangle2D.Double(98, 2, 19, 58);
			rect2 = new Rectangle2D.Double(98, 0, 20, 59);
		}
		else if(align.equals("right"))
		{
			rect = new Rectangle2D.Double(2, 2, 19, 58);
			rect2 = new Rectangle2D.Double(0, 0, 20, 59);
		}
		g2d.setPaint(color);
		g2d.fill(rect);
		g2d.setPaint(Color.black);
		g2d.draw(rect2);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 17)); //change font
		if(align.equals("right"))
		{
			g2d.drawString(name, 25, 20);
			g2d.drawString("$" + String.valueOf(cost), 25, 40);
		}
		else if(align.equals("down"))
		{
			g2d.drawString(name, 3, 40);
			g2d.drawString("$" + String.valueOf(cost), 10, 110);
		}
		else if(align.equals("up"))
		{
			g2d.drawString(name, 3, 40);
			g2d.drawString("$" + String.valueOf(cost), 10, 110);
		}
		else if(align.equals("left"))
		{
			g2d.drawString(name, 5, 20);
			g2d.drawString("$" + String.valueOf(cost), 5, 40);
		}
		if(!players.isEmpty())
		{
			int px = 10; //pixels on X
			int py = 5; //pixels on Y
			for(Player p : players) //for each
			{
				add(p);
				p.setPosition(px, py);
				if(align.equals("up") || align.equals("down"))
					py+=20;
				else if(align.equals("left") || align.equals("right"))
					px+=20;
			}
		}
	}

	public String toString()
	{
		return name;
	}
}




