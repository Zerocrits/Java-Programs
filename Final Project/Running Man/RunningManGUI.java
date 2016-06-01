import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RunningManGUI extends JFrame
{
	private int APPLET_WIDTH = 300, APPLET_HEIGHT = 470;

	private JLabel lblTitle, lblDice;
	private ImageIcon icoDice;
	private JButton anything;
	private ButtonListener listener;

	public RunningManGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());



		btnPull = new JButton ("     Pull Me!     ");
		btnPull.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnPull.addActionListener( new ButtonListener());



		icoDice = new ImageIcon("lblDice.PNG");



		lblDice = new JLabel();



		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));



		listener = new ButtonListener();



		lblDice.setIcon(icoDice);



		cp.add(lblTitle);


		lblBlank.setText("                     ");


		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		RunningManGUI gui = new SlotGUI();
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

			if(source == btnPull)
			{

			}
		}
	}
}