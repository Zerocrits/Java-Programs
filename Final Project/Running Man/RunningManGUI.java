import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RunningManGUI extends JFrame
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 600;

	private JLabel lblTitle, lblDice;
	private BufferedImage icoBackground;
	private JButton anything;
	private ButtonListener listener;

	public RunningManGUI()
	{
		BufferedImage icoBackground = new ImageIcon("Background.PNG");
		Container cp = getContentPane();
		cp.setBackground(icoBackground);
		cp.setLayout(new FlowLayout());




		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		RunningManGUI gui = new RunningManGUI();
	}

	private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
			Object source = new Object();
			source = event.getSource();

			if(source == null)
			{

			}
		}
	}
}