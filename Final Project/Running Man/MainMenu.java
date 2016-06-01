import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
	private JLabel lblName;
	private JButton btnStart, btnHowto;
	private int APPLET_WIDTH = 500, APPLET_HEIGHT = 200;

	public MainMenu()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new GridLayout(0,1,10,10));

		lblName = new JLabel("Running Man", JLabel.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart = new JButton("Start Game");
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnHowto = new JButton("How To Play");
		btnHowto.setFont(new Font("Comic Sans MS", Font.BOLD, 26));


		cp.add(lblName);
		cp.add(btnHowto);
		cp.add(btnStart);


		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		MainMenu menu = new MainMenu();
	}
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