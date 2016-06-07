import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunningManGUI extends JFrame
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 600;

	private JFrame frmPlayer;
	private Player player;

	public RunningManGUI()
	{
		//add(new Board());

		setResizable(false);
		pack();

		setTitle("Running Man");
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





		//JFrame f = new JFrame("Running Man");
		//f.setLayout(new FlowLayout());
		//try {
		//	f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Background.PNG")))));
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		//f.add(new JLabel(new ImageIcon("Character.PNG")));



		//f.setSize(APPLET_WIDTH, APPLET_HEIGHT);
		//f.pack();
    	//f.setVisible(true);
	}

	public static void main(String[] args)
	{
		RunningManGUI gui = new RunningManGUI();

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame game = new RunningManGUI();
				game.setVisible(true);
			}
		});
    }
}