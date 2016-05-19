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
		setToolTipText(name);
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
		Graphics2D g2d = (Graphics2D)g; //check
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
			rect = new Rectangle2D.Double(2, 2, 37, 19);
			rect2 = new Rectangle2D.Double(0, 0, 40, 20);
		}
		else if(align.equals("up"))
		{
			rect = new Rectangle2D.Double(2, 40, 37, 18);
			rect2 = new Rectangle2D.Double(0, 40, 40, 20);
		}
		else if(align.equals("left"))
		{
			rect = new Rectangle2D.Double(42, 2, 17, 37);
			rect2 = new Rectangle2D.Double(42, 0, 20, 40);
		}
		else if(align.equals("right"))
		{
			rect = new Rectangle2D.Double(2, 2, 17, 37);
			rect2 = new Rectangle2D.Double(0, 0, 20, 40);
		}
		g2d.setPaint(color);
		g2d.fill(rect);
		g2d.setPaint(Color.black);
		g2d.draw(rect2);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 8)); //change font
		if(align.equals("right"))
		{
			g2d.drawString(name, 22, 25);
			g2d.drawString(String.valueOf(cost), 22, 35);
		}
		else if(align.equals("down"))
		{
			g2d.drawString(name, 10, 30);
			g2d.drawString(String.valueOf(cost), 10, 40);
		}
		else
		{
			g2d.drawString(name, 4, 25);
			g2d.drawString(String.valueOf(cost), 4, 35);
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




