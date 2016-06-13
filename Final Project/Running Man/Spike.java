import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Spike
{
	private int dy;
	private int y;
	private int x;
    private Image image;
    public Spike()
    {
        initSpike();
    }

    private void initSpike()
    {
        ImageIcon imgPlayer = new ImageIcon("Wall.PNG");
        image = imgPlayer.getImage();
        x = 948;
        y = 490;
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
}