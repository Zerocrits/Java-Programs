import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

//All of the different street types come to this as a main file

public class Place extends JPanel
{
	protected int n; //check
	protected Rectangle2D.Double rect;
	protected int x, y;
	protected String align;
	protected int x2;
	protected int y2;
	protected ArrayList<Player> players = new ArrayList<Player>();
	protected boolean owned = false;
	protected Color borderColor = Color.black;

	public Place(int n, int x, int y, String align)
	{
		this.n = n;
		this.x = x;
		this.y = y;
		this.align = align;

		if(align.equals("up") || align.equals("down"))
		{
			x2 = 40;
			y2 = 60;
		}

		else if(align.equals("left") || align.equals("right"))
		{
			x2 = 60;
			y2 = 40;
		}

		setBounds(x, y, x2, y2);
		setOpaque(true);
		setBackground(new Color(159, 214, 141));
	}

	public int getN()//check
	{
		return n;
	}

	public void setBorderColor(Color color)
	{
		borderColor = color;
	}

	public boolean insert(Player p)
	{
		if(players.contains(p))
			return false;

		players.add(p);
		add(p);

		return true;
	}
	public String getName()
	{
		return "Place";
	}

	public boolean taBort(Player p) //check
	{
		remove(p);
		players.remove(p);

		return true;
	}

	public boolean finns(Player p) //check
	{
		if(players.contains(p))
			return true;
		else
			return false;
	}

	public int getCost()
	{
		return 0;
	}

	public Color getColor()
	{
		return new Color(0,0,0);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setPaint(Color.black);
		graphics.setStroke(new BasicStroke(3));

		repaint();
	}
	public String toString()
	{
		return "Place";
	}
}

