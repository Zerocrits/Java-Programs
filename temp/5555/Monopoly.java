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

public class Monopoly extends JApplet {
	/**
	*This class represents the Monopoly game. It only has 2 players, a few
	*Community Chest and Chance cards, but great lots of fun!
	*A menu starts att the beginning, where players can view credits or play the game.
	*Why i only choose two players is because that this game is only suited for
	*human players and it would be hard for 6 players to share one computer.
	*However, the game contains a board field, some command buttons and a bar
	*indicating money and turn.
	*A player has to wait for it's turn while the other player plays it's turn(variables aktuell
	*and waitP).
	*/

	//Setting the menu, players, die, and cards
	Menu menu = new Menu();
	BildPanel bp;
	ArrayList<Place> plats = new ArrayList<Place>();
	Dice die = new Dice();
	Player p1;
	Player p2;
	ArrayList<String> chest = new ArrayList<String>();
	ArrayList<String> chance = new ArrayList<String>();
	
	//ending a turn
	JButton endTB = new JButton("END TURN");
	Player aktuell;
	Player waitP;
	boolean diceThrown = false;
	
	/**
	*The field is for showing messages to the active player. It strives to look and
	*behave like the prompt, but is not editable and cannot put in commands
	*/

	//east
	JPanel east = new JPanel();
	JTextArea field = new JTextArea(60, 20);
	JScrollPane jsp = new JScrollPane(field);

	//south	
	JPanel south = new JPanel();
	JPanel pMess = new JPanel();
	JLabel message = new JLabel("Welcome to Monopoly!", JLabel.CENTER);
	JPanel com = new JPanel();
	MiniMap map = new MiniMap();
		
	//commands
	private JButton buyB = new JButton("BUY");
	private JButton sellB = new JButton("SELL");
	private JButton showB = new JButton("SHOW");
	private JButton throwDB = new JButton("THROW");
	
	//sellList
	DefaultListModel mod = new DefaultListModel();
	JList proplist = new JList(mod);
	JScrollPane sp = new JScrollPane(proplist);
	private JButton okSell = new JButton("SELL IT");
	
	//top
	JPanel north = new JPanel();
	JLabel money = new JLabel("Money: 0", JLabel.CENTER);
	JLabel turn = new JLabel("Turn 1", JLabel.CENTER);
	int turnNr = 1;
	private int turnLimit = 10;
	
	//images
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;
	
	/**
	*The jail funktions here pops up in the north panel when
	*a player is in jail
	*/
	
	//Jail-funktions
	private JButton foojB = new JButton("Pay");
	private JButton useFJC = new JButton("Use FJC");
	
	//Audios
	AudioClip [] ljud = new AudioClip[15];

