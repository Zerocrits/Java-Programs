import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Wall
{
	private int y;
	private int x;
	private int height;
	private double speed;
	private Game game;

    public Wall(Game game)
    {
        x = 900;
        y = 490;
        speed=10;
        this.game=game;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
		return x;
	}

	public void tick()
	{
		if(x < 0)
		{
			x = 1000;
			height= (int) (Math.random() * 140) + 30;
			speed = (int) (Math.random() * 18) + 10;
			/*if(game.getScore()<32)
				speed+=.5;*/
			game.addScore();
			System.out.println(game.getScore());
		}
		x-=(int)speed;
	}

	public Rectangle getFrame()
	{
		return new Rectangle(x,537-height,15,height);
	}

	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fill(new Rectangle(x,537-height,15,height));
	}
}