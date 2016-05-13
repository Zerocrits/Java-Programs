//http://stackoverflow.com/questions/8451793/best-gui-approach-with-java-for-a-monopoly-board-game
//https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MonopolyGUI
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 800;
	private JLabel lblCoins;
	private JLabel lblInfo;
	private ImageIcon icoDice;
	private JButton btnPull;
	private MonopolyClient client;
	private ButtonListener listener;

	private JPanel p;
	private JPanel p2;
	private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;

    private BufferedImage image;

	public MonopolyGUI()
	{
		JFrame frame = new JFrame("Testing");

		panel = new JPanel(new BorderLayout());
		p = new JPanel(new BorderLayout());
		JLabel imgLabel = new JLabel(new ImageIcon("test.png"));
		p.add(imgLabel, BorderLayout.WEST);
		imgLabel = new JLabel(new ImageIcon("test.png"));
		p.add(imgLabel, BorderLayout.CENTER);
		imgLabel = new JLabel(new ImageIcon("test.png"));
		p.add(imgLabel, BorderLayout.EAST);
		imgLabel = new JLabel(new ImageIcon("test.png"));

		p2 = new JPanel(new BorderLayout());
		imgLabel = new JLabel(new ImageIcon("test.png"));
		p2.add(imgLabel, BorderLayout.WEST);
		imgLabel = new JLabel(new ImageIcon("test.png"));
		p2.add(imgLabel, BorderLayout.CENTER);
		imgLabel = new JLabel(new ImageIcon("test.png"));
		p2.add(imgLabel, BorderLayout.EAST);
		imgLabel = new JLabel(new ImageIcon("test.png"));

		panel.add(p, BorderLayout.WEST);
		panel.add(p2, BorderLayout.CENTER);
		panel.add(new JButton("tessst"), BorderLayout.EAST);


		panel2 = new JPanel(new BorderLayout());
		panel2.add(new JButton("test2"));
		panel3 = new JPanel(new BorderLayout());
		panel3.add(new JButton("test3"));

		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.add(panel3, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);








		/*panel = new JPanel(new GridLayout(4, 13));
		JLabel imgLabel = new JLabel(new ImageIcon("test.png"));
		panel.add(imgLabel);
		panel.add(new JButton("imgLabel"));
		imgLabel = new JLabel(new ImageIcon("test.png"));
		panel.add(imgLabel);
		panel.add(new JButton("imgLabel"));
		imgLabel = new JLabel(new ImageIcon("test.png"));
		panel.add(imgLabel);
		panel.add(new JButton("imgLabel"));
		imgLabel = new JLabel(new ImageIcon("test.png"));
		panel.add(imgLabel);
		imgLabel = new JLabel(new ImageIcon("test.png"));
		panel.add(imgLabel);

		panel2 = new JPanel(new GridLayout(1, 13, 50, 50));
		panel2.add(new JButton("test2"));

		panel3 = new JPanel();
		panel3.add(new JTextArea(20,20));


		frame.add(panel2, BorderLayout.SOUTH);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel3, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
*/

		/*JPanel northP = new JPanel(new GridLayout(20, 20, 20, 20));
		JPanel eastP = new JPanel();
		JPanel southP = new JPanel();
		JPanel westP = new JPanel();
		JPanel centerP = new JPanel();

		Dimension d = new Dimension(1000, 200);

		northP.setPreferredSize(d);
		southP.setPreferredSize(d);

		d.setSize(200, 800);

		eastP.setPreferredSize(d);
		westP.setPreferredSize(d);

		//Add some buttons and fields to each panel
		JButton button1 = new JButton("Test");
		JTextField field1 = new JTextField(20);
		northP.add(button1);
		eastP.add(button1);
		southP.add(button1);
		westP.add(button1);
		centerP.add(field1);

		Container c = frame.getContentPane();
		c.add(northP,"North");
		c.add(eastP, "East");
		c.add(southP,"South");
        frame.show();


*/



		/*JPanel north = new JPanel();
		lblInfo = new JLabel("This is north");


   		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(lblInfo, BorderLayout.CENTER);




		setLayout(new BorderLayout());
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("West"), BorderLayout.WEST);
   		//add(new Button("Center"), BorderLayout.CENTER);



*/
		/*int boardWidth;
		int boardHeight;
		int boardSquareHeight;
		int boardSqusreWidth;
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		Dimension northSouthD = new Dimension(boardWidth, boardSquareHeight);
		north.setPreferedSize(northSouthD);
		south.setPreferedSize(northSouthD);
		JPanel east = new JPanel();
		JPanel west = new JPanel();
		Dimension eastWestD = new Dimension(boardSquareHeight, boardHeight - 2 * boardSquaareWidth);
		east.setPreferedSize(easWestD);
		west.setPreferedSize(easWestD);
		// add all of the buttons to the appropriate JPanel
		parentPanel.setLayoutManager(new BorderLayout());
		parentPanel.add(north, BorderLayour.NORTH);*/





		/*btnPull = new JButton ("     Pull Me!     ");
		btnPull.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnPull.addActionListener( new ButtonListener());

		icoDice = new ImageIcon("lblDice.PNG");
		Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,2));*/

		//pane.setLayout(GridLayout);
		//pane.add(new JButton("Button 1"));
        //pane.add(new JButton("Button 2"));

		/*slot = new SlotMachine();
		lblDice = new JLabel();
		lblCherry = new JLabel();
		lblSeven = new JLabel();
		lblBar = new JLabel();
		lblBlank1 = new JLabel();
		lblBlank2 = new JLabel();
		lblBlank3 = new JLabel();
		lblTitle = new JLabel("    Slot Machine    ");

		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblCoins = new JLabel("Coins: 0");
		lblCoins.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo1 = new JLabel();
		lblInfo1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo2 = new JLabel();
		lblInfo2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo3 = new JLabel();
		lblInfo3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo4 = new JLabel();
		lblInfo4.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblBlank = new JLabel();
		lblBlank.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		listener = new ButtonListener();

		lblDice.setIcon(icoDice);
		lblCherry.setIcon(icoCherry);
		lblSeven.setIcon(icoSeven);
		lblBar.setIcon(icoBar);
		lblBlank1.setIcon(icoBlank1);
		lblBlank2.setIcon(icoBlank2);
		lblBlank3.setIcon(icoBlank3);

		cp.add(lblTitle);
		cp.add(lblBlank1);
		cp.add(lblBlank2);
		cp.add(lblBlank3);
		cp.add(btnPull);
		cp.add(lblCoins);
		cp.add(lblBlank);
		cp.add(lblInfo1);
		cp.add(lblInfo2);
		cp.add(lblInfo3);
		cp.add(lblInfo4);

		lblBlank.setText("                     ");
		lblInfo1.setText("Bar = $100");
		lblInfo2.setText("Cherry = $500");
		lblInfo3.setText("Dice = $1,000");
		lblInfo4.setText("Seven = $10,000");*/




		//setSize(APPLET_WIDTH, APPLET_HEIGHT);
		//setVisible(true);
	}

	public static void main(String[] args)
	{
		MonopolyGUI gui = new MonopolyGUI();
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
				/*word1 = getDelay();
				word2 = slot.spin2();
				word3 = slot.spin3();
				switch(word1)
				{
					case "Bar": lblBlank1.setIcon(icoBar); break;
					case "Cherry": lblBlank1.setIcon(icoCherry); break;
					case "Dice": lblBlank1.setIcon(icoDice); break;
					case "7": lblBlank1.setIcon(icoSeven); break;
				}
				switch(word2)
				{
					case "Bar": lblBlank2.setIcon(icoBar); break;
					case "Cherry": lblBlank2.setIcon(icoCherry); break;
					case "Dice": lblBlank2.setIcon(icoDice); break;
					case "7": lblBlank2.setIcon(icoSeven); break;
				}
				switch(word3)
				{
					case "Bar": lblBlank3.setIcon(icoBar); break;
					case "Cherry": lblBlank3.setIcon(icoCherry); break;
					case "Dice": lblBlank3.setIcon(icoDice); break;
					case "7": lblBlank3.setIcon(icoSeven); break;
				}
				coins = coins + slot.getPayout();
				lblCoins.setText("Coins: $" + coins);*/
			}//if
		}//actionPerformed()
	}//inner class
}