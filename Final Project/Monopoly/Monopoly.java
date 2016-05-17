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
	//Setting the menu, players, die, and cards
	Menu menu = new Menu();
	BuildPanel bp;
	ArrayList<Place> place = new ArrayList<Place>();
	Dice die = new Dice();
	Player p1;
	Player p2;
	ArrayList<String> chest = new ArrayList<String>();
	ArrayList<String> chance = new ArrayList<String>();

	//ending a turn
	JButton endTB = new JButton("END TURN");
	Player waitP1;
	Player waitP2;
	boolean diceThrown = false;

	//*The field is for messages to the active player.

	//east
	JPanel east = new JPanel();
	JTextArea field = new JTextArea(60, 20);
	JScrollPane jsp = new JScrollPane(field);

	//south
	JPanel south = new JPanel();
	JPanel pMess = new JPanel();
	JLabel message = new JLabel("Welcome to Monopoly!", JLabel.CENTER);
	JPanel com = new JPanel(); //check
	MiniMap map = new MiniMap();

	//commands
	private JButton buyB = new JButton("Buy");
	private JButton sellB = new JButton("Sell");
	private JButton showB = new JButton("Show");
	private JButton throwB = new JButton("Throw");

	//sellList
	DefaultListModel model = new DefaultListModel();
	JList proplist = new JList(model);
	JScrollPane sp = new JScrollPane(proplist);
	private JButton okSell = new JButton("Sell It");

	//top
	JPanel north = new JPanel();
	JLabel money = new JLabel("Money: 0", JLabel.CENTER);
	JLabel turn = new JLabel("Turn 1", JLabel.CENTER);
	int turnNm = 1;
	private int turnLimit = 10;

	//images
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;

	//*The jail pops up in the north panel whe a player is in jail

	//Jail
	private JButton pay = new JButton("Pay Fine");
	private JButton useFJC = new JButton("Use Jail Card");


	public void init()
	{
		setLayout(new BorderLayout());

		//load images
		Image build = getImage(getDocumentBase(), "Map.jpg");

		try
		{
			URL url1 = new URL(getDocumentBase(), "laptop.gif");
			URL url2 = new URL(getDocumentBase(), "mouse.gif");
			URL url3 = new URL(getDocumentBase(), "question.jpg");
			URL url4 = new URL(getDocumentBase(), "Treasure.jpg");
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

		die.addMouseListener(dt); //display thread
		setSize(720,500);
		bp.add(die);

		//East panel
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setOpaque(true);
		east.setBackground(new Color(178,247,178));
		east.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));

		east.add(endTB);
		east.add(jsp); //scroll panel

		//*The message label shows messages from Chance or Community Chest cards, or when game is over

		//messages
		message.setFont(new Font("Britannic Bold", Font.BOLD, 12));
		message.setPreferredSize(new Dimension(250,100));
		message.setForeground(Color.black);

		//p.Mess
		pMess.setOpaque(true);
		pMess.setBackground(new Color(178,247,178));
		pMess.setLayout(new BoxLayout(pMess, BoxLayout.X_AXIS));
		pMess.add(message);

		//Commands
		com.setLayout(new GridLayout(2,3,2,2));
		com.setOpaque(true);
		com.setBackground(new Color(50,126,52));
		com.setPreferredSize(new Dimension(100,60));
		com.add(buyB);
		com.add(sellB);
		com.add(showB);
		com.add(throwB);
		buyB.setEnabled(false);

		//South panel
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.setOpaque(true);
		south.setBackground(new Color(178,247,178));
		south.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		south.add(map);
		south.add(Box.createRigidArea(new Dimension(20,1)));
		south.add(pMess);
		south.add(com);
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

		//add button and die listener
		endTB.addActionListener(endList);
		buyB.addActionListener(buyList);
		sellB.addActionListener(sellList);
		showB.addActionListener(showList);
		okSell.addActionListener(SellOK);
		throwB.addActionListener(dieList);
		pay.addActionListener(paytoJail);
		useFJC.addActionListener(freeOutOfJail);
		field.setEditable(false);

	}
	//method for setting up the game after the start button has been pressed
	public void startTheGame(int limit, String na1, String na2)
	{
		remove(menu);
		turnLimit = limit;
		add(bp, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		p1 = new Player(na1, 1000, img1);
		p2 = new Player(na2, 1000, img2);
		waitP1 = p1;
		waitP2 = p2;
		addSpelare();
		field.append(waitP1.getName() +"'s turn\n");
		validate();
		repaint();
		money.setText("Money: 1000");
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
	//add all the bricks on the playfield
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

	/**
	*Throw the die too move the token or try to get out of jail
	*/
	//listener to the die
	Action dieList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(diceThrown)
			{
				field.append("You have already thrown the dice\n");
				return;
			}
			Random rand = new Random();
			int slump = rand.nextInt(6)+1;
			if(waitP1.isinJail)
			{
				if(slump==6)
				{
					waitP1.isinJail = false;
					field.append("You Were Released From Jail!\n");
					north.remove(pay); //paid fine
					north.remove(useFJC); //use free jail card
				}
				else
					field.append("You Rolled Less Than 6!\n");

				die.setAmount(slump);
				diceThrown=true;
				buyB.setEnabled(false);
				throwB.setEnabled(false);
				endTB.setEnabled(true);
				return;
			}
			for(Place p : place)
			{
				if(p.finns(waitP1))
					p.taBort(waitP1);
			}
			waitP1.setPlan(slump);
			for(Place p : place)
			{
				if(p.getNr() == waitP1.getPlan())
					p.insert(waitP1);
			}
			die.setAmount(slump);
			diceThrown=true;
			field.append(waitP1.getName()+"'s die number is "+die.getAmount()+"\n");
			runPlaceEvents();
			buyB.setEnabled(true);
			throwB.setEnabled(false);
			endTB.setEnabled(true);
		}
	};

	//what happens after a player has thrown the die
	public void runPlaceEvents()
	{
		Place pl = place.get(waitP1.getPlan()-1);
		javax.swing.Timer tim;
		if(pl instanceof Street || pl instanceof ResourcePlace)
		{
			message.setText("Room: "+pl.getName());
			message.setForeground(pl.getCol());
		}

		else if(pl.getName().equals("JAIL"))
			field.append("Just visiting the Jail\n");

		else if(pl.getName().equals("GOTOJAIL"))
		{
			field.append("You were sent to Jail!!!");
			endTB.setEnabled(false);
			tim = new javax.swing.Timer(2000, goinJail);
			tim.setRepeats(false);
			tim.start();
		}

		if(waitP2.propExists(pl))
		{
			int pen = pl.getCost()/2; //penalty
			field.append("You are standing in one of\n "+waitP2.getName() +" rooms! You must pay " + pen + "!\n");
			waitP1.setMoney(-(pen));
			waitP2.setMoney(pen);
			money.setText("Money: "+waitP1.getMoney());
		}

		else if(pl.getName().equals("PARKING"))
			field.append("Just parking free\n");

		else if(pl instanceof CardPlace)
		{
			endTB.setEnabled(false);
			if(pl.getName().equals("treasure"))
			{
				tim = new javax.swing.Timer(2000, drawChest);
				tim.setRepeats(false);
				field.append("Drawing Chest card...\n");
				tim.start();
			}
			else if(pl.getName().equals("question"))
			{
				tim = new javax.swing.Timer(2000, drawChance);
				tim.setRepeats(false);
				field.append("Drawing Chance card...\n");
				tim.start();
			}
		}
		if(pl.getName().equals("GO!") || waitP1.hasRounded())
		{
			waitP1.setMoney(200);
			money.setText("Money: "+waitP1.getMoney());
			field.append(waitP1.getName()+" has passed GO\n and collects $200!\n");
		}
	}

	//Player goes to jail
	Action goinJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			for(Place p : place)
			{
				if(p.finns(waitP1))
					p.taBort(waitP1);
			}
			place.get(7).insert(waitP1);
			waitP1.isinJail = true;
			waitP1.setDirectPosition(8);
			endTB.setEnabled(true);
			buyB.setEnabled(false);
			throwB.setEnabled(false);
		}
	};

	//*In Monopoly, there are three ways of getting out. Throw a six on the die, pay the bank 200 or use a "Free Jail" card

	//Player pays to get out of jail
	Action paytoJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			waitP1.setMoney(-200);
			money.setText("Money: " + waitP1.getMoney());
			waitP1.isinJail = false;
			field.append("You are now free!\n");
			north.remove(pay);
			north.remove(useFJC);
			throwB.setEnabled(false);
			diceThrown = true;
		}
	};

	//player use a "Free out of Jail" card
	Action freeOutOfJail = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			waitP1.isinJail = false;
			waitP1.haveJC = false;
			field.append("You are free now!\n");
			north.remove(pay);
			north.remove(useFJC);
			throwB.setEnabled(false);
			diceThrown = true;
		}
	};

	//Randomly draw a Community Chest Card
	Action drawChest = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			message.setForeground(Color.red);
			field.append("...drawn!\n");
			Random rand = new Random();
			int i = rand.nextInt(3);
			String kort = chest.get(i);

			if(kort.equals("PENALTY"))
			{
				message.setText("Penalty! You must pay $80!");
				waitP1.setMoney(-80);
				money.setText("Money: " + String.valueOf(waitP1.getMoney()));
			}
			else if(kort.equals("FINED"))
			{
				message.setText("Tax cheat! You must pay 100!");
				waitP1.setMoney(-100);
				money.setText("Money: " + String.valueOf(waitP1.getMoney()));
			}
			else if(kort.equals("PAY"))
			{
				message.setText("Income tax refund. 200 collected!");
				waitP1.setMoney(200);
				money.setText("Money: " + String.valueOf(waitP1.getMoney()));
			}
			endTB.setEnabled(true);
		}
	};

	//Randomly draw a Chance card
	Action drawChance = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			message.setForeground(Color.red);
			field.append("...drawn!\n");
			Random rand = new Random();
			int i = rand.nextInt(3);
			String kort = chance.get(i);

			if(kort.equals("BIRTHDAY"))
			{
				message.setText("It's your birthday today!\n");
				waitP1.setMoney(20);
				waitP2.setMoney(-20);
				money.setText("Money: "+String.valueOf(waitP1.getMoney()));
			}
			else if(kort.equals("JAIL"))
			{
				message.setText("You have a Free Jail card!\n");
				waitP1.haveJC = true;
			}
			else if(kort.equals("REPAIR"))
			{
				message.setText("Make repairs on all of your rooms!\n");
				ArrayList<Place> nyL = waitP1.getProps();
				int cash = 0;
				for(Place p : nyL)
					cash+=10;
				waitP1.setMoney(-(cash));
				money.setText("Money: "+String.valueOf(waitP1.getMoney()));
			}
			endTB.setEnabled(true);
		}
	};

	//list all the rooms a player own
	Action showList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			pMess.removeAll();
			pMess.add(message);
			message.setText("REPORT");
			message.setForeground(Color.black);
			ArrayList<Place> nyL = waitP1.getProps();
			field.append("---------------Cards Owned---------------\n\n");
			for(Place p : nyL)
			{
				field.append("-----------------------------------------\n");
				field.append("  Room : "+p.getName()+"\n  Cost: " + p.getCost()+"\n  Sell cost: "+(p.getCost()/2)+"\n");
			}
		}
	};

	//Listener to the sell button command
	Action sellList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			pMess.removeAll();
			pMess.add(sp);
			pMess.add(okSell);
			sp.setPreferredSize(new Dimension(100,100));
			model.clear();
			ArrayList<Place> nyL = waitP1.getProps();
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
			field.append("Room " + p.getName() + " sold to the Bank\n");
			waitP1.sellProp(p);
			model.removeElement(p);
			waitP1.setMoney((p.getCost() /2));
			money.setText("Money: " + waitP1.getMoney());
			p.setBordColor(Color.black);
			map.setColorOnBrick(p.getNr(), Color.white);
		}
	};

	/**
	*When a player has ended a turn, players swap between "waitP1" and "waitP2"
	*/

	//listener to the "End turn" button
	Action endList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!diceThrown)
			{
				field.append("You have not thrown the die!\n");
				return;
			}
			pMess.removeAll();
			pMess.add(message);
			message.setText("Let's Create a Monopoly!");
			message.setForeground(Color.black);
			if(waitP1 == p1)
			{
				waitP1 = p2;
				waitP2 = p1;
			}
			else if(waitP1 == p2)
			{
				waitP1 = p1;
				waitP2 = p2;
				turn.setText("Turn: " + String.valueOf(++turnNm));

			}
			if(turnNm == turnLimit)
			{
				field.setText("Turn Limit Reached!");
				if(waitP1.getMoney()>waitP2.getMoney())
					message.setText(waitP1.getName()+" Won the Game!!!");
				else if(waitP2.getMoney()>waitP1.getMoney())
					message.setText(waitP2.getName()+" Won the Game!!!");
				else
					message.setText("Game Tied...!");
				disableAll();
				return;
			}
			diceThrown = false;
			field.setText(waitP1.getName() + "'s turn\n");
			int cash = waitP1.getMoney()+waitP1.getIncome();
			waitP1.setMoney(waitP1.getIncome());
			money.setText("Money: " + String.valueOf(cash));

			if(waitP1.isinJail)
			{
				field.append("You must roll a 6\n or pay $200 to get out!\n");
				if(waitP1.getMoney() >= 200)
					north.add(pay);
				if(waitP1.haveJC)
					north.add(useFJC);
			}
			else
			{
				north.remove(useFJC);
				north.remove(pay);
			}

			buyB.setEnabled(false);
			throwB.setEnabled(true);
		}
	};

	//Listener to the "Buy" button
	Action buyList = new AbstractAction()
	{
		public void actionPerformed(ActionEvent e)
		{
			Place p = place.get(waitP1.getPlan()-1);
			pMess.removeAll();
			pMess.add(message);
			if(waitP1.propExists(p))
			{
				field.append("You already own " + p.getName()+"!\n");
				return;
			}
			else if(p instanceof Corner || p instanceof CardPlace)
			{
				field.append("You cannot buy that!\n");
				return;
			}
			else if(waitP2.propExists(p))
			{
				field.append(p.getName()+" is already ownd by "+waitP2.getName()+"!\n");
				return;
			}
			else if(waitP1.getMoney() < p.getCost())
			{
				field.append("Insufficient amount of money!\n");
				return;
			}
			message.setForeground(p.getCol());
			message.setText(p.getName());
			waitP1.buyProp(p);
			if(waitP1 == p1)
			{
				p.setBordColor(Color.blue);
				map.setColorOnBrick(p.getNr(), Color.blue);
			}
			else if(waitP1 == p2)
			{
				p.setBordColor(Color.red);
				map.setColorOnBrick(p.getNr(), Color.red);
			}

			waitP1.setMoney(-(p.getCost()));
			money.setText("Money: " + String.valueOf(waitP1.getMoney()));
			field.append(waitP1.getName() + "'s has bought "+p.getName()+"\n");
			buyB.setEnabled(false);
		}
	};

	//MouseListener to the die
	MouseListener dt = new MouseAdapter()
	{
		public void mouseClicked(MouseEvent e)
		{
			if(diceThrown)
			{
				field.append("You have already thrown the dice!\n");
				return;
			}
			endTB.setEnabled(false);
			javax.swing.Timer tid = new javax.swing.Timer(2000, dieList);
			field.append(waitP1.getName()+" is throwing the die\n");
			tid.setRepeats(false);
			tid.start();
		}
	};

	//method disabling all the buttons after the end of the game
	public void disableAll()
	{
		buyB.setEnabled(false);
		sellB.setEnabled(false);
		showB.setEnabled(false);
		throwB.setEnabled(false);
		remove(pay);
		remove(useFJC);
		endTB.setEnabled(false);
		die.removeMouseListener(dt);
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

//When to use a semicolan after a curley brace: http://stackoverflow.com/questions/2717949/when-should-i-use-a-semicolon-after-curly-braces








