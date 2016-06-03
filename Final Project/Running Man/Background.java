import java.awt.*;
import javax.swing.*;

public class Background extends JComponent
{
    Image image;

    public Background(Image image)
    {
		setLayout(null);
        this.image = image;
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        repaint();
    }
}