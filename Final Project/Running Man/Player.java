import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player
{
	private int dy;
	private int y;
	private int x;
    private Image image;
    public Player()
    {
        initPlayer();
    }

    private void initPlayer()
    {
        ImageIcon imgPlayer = new ImageIcon("Character.PNG");
        image = imgPlayer.getImage();
        x = 40;
        y = 60;
    }


    public void move()
    {
        y += dy;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
		return x;
	}

    public Image getImage()
    {
        return image;
    }

    public void keyPressed(KeyEvent e)
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN)
        {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e)
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN)
        {
            dy = 0;
        }
    }
}