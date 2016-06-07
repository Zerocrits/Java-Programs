import java.awt.Image;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;

public class Player
{
    private int ya;
    private int y;

    public Player()
    {
        Player();
    }

    public void Player()
    {
        JLabel lblChar = new JLabel();
        lblChar.setIcon(new ImageIcon("Character.PNG"));
        lblChar.setLocation(100,100);
        y = 60;
    }


    public void move()
    {
        y += ya;
    }

    public int getY()
    {
        return y;
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