import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.util.*;

public class Player extends JComponent
{
	private TexturePaint build;
	private Rectangle rect;
    private int ya;
    private int y;

	public Player(BufferedImage bi)
	{
		rect = new Rectangle(0, 0, 30, 30);
		build = new TexturePaint(bi, rect);
	}

    public void Player()
    {
        JLabel lblChar = new JLabel();
        //lblChar.setIcon(new BufferedImage("Character.PNG"));
        lblChar.setLocation(100,100);
        y = 60;
    }

	public TexturePaint getBuild()
	{
		return build;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(build);
		g2d.fill(rect);
	}

    public void move()
    {
        y += ya;
    }

    public int getY()
    {
        return y;
    }

/*    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
            ya = -1;
        }

        if (key == KeyEvent.VK_DOWN)
        {
            ya = 1;
        }
    }

    public void keyReleased(KeyEvent e)
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
            ya = 0;
        }

        if (key == KeyEvent.VK_DOWN)
        {
            ya = 0;
        }
    }*/
}