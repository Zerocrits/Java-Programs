//http://stackoverflow.com/questions/8451793/best-gui-approach-with-java-for-a-monopoly-board-game



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MonopolyGUI extends JFrame
{
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 800;
	private JLabel lblCoins;
	private JLabel lblInfo;
	private ImageIcon icoDice;
	private JButton btnPull;
	private MonopolyClient client;
	private ButtonListener listener;

	public MonopolyGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());
		JPanel north = new JPanel();
		lblInfo = new JLabel("This is north");


   		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(lblInfo, BorderLayout.CENTER);




		setLayout(new BorderLayout());
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("West"), BorderLayout.WEST);
   		//add(new Button("Center"), BorderLayout.CENTER);




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




		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
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