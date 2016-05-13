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

//Comments to be later removed
public class Monopoly
{
	//Main menu
	Menu mainmenu = new Menu();
	BuildPanel bp;
	ArrayList<Place> place = new ArrayList<Place>();
	Dice dice = new Dice();
	Player player1;
	Player player2;
	//ArrayList<String> chest = new ArrayList<String>();
	//ArrayList<String> chance = new ArrayList<String>();