import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Background
{
    private Image image;

    public Background()
    {
		initBackground();
    }

    public void initBackground()
    {
		ImageIcon imgBackground = new ImageIcon("Background.PNG");
        image = imgBackground.getImage();
	}

    public Image getImage()
    {
    	return image;
	}

}