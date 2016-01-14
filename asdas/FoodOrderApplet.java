import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.applet.*;// for AudioClip
import java.util.Random;

public class FoodOrderApplet extends JApplet
{
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	private JButton btnSoda, btnPizza, btnFries, btnSalad, btnBread, btnClearorder, btnCompleteorder;
	private JLabel lblTotal, lblFood, lblTitle, lblTotalfood;
	private ImageIcon icoFood;
	private FoodOrder restaurant;
	private JTextField txtCompleteorder;
	private AudioClip audOscar;
	private ButtonListener listener;

	public void init()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("     Restaurant     ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblTotal = new JLabel();
		lblTotalfood = new JLabel();
		icoFood = new ImageIcon("Food.png");
		btnPizza = new JButton("Pizza");
		btnFries = new JButton("Fries");
		btnSalad = new JButton("Salad");
		btnBread = new JButton("Bread");
		btnSoda = new JButton("Soda");
		btnClearorder = new JButton("Clear Order");
		btnCompleteorder = new JButton("Complete Order");
		txtCompleteorder = new JTextField();
		lblFood = new JLabel();
		// Create button Listener
		listener = new ButtonListener();

		// Set the icon for our label (display the icoPig picture)
		lblFood.setIcon(icoFood);

		// Add the ActionListener to each of the buttons
		btnSoda.addActionListener(listener);
		btnPizza.addActionListener(listener);
		btnFries.addActionListener(listener);
		btnSalad.addActionListener(listener);
		btnBread.addActionListener(listener);
		btnClearorder.addActionListener(listener);
		btnCompleteorder.addActionListener(listener);

		// Add all the objects to the window in the order you want them to appear
		cp.add(lblTitle);
		cp.add(lblTotal);
		cp.add(lblTotalfood);
		cp.add(lblFood);
		cp.add(btnClearorder);
		cp.add(btnSoda);
		cp.add(btnPizza);
		cp.add(btnFries);
		cp.add(btnSalad);
		cp.add(btnBread);
		cp.add(btnCompleteorder);

		// Set size of window and make it visible
		setSize(600,600);
		setVisible(true);
	}

	private class ButtonListener implements ActionListener
    {
		FoodOrder restaurant = new FoodOrder();
		String strNum = "";
        public void actionPerformed(ActionEvent event)
        {
			int x = (int) (Math.random()*9) + 1;
			Object source = new Object();
			source = event.getSource();
			audOscar = getAudioClip(getDocumentBase(),"sound.wav");

			if(source == btnSoda)
			{
				if(x > 2)
				{
					audOscar.play();
				}
				restaurant.addSoda();
			}
			else if (source == btnPizza)
			{
				if(x > 3)
				{
					audOscar.play();
				}
				restaurant.addPizza();
			}
			else if (source == btnFries)
			{
				if(x > 4)
				{
					audOscar.play();
				}
				restaurant.addFries();
			}
			else if (source == btnSalad)
			{
				if(x > 5)
				{
					audOscar.play();
				}
				restaurant.addSalad();
			}
			else if (source == btnBread)
			{
				if(x > 6)
				{
					audOscar.play();
				}
				restaurant.addBread();
			}
			else if (source == btnClearorder)
			{
				if(x > 7)
				{
					audOscar.play();
				}
				restaurant.clearOrder();
			}
			else if (source == btnCompleteorder)
			{
				if(x > 8)
				{
					audOscar.play();
				}
				restaurant.getTotal();
				JOptionPane.showMessageDialog(null,"Total Comes to: $" + numberFormat.format(restaurant.getTotal()) + "!");
				restaurant.clearOrder();
			}
			lblTotal.setText(restaurant.toString());
			lblTotalfood.setText(restaurant.getFood());
		}
	}
}
