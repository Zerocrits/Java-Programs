import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class MiniMap extends JPanel
{
	private HashMap<Integer, Color> shapeColors = new HashMap<Integer, Color>();
	private HashMap<Integer, Rectangle2D.Double> shapes = new HashMap<Integer, Rectangle2D.Double>();
//SIZES WILL NEED TO BE ADJUSTED
	public MiniMap()
	{
		shapeColors.put(1, Color.green);
		shapeColors.put(2, Color.white);
		shapeColors.put(3, Color.orange);
		shapeColors.put(4, Color.white);
		shapeColors.put(5, Color.white);
		shapeColors.put(6, Color.white);
		shapeColors.put(7, Color.orange);
		shapeColors.put(8, Color.green);

		shapeColors.put(9, Color.white);
		shapeColors.put(10, Color.white);
		shapeColors.put(11, Color.white);
		shapeColors.put(12, Color.white);
		shapeColors.put(13, Color.white);
		shapeColors.put(14, Color.orange);

		shapeColors.put(15, Color.green);
		shapeColors.put(16, Color.white);
		shapeColors.put(17, Color.orange);
		shapeColors.put(18, Color.white);
		shapeColors.put(19, Color.white);
		shapeColors.put(20, Color.white);
		shapeColors.put(21, Color.white);
		shapeColors.put(22, Color.green);

		shapeColors.put(23, Color.white);
		shapeColors.put(24, Color.orange);
		shapeColors.put(25, Color.white);
		shapeColors.put(26, Color.orange);
		shapeColors.put(27, Color.white);
		shapeColors.put(28, Color.white);
		addRects();
	}

	public Color getColorNr(int i)
	{
		Color c = Color.black;
		Set<Map.Entry<Integer, Color>> s = shapeColors.entrySet();
		for(Map.Entry<Integer, Color> m : s)
			if(i == m.getKey())
				c = m.getValue();
		return c;
	}

	public void addRects()
	{
		shapes.put(1, new Rectangle2D.Double(90,90,20,20));
		shapes.put(2, new Rectangle2D.Double(80,90,10,20));
		shapes.put(3, new Rectangle2D.Double(70,90,10,20));
		shapes.put(4, new Rectangle2D.Double(60,90,10,20));
		shapes.put(5, new Rectangle2D.Double(50,90,10,20));
		shapes.put(6, new Rectangle2D.Double(40,90,10,20));
		shapes.put(7, new Rectangle2D.Double(30,90,10,20));
		shapes.put(8, new Rectangle2D.Double(10,90,20,20));

		shapes.put(9, new Rectangle2D.Double(10,80,20,10));
		shapes.put(10, new Rectangle2D.Double(10,70,20,10));
		shapes.put(11, new Rectangle2D.Double(10,60,20,10));
		shapes.put(12, new Rectangle2D.Double(10,50,20,10));
		shapes.put(13, new Rectangle2D.Double(10,40,20,10));
		shapes.put(14, new Rectangle2D.Double(10,30,20,10));

		shapes.put(15, new Rectangle2D.Double(10,10,20,20));
		shapes.put(16, new Rectangle2D.Double(30,10,10,20));
		shapes.put(17, new Rectangle2D.Double(40,10,10,20));
		shapes.put(18, new Rectangle2D.Double(50,10,10,20));
		shapes.put(19, new Rectangle2D.Double(60,10,10,20));
		shapes.put(20, new Rectangle2D.Double(70,10,10,20));
		shapes.put(21, new Rectangle2D.Double(80,10,10,20));
		shapes.put(22, new Rectangle2D.Double(90,10,20,20));

		shapes.put(23, new Rectangle2D.Double(90,30,20,10));
		shapes.put(24, new Rectangle2D.Double(90,40,20,10));
		shapes.put(25, new Rectangle2D.Double(90,50,20,10));
		shapes.put(26, new Rectangle2D.Double(90,60,20,10));
		shapes.put(27, new Rectangle2D.Double(90,70,20,10));
		shapes.put(28, new Rectangle2D.Double(90,80,20,10));
	}

	public void setColorOnBrick(int i, Color c)
	{
		shapeColors.put(i, c);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(new Color(78,157,78));
		Rectangle2D.Double rect = new Rectangle2D.Double(0,0,120,120);
		g2d.fill(rect);
		Set<Map.Entry<Integer, Rectangle2D.Double>> s = shapes.entrySet();
		for(Map.Entry<Integer, Rectangle2D.Double> m : s)
		{
			g2d.setPaint(getColorNr(m.getKey()));
			g2d.fill(m.getValue());
			g2d.setPaint(Color.black);
			g2d.draw(m.getValue());
		}
		repaint();
	}
}


