import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.border.*;

public class Monopoly extends JApplet
{
	//Setting the menu, players, dice, and cards
	Menu menu = new Menu();
	BuildPanel bp;
	ArrayList<Place> place = new ArrayList<Place>();
	Dice dice = new Dice();
	Player p1;
	Player p2;
	ArrayList<String> chest = new ArrayList<String>();
	ArrayList<String> chance = new ArrayList<String>();

	//ending a turn

	JButton btnEnd = new JButton("       End Your Turn       ");

	Player player1;
	Player player2;
	boolean hasRolled = false;

	//scroll log is messages to the active player

	//east panel
	JPanel east = new JPanel();
	JTextArea log = new JTextArea(60, 20);
	JScrollPane jspLog = new JScrollPane(log);

	//south panel
	JPanel south = new JPanel();
	JPanel playerMessage = new JPanel();
	JLabel message = new JLabel("Welcommande to Monopoly!", JLabel.CENTER);
	JPanel command = new JPanel();
	MiniMap map = new MiniMap();

	//commandmands
	private JButton btnBuy = new JButton("Buy");
	private JButton btnSell = new JButton("Sell");
	private JButton btnShow = new JButton("Show");
	private JButton btnRoll = new JButton("Roll");

	//sellList
	DefaultListModel model = new DefaultListModel();
	JList proplist = new JList(model);
	JScrollPane sp = new JScrollPane(proplist);
	private JButton okSell = new JButton("Sell Now?");

	//top
	JPanel north = new JPanel();
	JLabel money = new JLabel("Cash: 0", JLabel.CENTER);
	JLabel turn = new JLabel("Round: 1", JLabel.CENTER);
	int numRound = 1;
	private int maxRound = 10;

	//images
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;

	//*The jail pops up in the north panel whe a player is in jail

	//Jail
	private JButton pay = new JButton("Pay Fine");
	private JButton btnFJC = new JButton("Use Jail Card");


