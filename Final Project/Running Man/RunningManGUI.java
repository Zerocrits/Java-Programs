import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class RunningManGUI extends JFrame
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 600;

	private JFrame frmPlayer;
	private Player player;
	private BufferedImage myImage;

	public RunningManGUI()
	{
		JFrame f = new JFrame("Running Man");
		f.setLayout(new FlowLayout());

		try
		{
    		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Background.PNG")))));

    	} catch (IOException e) {}



		Player characer;
		//myImage = new BufferedImage("Character.PNG");
		//character = new Player(myImage);
		//f.add(super.player());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setSize(APPLET_WIDTH, APPLET_HEIGHT);
		f.pack();
    	f.setVisible(true);
	}

	public static void main(String[] args)
	{
		RunningManGUI gui = new RunningManGUI();
    }
}