	public void init() {
		setLayout(new BorderLayout());
		
		//load images
		Image bild = getImage(getDocumentBase(), "Map.jpg");
		
		try {
			URL url1 = new URL(getDocumentBase(), "laptop.gif");
			URL url2 = new URL(getDocumentBase(), "mouse.gif");
			URL url3 = new URL(getDocumentBase(), "question.jpg");
			URL url4 = new URL(getDocumentBase(), "Treasure.jpg");
			img1 = ImageIO.read(url1);
			img2 = ImageIO.read(url2);
			img3 = ImageIO.read(url3);
			img4 = ImageIO.read(url4);
		} catch (IOException e) {}
		
		bp = new BildPanel(bild);
		
		/**
		*I have taken most of the audio form "Multimedia fusion 2"
		*where it provided very great sound effects and music
		*I choose some jazz music to fit the game's theme
		*/
		//load audio
		ljud[0] = getAudioClip(getDocumentBase(), "As Cool as Jazz.wav");
		ljud[1] = getAudioClip(getDocumentBase(), "Metal 1.wav");
		ljud[2] = getAudioClip(getDocumentBase(), "Jail slam.wav");
		ljud[3] = getAudioClip(getDocumentBase(), "BELL03.wav");
		ljud[4] = getAudioClip(getDocumentBase(), "Thwack.wav");
		ljud[5] = getAudioClip(getDocumentBase(), "BONUS3.wav");
		ljud[6] = getAudioClip(getDocumentBase(), "CASHREG2.wav");
		ljud[7] = getAudioClip(getDocumentBase(), "DONG.wav");
		ljud[8] = getAudioClip(getDocumentBase(), "ARABIA.wav");
		ljud[9] = getAudioClip(getDocumentBase(), "Small pop 2.wav");
		ljud[10] = getAudioClip(getDocumentBase(), "dicethrow2.wav");
		ljud[11] = getAudioClip(getDocumentBase(), "Wahoo 3.wav");
		ljud[12] = getAudioClip(getDocumentBase(), "The Late Club.wav");

		//initiate bricks, cards etc...
		addChestCards();
		addChanceCards();
		platsera();
		
		for(Place p : plats)
			bp.add(p);

		die.addMouseListener(dt);
		setSize(720,500);
		bp.add(die);

		//East panel
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setOpaque(true);
		east.setBackground(new Color(178,247,178));
		east.setBorder(new MatteBorder(3,6,3,6,new Color(50,126,52)));
		
		east.add(endTB);
		east.add(jsp);
		
		/**
		*The message label shows messages from Chance or Community Chest cards,
		*or when the game is over etc...
		*/
				
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
		com.add(throwDB);	
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
		ljud[12].loop();
		
		//add button and die listener
		endTB.addActionListener(endList);
		buyB.addActionListener(buyList);
		sellB.addActionListener(sellList);
		showB.addActionListener(showList);
		okSell.addActionListener(SellOK);
		throwDB.addActionListener(dieList);
		foojB.addActionListener(paytoJail);
		useFJC.addActionListener(freeOutOfJail);
		field.setEditable(false);
		
	}
	
	/**
	*The very first of the game starts with some jazz music
	*/
	
	public void start(){
		ljud[12].loop();
	}
	
	/**
	*...and ends the music if the menu music still plays
	*/
	
	public void stop(){
		ljud[12].stop();
	}
		