	public void init()
	{
		setLayout(new BorderLayout());

		//load images
		Image build = getImage(getDocumentBase(), "Map.PNG");

		try
		{
			URL url1 = new URL(getDocumentBase(), "laptop.PNG");
			URL url2 = new URL(getDocumentBase(), "mouse.PNG");
			URL url3 = new URL(getDocumentBase(), "question.PNG");
			URL url4 = new URL(getDocumentBase(), "Treasure.PNG");
			img1 = ImageIO.read(url1);
			img2 = ImageIO.read(url2);
			img3 = ImageIO.read(url3);
			img4 = ImageIO.read(url4);
		} catch (IOException e) {}

		bp = new BuildPanel(build);


		//initiate bricks, cards etc...
		addChestCards();
		addChanceCards();
		placeera(); //check

		for(Place p : place)
			bp.add(p);

		dice.addMouseListener(dt); //display thread
		setSize(720,500);
		bp.add(dice);

		//East panel
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setOpaque(true);
		east.setBackground(new Color(178,247,178));
		east.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));

		east.add(jspLog); //scroll panel
		east.add(btnEnd);

		//*The message label shows messages from Chance or Community Chest cards, or when game is over

		//messages
		message.setFont(new Font("Britannic Bold", Font.BOLD, 12));
		message.setPreferredSize(new Dimension(250,100));
		message.setForeground(Color.black);

		//p.Mess
		playerMessage.setOpaque(true);
		playerMessage.setBackground(new Color(178,247,178));
		playerMessage.setLayout(new BoxLayout(playerMessage, BoxLayout.X_AXIS));
		playerMessage.add(message);

		//Commands
		command.setLayout(new GridLayout(2,3,2,2));
		command.setOpaque(true);
		command.setBackground(new Color(50,126,52));
		command.setPreferredSize(new Dimension(100,60));
		command.add(btnBuy);
		command.add(btnSell);
		command.add(btnShow);
		command.add(btnRoll);
		btnBuy.setEnabled(false);

		//South panel
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.setOpaque(true);
		south.setBackground(new Color(178,247,178));
		south.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		south.add(map);
		south.add(Box.createRigidArea(new Dimension(20,1)));
		south.add(playerMessage);
		south.add(command);
		south.add(Box.createHorizontalGlue());

		//Top
		north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
		north.setOpaque(true);
		north.setBackground(new Color(178,247,178));
		north.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		north.add(Box.createRigidArea(new Dimension(120, 1)));
		north.add(money);
		north.add(Box.createRigidArea(new Dimension(100, 1)));
		north.add(turn);

		//add the menu at the beginning
		add(menu);

		//add button and dice listener
		btnEnd.addActionListener(endList);
		btnBuy.addActionListener(buyList);
		btnSell.addActionListener(sellList);
		btnShow.addActionListener(showList);
		okSell.addActionListener(SellOK);
		btnRoll.addActionListener(diceList);
		pay.addActionListener(paytoJail);
		btnFJC.addActionListener(freeOutOfJail);
		log.setEditable(false);

	}
	//method for setting up the game after the start button has been pressed
	public void startTheGame(int limit, String na1, String na2)
	{
		remove(menu);
		maxRound = limit;
		add(bp, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		p1 = new Player(na1, 1000, img1);
		p2 = new Player(na2, 1000, img2);
		player1 = p1;
		player2 = p2;
		addSpelare();
		log.append(player1.getName() +"'s turn\n");
		validate();
		repaint();
		money.setText("Cash: 1000");
	}


	//add the players
	public void addSpelare()
	{
		//spelare.add(p));
		place.get(0).insert(p1);
		place.get(0).insert(p2);
	}

	//add Chest cards
	public void addChestCards()
	{
		chest.add(new String("Penalty"));
		chest.add(new String("Fined"));
		chest.add(new String("Pay"));
	}

	//add Chance cards
	public void addChanceCards()
	{
		chance.add(new String("Birthday"));
		chance.add(new String("Jail"));
		chance.add(new String("Repair"));
	}

	/**
	*This is a game about buying rooms at DSV. It can be a teacher, some students, or
	*two head scinners rivaling each other for power in the School
	*/
	//add all the bricks on the playlog
	public void placeera()
	{
		//down
		place.add(new Corner(1, 300, 300, "down", "GO!"));
		place.add(new Street(2, 260, 300, "down", "506", 80, new Color(94, 60, 49)));
		place.add(new CardPlace(3, 220, 300, "down", "treasure", img4));
		place.add(new Street(4, 180, 300, "down", "507", 100, new Color(94, 60, 49)));
		place.add(new Street(5, 140, 300, "down", "Sal C", 200, Color.white));
		place.add(new ResourcePlace(6, 100, 300, "down", "Kårbibliotek", 200));
		place.add(new CardPlace(7, 60, 300, "down", "question", img3));
		place.add(new Corner(8, 0, 300, "down", "JAIL"));
		//left
		place.add(new Street(9, 0, 260, "left", "510", 120, new Color(233, 63, 174)));
		place.add(new Street(10, 0, 220, "left", "501", 140, new Color(233, 63, 174)));
		place.add(new Street(11, 0, 180, "left", "Sal B", 200, Color.white));
		place.add(new Street(12, 0, 140, "left", "502", 140, new Color(233, 63, 174)));
		place.add(new Street(13, 0, 100, "left", "401", 180, new Color(233, 63, 174)));
		place.add(new CardPlace(14, 0, 60, "left", "treasure", img4));
		//top
		place.add(new Corner(15, 0, 0, "up", "PARKING"));
		place.add(new Street(16, 60, 0, "up", "503", 220, Color.red));
		place.add(new CardPlace(17, 100, 0, "up", "question", img3));
		place.add(new Street(18, 140, 0, "up", "Sal A", 200, Color.white));
		place.add(new Street(19, 180, 0, "up", "504", 240, Color.red));
		place.add(new ResourcePlace(20, 220, 0, "up", "Disks café", 300));
		place.add(new Street(21, 260, 0, "up", "505", 320, Color.red));
		place.add(new Corner(22, 300, 0, "up", "GOTOJAIL"));
		//right
		place.add(new ResourcePlace(23, 300, 60, "right", "Retaurang", 300));
		place.add(new CardPlace(24, 300, 100, "right", "treasure", img4));
		place.add(new Street(25, 300, 140, "right", "Sal D", 200, Color.white));
		place.add(new CardPlace(26, 300, 180, "right", "question", img3));
		place.add(new Street(27, 300, 220, "right", "Nätverksrum", 450, new Color(21, 39, 168)));
		place.add(new Street(28, 300, 260, "right", "Foo bar", 500, new Color(21, 39, 168)));
	}

	//Roll the dice


	//listener to the dice
	Action diceList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(hasRolled)
			{
				log.append("You have already thrown the dice\n");
				return;
			}
			Random rand = new Random();
			int slump = rand.nextInt(6)+1;
			if(player1.isinJail)
			{
				if(slump==6)
				{
					player1.isinJail = false;
					log.append("You Were Released From Jail!\n");
					north.remove(pay); //paid fine
					north.remove(btnFJC); //use free jail card
				}
				else
					log.append("You Rolled Less Than 6!\n");

				dice.setAmount(slump);
				hasRolled=true;
				btnBuy.setEnabled(false);
				btnRoll.setEnabled(false);
				btnEnd.setEnabled(true);
				return;
			}
			for(Place p : place)
			{
				if(p.finns(player1))
					p.taBort(player1);
			}
			player1.setPlan(slump);
			for(Place p : place)
			{
				if(p.getNr() == player1.getPlan())
					p.insert(player1);
			}
			dice.setAmount(slump);
			hasRolled=true;
			log.append(player1.getName()+"'s rolled a "+dice.getAmount()+"\n");
			runPlaceEvents();
			btnBuy.setEnabled(true);
			btnRoll.setEnabled(false);
			btnEnd.setEnabled(true);
		}
	};

	//what happens after a player has thrown the dice
	public void runPlaceEvents()
	{
		Place pl = place.get(player1.getPlan()-1);
		javax.swing.Timer tim;
		if(pl instanceof Street || pl instanceof ResourcePlace)
		{
			message.setText("Room: "+pl.getName());
			message.setForeground(pl.getCol());
		}

		else if(pl.getName().equals("JAIL"))
			log.append("Just visiting the Jail\n");

		else if(pl.getName().equals("GOTOJAIL"))
		{
			log.append("You were sent to Jail!!!");
			btnEnd.setEnabled(false);
			tim = new javax.swing.Timer(2000, goinJail);
			tim.setRepeats(false);
			tim.start();
		}

		if(player2.propExists(pl))
		{
			int pen = pl.getCost()/2; //penalty
			log.append("You are standing in one of\n "+player2.getName() +" rooms! You must pay " + pen + "!\n");
			player1.setMoney(-(pen));
			player2.setMoney(pen);
			money.setText("Cash: "+player1.getMoney());
		}

		else if(pl.getName().equals("PARKING"))
			log.append("Just parking free\n");

		else if(pl instanceof CardPlace)
		{
			btnEnd.setEnabled(false);
			if(pl.getName().equals("treasure"))
			{
				tim = new javax.swing.Timer(2000, drawChest);
				tim.setRepeats(false);
				log.append("Drawing Chest card...\n");
				tim.start();
			}
			else if(pl.getName().equals("question"))
			{
				tim = new javax.swing.Timer(2000, drawChance);
				tim.setRepeats(false);
				log.append("Drawing Chance card...\n");
				tim.start();
			}
		}
		if(pl.getName().equals("GO!") || player1.hasRounded())
		{
			player1.setMoney(200);
			money.setText("Cash: "+player1.getMoney());
			log.append(player1.getName()+" has passed GO\n and collects $200!\n");
		}
	}

	//Player goes to jail
	Action goinJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			for(Place p : place)
			{
				if(p.finns(player1))
					p.taBort(player1);
			}
			place.get(7).insert(player1);
			player1.isinJail = true;
			player1.setDirectPosition(8);
			btnEnd.setEnabled(true);
			btnBuy.setEnabled(false);
			btnRoll.setEnabled(false);
		}
	};

	//*In Monopoly, there are three ways of getting out. Roll a six on the dice, pay the bank 200 or use a "Free Jail" card

	//Player pays to get out of jail
	Action paytoJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.setMoney(-200);
			money.setText("Cash: " + player1.getMoney());
			player1.isinJail = false;
			log.append("You are free now!\n");
			north.remove(pay);
			north.remove(btnFJC);
			btnRoll.setEnabled(false);
			hasRolled = true;
		}
	};

	//player use a "Free out of Jail" card
	Action freeOutOfJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.isinJail = false;
			player1.haveJC = false;
			log.append("You are free now!\n");
			north.remove(pay);
			north.remove(btnFJC);
			btnRoll.setEnabled(false);
			hasRolled = true;
		}
	};

	//Randomly draw a Community Chest Card
	Action drawChest = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			message.setForeground(Color.red);
			log.append("...drawn!\n");
			Random rand = new Random();
			int i = rand.nextInt(3);
			String kort = chest.get(i);

			if(kort.equals("PENALTY"))
			{
				message.setText("Penalty! You must pay $80!");
				player1.setMoney(-80);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			else if(kort.equals("FINED"))
			{
				message.setText("Tax cheat! You must pay 100!");
				player1.setMoney(-100);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			else if(kort.equals("PAY"))
			{
				message.setText("Incommande tax refund. 200 collected!");
				player1.setMoney(200);
				money.setText("Cash: " + String.valueOf(player1.getMoney()));
			}
			btnEnd.setEnabled(true);
		}
	};

	//Randomly draw a Chance card
	Action drawChance = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			message.setForeground(Color.red);
			log.append("...drawn!\n");
			Random rand = new Random();
			int i = rand.nextInt(3);
			String kort = chance.get(i);

			if(kort.equals("BIRTHDAY"))
			{
				message.setText("It's your birthday today!\n");
				player1.setMoney(20);
				player2.setMoney(-20);
				money.setText("Cash: "+String.valueOf(player1.getMoney()));
			}
			else if(kort.equals("JAIL"))
			{
				message.setText("You have a Free Jail card!\n");
				player1.haveJC = true;
			}
			else if(kort.equals("REPAIR"))
			{
				message.setText("Make repairs on all of your rooms!\n");
				ArrayList<Place> nyL = player1.getProps();
				int cash = 0;
				for(Place p : nyL)
					cash+=10;
				player1.setMoney(-(cash));
				money.setText("Cash: "+String.valueOf(player1.getMoney()));
			}
			btnEnd.setEnabled(true);
		}
	};

	//list all the rooms a player own
	Action showList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			playerMessage.removeAll();
			playerMessage.add(message);
			message.setText("REPORT");
			message.setForeground(Color.black);
			ArrayList<Place> nyL = player1.getProps();
			log.append("---------------Cards Owned---------------\n\n");
			for(Place p : nyL)
			{
				log.append("-----------------------------------------\n");
				log.append("  Room : "+p.getName()+"\n  Cost: " + p.getCost()+"\n  Sell cost: "+(p.getCost()/2)+"\n");
			}
		}
	};

	//Listener to the sell button commandmand
	Action sellList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			playerMessage.removeAll();
			playerMessage.add(sp);
			playerMessage.add(okSell);
			sp.setPreferredSize(new Dimension(100,100));
			model.clear();
			ArrayList<Place> nyL = player1.getProps();
			for(Place p : nyL)
			{
				model.addElement(p);
			}
		}
	};

	//listener to the sell button
	Action SellOK = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			Place p =(Place) proplist.getSelectedValue();
			if(p == null)
				return;
			log.append("Room " + p.getName() + " sold to the Bank\n");
			player1.sellProp(p);
			model.removeElement(p);
			player1.setMoney((p.getCost() /2));
			money.setText("Cash: " + player1.getMoney());
			p.setBordColor(Color.black);
			map.setColorOnBrick(p.getNr(), Color.white);
		}
	};

	/**
	*When a player has ended a turn, players swap between "player1" and "player2"
	*/

	//listener to the "End turn" button
	Action endList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!hasRolled)
			{
				log.append("You have not thrown the dice!\n");
				return;
			}
			playerMessage.removeAll();
			playerMessage.add(message);
			message.setText("Let's Create a Monopoly!");
			message.setForeground(Color.black);
			if(player1 == p1)
			{
				player1 = p2;
				player2 = p1;
			}
			else if(player1 == p2)
			{
				player1 = p1;
				player2 = p2;
				turn.setText("Round:: " + String.valueOf(++numRound));

			}
			if(numRound == maxRound)
			{
				log.setText("Round: Limit Reached!");
				if(player1.getMoney()>player2.getMoney())
					message.setText(player1.getName()+" Won the Game!!!");
				else if(player2.getMoney()>player1.getMoney())
					message.setText(player2.getName()+" Won the Game!!!");
				else
					message.setText("Game Tied...!");
				disableAll();
				return;
			}
			hasRolled = false;
			log.setText(player1.getName() + "'s turn\n");
			int cash = player1.getMoney()+player1.getIncommande();
			player1.setMoney(player1.getIncommande());
			money.setText("Cash: " + String.valueOf(cash));

			if(player1.isinJail)
			{
				log.append("You must roll a 6\n or pay $200 to get out!\n");
				if(player1.getMoney() >= 200)
					north.add(pay);
				if(player1.haveJC)
					north.add(btnFJC);
			}
			else
			{
				north.remove(btnFJC);
				north.remove(pay);
			}

			btnBuy.setEnabled(false);
			btnRoll.setEnabled(true);
		}
	};

	//Listener to the "Buy" button
	Action buyList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			Place p = place.get(player1.getPlan()-1);
			playerMessage.removeAll();
			playerMessage.add(message);
			if(player1.propExists(p))
			{
				log.append("You already own " + p.getName()+"!\n");
				return;
			}
			else if(p instanceof Corner || p instanceof CardPlace)
			{
				log.append("You cannot buy that!\n");
				return;
			}
			else if(player2.propExists(p))
			{
				log.append(p.getName()+" is already ownd by "+player2.getName()+"!\n");
				return;
			}
			else if(player1.getMoney() < p.getCost())
			{
				log.append("Insufficient amount of money!\n");
				return;
			}
			message.setForeground(p.getCol());
			message.setText(p.getName());
			player1.buyProp(p);
			if(player1 == p1)
			{
				p.setBordColor(Color.blue);
				map.setColorOnBrick(p.getNr(), Color.blue);
			}
			else if(player1 == p2)
			{
				p.setBordColor(Color.red);
				map.setColorOnBrick(p.getNr(), Color.red);
			}

			player1.setMoney(-(p.getCost()));
			money.setText("Cash: " + String.valueOf(player1.getMoney()));
			log.append(player1.getName() + "'s has bought "+p.getName()+"\n");
			btnBuy.setEnabled(false);
		}
	};

	//MouseListener to the dice
	MouseListener dt = new MouseAdapter()
	{
		public void mouseClicked(MouseEvent e)
		{
			if(hasRolled)
			{
				log.append("You have already thrown the dice!\n");
				return;
			}
			btnEnd.setEnabled(false);
			javax.swing.Timer tid = new javax.swing.Timer(2000, diceList);
			log.append(player1.getName()+" is throwing the dice\n");
			tid.setRepeats(false);
			tid.start();
		}
	};

	//method disabling all the buttons after the end of the game
	public void disableAll()
	{
		btnBuy.setEnabled(false);
		btnSell.setEnabled(false);
		btnShow.setEnabled(false);
		btnRoll.setEnabled(false);
		remove(pay);
		remove(btnFJC);
		btnEnd.setEnabled(false);
		dice.removeMouseListener(dt);
	}

	//the menu class
	class Menu extends JPanel
	{
		private JLabel title = new JLabel("Monopoly", JLabel.CENTER);
		private JPanel menu = new JPanel();
		private JLabel startText = new JLabel("Start new game", JLabel.CENTER);

		//Start a game
		private JPanel game = new JPanel();
		private JTextField name1 = new JTextField(15);
		private JTextField name2 = new JTextField(15);
		private String[] limits = {"100","75","50", "25"};
		private JComboBox box = new JComboBox(limits);
		private JLabel start = new JLabel("Start Game", JLabel.CENTER);
		private JLabel back = new JLabel("Back", JLabel.CENTER);

		public Menu()
		{
			setLayout(new GridLayout(2,1,10,10));
			setOpaque(true);
			setBackground(new Color(178,247,178));
			title.setFont(new Font("Arial Black", Font.BOLD, 60));
			startText.setFont(new Font("Arial Black", Font.BOLD, 18));
			title.setForeground(Color.white);
			title.setOpaque(true);
			title.setBackground(Color.red);
			title.setBorder(new MatteBorder(5,5,5,5,Color.white));
			add(title);

			menu.setLayout(new GridLayout(2,1,60,10));
			menu.setOpaque(true);
			menu.setBackground(new Color(178,247,178));
			menu.add(startText);
			add(menu);

			game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
			game.setOpaque(true);
			game.setBackground(new Color(178,247,178));
			name1.setFont(new Font("Serif", Font.BOLD, 23));
			name2.setFont(new Font("Serif", Font.BOLD, 23));
			name1.setMinimumSize(name1.getPreferredSize());
			name2.setMinimumSize(name2.getPreferredSize());
			box.setPreferredSize(new Dimension(100,20));
			game.add(new JLabel("Player 1", JLabel.CENTER));
			game.add(name1);
			game.add(new JLabel("Player 2", JLabel.CENTER));
			game.add(name2);
			game.add(new JLabel("Choose turn limit"));
			game.add(box);
			game.add(start);
			game.add(back);
			startText.addMouseListener(ml);
			back.addMouseListener(ml);
			start.addMouseListener(ml);
		}

		MouseListener ml = new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				JLabel l = (JLabel)e.getSource();
				l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				l.setForeground(Color.red);
			}

			public void mouseExited(MouseEvent e)
			{
				JLabel l = (JLabel)e.getSource();
				l.setForeground(Color.black);
			}
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == startText)
				{
					remove(menu);
					add(game);
					validate();
					repaint();
					startText.setForeground(Color.black);
				}
				else if(e.getSource() == back)
				{
					remove(game);
					add(menu);
					validate();
					repaint();
					back.setForeground(Color.black);
				}
				else if(e.getSource() == start)
				{
					String pNamn1 = name1.getText();
					String pNamn2 = name2.getText();
					String si = (String)box.getSelectedItem();
					int i = Integer.parseInt(si);
					startTheGame(i, pNamn1, pNamn2);
				}
			}
		};
	}
}

//When to use a semicolan after a curley brace: http://stackoverflow.command/questions/2717949/when-should-i-use-a-semicolon-after-curly-braces








