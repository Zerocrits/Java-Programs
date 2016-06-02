import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RunningManGUI extends JFrame
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 600;

	private JLabel lblTitle, lblDice;
	private ImageIcon icoDice;
	private JButton anything;
	private ButtonListener listener;

	public RunningManGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());




		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		RunningManGUI gui = new RunningManGUI();
	}

	// private inner class for handling button events
    // action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
			// find out what object was pressed:
			Object source = new Object();
			source = event.getSource();

			if(source == null)
			{

			}
		}
	}
}