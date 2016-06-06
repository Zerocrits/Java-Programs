import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player
{
    private int xa; //possible powerup
    private int ya;
    private int x;
    private int y;
    private Image image;

    public Player()
    {
        Player();
    }

    public void Player()
    {
        ImageIcon character = new ImageIcon("Character.PNG");
        image = character.getImage();
        x = 40;
        y = 60;
    }


    public void move()
    {
        x += xa;//temp
        y += ya;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
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
    }
}