	//method of setting up the game after the start button have been pressed
	public void startTheGame(int lim, String na1, String na2){
		remove(menu);
		turnLimit = lim;
		add(bp, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		p1 = new Player(na1, 1000, img1);
		p2 = new Player(na2, 1000, img2);
		aktuell = p1;
		waitP = p2;
		addSpelare();
		field.append(aktuell.getNamn() +"'s turn\n");
		validate();
		repaint();
		ljud[12].stop();
		ljud[0].play();
		money.setText("Money: 1000");
	}
	

	//add the players
	public void addSpelare(){
		//spelare.add(p));
		plats.get(0).insert(p1);
		plats.get(0).insert(p2);
	}
	
	//add Chest cards
	public void addChestCards(){
		chest.add(new String("PENALTY"));
		chest.add(new String("FINED"));
		chest.add(new String("PAY"));
	}
	
	//add Chance cards
	public void addChanceCards(){
		chance.add(new String("BIRTHDAY"));
		chance.add(new String("JAIL"));
		chance.add(new String("REPAIR"));
	}
	
	/**
	*This is a game about buying rooms at DSV. It can be a teacher, some students, or
	*two head scinners rivaling each other for power in the School
	*/
	//add all the bricks on the playfield
	public void platsera(){
		//down
		plats.add(new Corner(1, 300, 300, "down", "GO!"));
		plats.add(new Street(2, 260, 300, "down", "506", 80, new Color(94, 60, 49)));
		plats.add(new CardPlace(3, 220, 300, "down", "treasure", img4));
		plats.add(new Street(4, 180, 300, "down", "507", 100, new Color(94, 60, 49)));
		plats.add(new Street(5, 140, 300, "down", "Sal C", 200, Color.white));
		plats.add(new ResourcePlace(6, 100, 300, "down", "Kårbibliotek", 200));
		plats.add(new CardPlace(7, 60, 300, "down", "question", img3));
		plats.add(new Corner(8, 0, 300, "down", "JAIL"));
		//left
		plats.add(new Street(9, 0, 260, "left", "510", 120, new Color(233, 63, 174)));
		plats.add(new Street(10, 0, 220, "left", "501", 140, new Color(233, 63, 174)));
		plats.add(new Street(11, 0, 180, "left", "Sal B", 200, Color.white));
		plats.add(new Street(12, 0, 140, "left", "502", 140, new Color(233, 63, 174)));
		plats.add(new Street(13, 0, 100, "left", "401", 180, new Color(233, 63, 174)));
		plats.add(new CardPlace(14, 0, 60, "left", "treasure", img4));
		//top
		plats.add(new Corner(15, 0, 0, "up", "PARKING"));
		plats.add(new Street(16, 60, 0, "up", "503", 220, Color.red));
		plats.add(new CardPlace(17, 100, 0, "up", "question", img3));
		plats.add(new Street(18, 140, 0, "up", "Sal A", 200, Color.white));
		plats.add(new Street(19, 180, 0, "up", "504", 240, Color.red));
		plats.add(new ResourcePlace(20, 220, 0, "up", "Disks café", 300));
		plats.add(new Street(21, 260, 0, "up", "505", 320, Color.red));
		plats.add(new Corner(22, 300, 0, "up", "GOTOJAIL"));
		//right
		plats.add(new ResourcePlace(23, 300, 60, "right", "Retaurang", 300));
		plats.add(new CardPlace(24, 300, 100, "right", "treasure", img4));
		plats.add(new Street(25, 300, 140, "right", "Sal D", 200, Color.white));
		plats.add(new CardPlace(26, 300, 180, "right", "question", img3));
		plats.add(new Street(27, 300, 220, "right", "Nätverksrum", 450, new Color(21, 39, 168)));
		plats.add(new Street(28, 300, 260, "right", "Foo bar", 500, new Color(21, 39, 168)));
	}
	
	/**
	*Throw the die too move the token or try to get out of jail
	*/
	//listener to the die
	Action dieList = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			if(diceThrown){
				field.append("You have already thrown the dice\n");
				return;
			}
			Random rand = new Random();
			int slump = rand.nextInt(6)+1;
			if(aktuell.isinJail){
				if(slump==6){
					ljud[11].play();
					aktuell.isinJail = false;
					field.append("You are free now!\n");
					north.remove(foojB);
					north.remove(useFJC);
				}
				else
					field.append("The die was lesser then 6!\n");

				die.settAntal(slump);
				diceThrown=true;			
				buyB.setEnabled(false);
				throwDB.setEnabled(false);
				endTB.setEnabled(true);
				return;
			}
			ljud[9].play();
			for(Place p : plats)
				if(p.finns(aktuell))
					p.taBort(aktuell);
			aktuell.setPlan(slump);
			for(Place p : plats)
				if(p.getNr() == aktuell.getPlan())
					p.insert(aktuell);
			die.settAntal(slump);
			diceThrown=true;
			field.append(aktuell.getNamn()+"'s die number is "+die.getAntal()+"\n");
			runPlaceEvents();			
			buyB.setEnabled(true);
			throwDB.setEnabled(false);
			endTB.setEnabled(true);
		}
	};
	
	//what happens after a player has thrown the die
	public void runPlaceEvents(){
		Place pl = plats.get(aktuell.getPlan()-1);
		javax.swing.Timer tim;
		if(pl instanceof Street || pl instanceof ResourcePlace){
			message.setText("Room: "+pl.getNamn());
			message.setForeground(pl.getCol());
		}

		else if(pl.getNamn().equals("JAIL"))
			field.append("Just visiting the Jail\n");

		else if(pl.getNamn().equals("GOTOJAIL")){
			field.append("You shall go to Jail!!!");
			endTB.setEnabled(false);
			tim = new javax.swing.Timer(2000, goinJail);
			tim.setRepeats(false);
			tim.start();
		}
	
		if(waitP.propExists(pl)){
			int pen = pl.getKost()/2;
			field.append("You are standing in one of\n "+waitP.getNamn() +" rooms! You must pay "+pen+"!\n");
			aktuell.setMoney(-(pen));
			waitP.setMoney(pen);
			money.setText("Money: "+aktuell.getMoney());
		}
		
		else if(pl.getNamn().equals("PARKING"))
			field.append("Just parking free\n");

		else if(pl instanceof CardPlace){
			endTB.setEnabled(false);
			if(pl.getNamn().equals("treasure")){
				tim = new javax.swing.Timer(2000, drawChest);
				tim.setRepeats(false);
				field.append("Drawing Chest card...\n");
				tim.start();
			}
			else if(pl.getNamn().equals("question")){
				tim = new javax.swing.Timer(2000, drawChance);
				tim.setRepeats(false);
				field.append("Drawing Chance card...\n");
				tim.start();
			}
		}
		if(pl.getNamn().equals("GO!") || aktuell.hasRounded()){
			ljud[3].play();
			aktuell.setMoney(200);
			money.setText("Money: "+aktuell.getMoney());
			field.append(aktuell.getNamn()+" has returned to GO\n and collects 200!\n");
		}
	}
	
	//Player goes to jail
	Action goinJail = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[2].play();
			for(Place p : plats)
				if(p.finns(aktuell))
					p.taBort(aktuell);
			plats.get(7).insert(aktuell);
			aktuell.isinJail = true;
			aktuell.setDirectPosition(8);
			endTB.setEnabled(true);
			buyB.setEnabled(false);
			throwDB.setEnabled(false);
		}
	};
	
	/**
	*In Monopoly, there are three ways of getting out. Throw a six on the die, pay the
	*Bank 200 or use a "Free Jail" card
	*/
	
	//Player pays to go out of jail	
	Action paytoJail = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[11].play();
			aktuell.setMoney(-200);
			money.setText("Money: "+aktuell.getMoney());
			aktuell.isinJail = false;
			field.append("You are free now!\n");
			north.remove(foojB);
			north.remove(useFJC);
			throwDB.setEnabled(false);
			diceThrown=true;
		}
	};
	
	//player use a "Free out of Jail" card
	Action freeOutOfJail = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[11].play();
			aktuell.isinJail = false;
			aktuell.haveJC = false;
			field.append("You are free now!\n");
			north.remove(foojB);
			north.remove(useFJC);
			throwDB.setEnabled(false);
			diceThrown=true;
		}
	};
	
	//Randomly draw a Community Chest Card
	Action drawChest = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[5].play();
			message.setForeground(Color.red);
				field.append("...drawn!\n");
				Random rand = new Random();
				int i = rand.nextInt(3);
				String kort = chest.get(i);

				if(kort.equals("PENALTY")){
					message.setText("Penalty! You must pay 80!");
					aktuell.setMoney(-80);
					money.setText("Money: "+String.valueOf(aktuell.getMoney()));
				}
				else if(kort.equals("FINED")){
					message.setText("Tax cheat! You must pay 100!");
					aktuell.setMoney(-100);
					money.setText("Money: "+String.valueOf(aktuell.getMoney()));
				}
				else if(kort.equals("PAY")){
					message.setText("Income tax refund. 200 collected!");
					aktuell.setMoney(200);
					money.setText("Money: "+String.valueOf(aktuell.getMoney()));
				}
				endTB.setEnabled(true);
		}
	};
	
	//Randomly draw a Chance card
	Action drawChance = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[5].play();
			message.setForeground(Color.red);
				field.append("...drawn!\n");
				Random rand = new Random();
				int i = rand.nextInt(3);
				String kort = chance.get(i);

				if(kort.equals("BIRTHDAY")){
					message.setText("It's your birthday today!\n");
					aktuell.setMoney(20);
					waitP.setMoney(-20);
					money.setText("Money: "+String.valueOf(aktuell.getMoney()));
				}
				else if(kort.equals("JAIL")){
					message.setText("You have a Free Jail card!\n");
					aktuell.haveJC = true;
				}
				else if(kort.equals("REPAIR")){
					message.setText("Make repairs on all of your rooms!\n");
					ArrayList<Place> nyL = aktuell.getProps();
					int cash = 0;
					for(Place p : nyL)
						cash+=10;
					aktuell.setMoney(-(cash));
					money.setText("Money: "+String.valueOf(aktuell.getMoney()));
				}
				endTB.setEnabled(true);
		}
	};
	
	//list all the rooms a player own
	Action showList = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[4].play();
			pMess.removeAll();
			pMess.add(message);
			message.setText("REPORT");
			message.setForeground(Color.black);
			ArrayList<Place> nyL = aktuell.getProps();
			field.append("---------------Room report---------------\n\n");
			for(Place p : nyL){
				field.append("-----------------------------------------\n");
				field.append("  Room : "+p.getNamn()+"\n  Cost: " + p.getKost()+"\n  Sell cost: "+(p.getKost()/2)+"\n");
			}
		}
	};
		
	//Listener to the sell button command
	Action sellList = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[4].play();
			pMess.removeAll();
			pMess.add(sp);
			pMess.add(okSell);
			sp.setPreferredSize(new Dimension(100,100));
			mod.clear();
			ArrayList<Place> nyL = aktuell.getProps();
			for(Place p : nyL)
				mod.addElement(p);
		}
	};
	
	//listener to the sell button
	Action SellOK = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[4].play();
			Place p =(Place) proplist.getSelectedValue();
			if(p==null)
				return;
			field.append("Room "+p.getNamn()+" sold to the Bank\n");
			aktuell.sellProp(p);
			mod.removeElement(p);
			aktuell.setMoney((p.getKost()/2));
			money.setText("Money: "+aktuell.getMoney());
			p.setBordColor(Color.black);
			map.setColorOnBrick(p.getNr(), Color.white);
		}
	};

	/**
	*When a player has ended a turn, players swap between "aktuell" and "waitP"
	*/
			
	//listener to the "End turn" button
	Action endList = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[1].play();
			if(!diceThrown){
				field.append("You have not thrown the die!\n");
				return;
			}
			pMess.removeAll();
			pMess.add(message);
			message.setText("LETS EARN LOTSA MONEY!");
			message.setForeground(Color.black);
			if(aktuell==p1){
				aktuell=p2;
				waitP = p1;
			}
			else if(aktuell==p2){
				aktuell=p1;
				waitP = p2;
				turn.setText("Turn: "+String.valueOf(++turnNr));
				
			}
			if(turnNr==turnLimit){
				ljud[8].play();
				field.setText("THE GAME IS OVER!");
				if(aktuell.getMoney()>waitP.getMoney())
					message.setText(aktuell.getNamn()+" WON THE ROUND!!!");
				else if(waitP.getMoney()>aktuell.getMoney())
					message.setText(waitP.getNamn()+" WON THE ROUND!!!");
				else
					message.setText("DRAW GAME...!");
				disableAll();
				return;
			}
			diceThrown=false;
			field.setText(aktuell.getNamn() + "'s turn\n");
			int cash = aktuell.getMoney()+aktuell.getIncome();
			aktuell.setMoney(aktuell.getIncome());
			money.setText("Money: "+String.valueOf(cash));

			if(aktuell.isinJail){
				field.append("You must strike die number 6 \n or pay 200 to get out!\n");
				if(aktuell.getMoney()>=200)
					north.add(foojB);
				if(aktuell.haveJC)
					north.add(useFJC);
			}
			else{
				north.remove(useFJC);
				north.remove(foojB);
			}

			buyB.setEnabled(false);
			throwDB.setEnabled(true);
		}
	};

	//Listener to the "Buy" button
	Action buyList = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			ljud[4].play();
			Place p = plats.get(aktuell.getPlan()-1);
			pMess.removeAll();
			pMess.add(message);
			if(aktuell.propExists(p)){
				field.append("You already own "+p.getNamn()+"!\n");
				return;
			}
			else if(p instanceof Corner || p instanceof CardPlace){
				field.append("You cannot buy that!\n");
				return;
			}
			else if(waitP.propExists(p)){
				field.append(p.getNamn()+" is already ownd by "+waitP.getNamn()+"!\n");
				return;
			}
			else if(aktuell.getMoney()<p.getKost()){
				field.append("Insufficient amount of money!\n");
				return;
			}
			ljud[6].play();
			message.setForeground(p.getCol());
			message.setText(p.getNamn());
			aktuell.buyProp(p);
			if(aktuell==p1){
				p.setBordColor(Color.blue);
				map.setColorOnBrick(p.getNr(), Color.blue);
			}
			else if(aktuell==p2){
				p.setBordColor(Color.red);
				map.setColorOnBrick(p.getNr(), Color.red);
			}
			
			aktuell.setMoney(-(p.getKost()));
			money.setText("Money: "+String.valueOf(aktuell.getMoney()));
			field.append(aktuell.getNamn()+"'s has bought "+p.getNamn()+"\n");
			buyB.setEnabled(false);
		}
	};
	
	//MouseListener to the die
	MouseListener dt = new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			if(diceThrown){
				field.append("You have already thrown the dice!\n");
				return;
			}
			ljud[10].play();
			endTB.setEnabled(false);
			javax.swing.Timer tid = new javax.swing.Timer(2000, dieList);
			field.append(aktuell.getNamn()+" is throwing the die\n");
			tid.setRepeats(false);
			tid.start();
		}
	};
	
	//method of disabling all the buttons after the end of the game
	public void disableAll(){
		buyB.setEnabled(false);
		sellB.setEnabled(false);
		showB.setEnabled(false);
		throwDB.setEnabled(false);
		remove(foojB);
		remove(useFJC);
		endTB.setEnabled(false);
		die.removeMouseListener(dt);
	}
	
	//the menu class

	class Menu extends JPanel{
		private JLabel title = new JLabel("MONOPOLY", JLabel.CENTER);
		private JPanel menu = new JPanel();
		private JLabel startText = new JLabel("Start a new game", JLabel.CENTER);
		private JLabel credits = new JLabel("View Credits", JLabel.CENTER);
		//credits
		private JPanel credit = new JPanel();
		private JTextArea creditText = new JTextArea(20,60);
		private JLabel creditButt = new JLabel("BACK");

		//Start a game
		private JPanel game = new JPanel();
		private JTextField name1 = new JTextField(15);
		private JTextField name2 = new JTextField(15);
		private String[] limits = {"100","75","50", "25"};
		private JComboBox box = new JComboBox(limits);
		private JLabel start = new JLabel("START GAME", JLabel.CENTER);
		private JLabel back = new JLabel("BACK", JLabel.CENTER);
	
		public Menu(){
			setLayout(new GridLayout(2,1,10,10));
			setOpaque(true);
			setBackground(new Color(178,247,178));
			title.setFont(new Font("Arial Black", Font.BOLD, 60));
			startText.setFont(new Font("Arial Black", Font.BOLD, 18));
			credits.setFont(new Font("Arial Black", Font.BOLD, 18));
			title.setForeground(Color.white);
			title.setOpaque(true);
			title.setBackground(Color.red);
			title.setBorder(new MatteBorder(5,5,5,5,Color.white));
			add(title);

			credit.setLayout(new GridLayout(2,1,60,10));
			credit.setOpaque(true);
			credit.setBackground(new Color(178,247,178));
			creditText.append("This game have been created all by:\nRichard Walton\n");
			creditText.append("Programs used: \n Adobe Photoshop\n MultiMedia Fusion 2\n Audacity\n");
			creditText.append("Thanks also to various people supporting the game\n");
			creditText.setEditable(false);
			credit.add(creditText);
			credit.add(creditButt);

			menu.setLayout(new GridLayout(2,1,60,10));
			menu.setOpaque(true);
			menu.setBackground(new Color(178,247,178));
			menu.add(startText);
			menu.add(credits);
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
			credits.addMouseListener(ml);
			creditButt.addMouseListener(ml);
			back.addMouseListener(ml);
			start.addMouseListener(ml);
		}
	
		MouseListener ml = new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				JLabel l = (JLabel)e.getSource();
				l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				l.setForeground(Color.red);
			}
		
			public void mouseExited(MouseEvent e){
				JLabel l = (JLabel)e.getSource();
				l.setForeground(Color.black);
			}
			public void mouseClicked(MouseEvent e){
				if(e.getSource()==credits){
					remove(menu);
					add(credit);
					validate();
					repaint();
					credits.setForeground(Color.black);
				}
				else if(e.getSource()==creditButt){
					remove(credit);
					add(menu);
					validate();
					repaint();
					creditButt.setForeground(Color.black);
				}
				else if(e.getSource()==startText){
					remove(menu);
					add(game);
					validate();
					repaint();
					startText.setForeground(Color.black);
				}
				else if(e.getSource()==back){
					remove(game);
					add(menu);
					validate();
					repaint();
					back.setForeground(Color.black);
				}
				else if(e.getSource()==start){
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








