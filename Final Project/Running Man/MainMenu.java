import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
	private JLabel lblName,lblTitle;
	private JButton btnStart, btnHowto;
	private JButton btnStart1, btnStart2, btnStart3;
	final int APPLET_WIDTH = 500, APPLET_HEIGHT = 200;
	private ButtonListener listener;
	private ButtonListener listen;
	private Game game;

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

		listener = new ButtonListener();
		btnHowto.addActionListener(listener);
		btnStart.addActionListener(listener);

		Container game = getContentPane();
		game.setBackground(Color.cyan);
		game.setLayout(new GridLayout(0,1,10,10));
		lblTitle = new JLabel("Select a Gamemode!", JLabel.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart1 = new JButton("Insane");
		btnStart1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart2 = new JButton("Hard");
		btnStart2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart3 = new JButton("Easy");
		btnStart3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

		listen = new ButtonListener();



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

			if(source == btnStart)
			{
				//remove(cp);
				cp.add(btnStart1);
			}
			else if(source == btnHowto)
			{
				JOptionPane.showMessageDialog(null, "test");
			}
		}
	}
}