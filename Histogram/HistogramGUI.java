//Bill Joseph
//Histogram
//Histogram GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HistogramGUI extends JFrame
{
	private String words = "";
	private JLabel lblWords, lblTitle;
	private JButton btnRun;
	private Histogram gram;
	private ButtonListener listener;

	public HistogramGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("HistoGram Client");
		lblWords = new JLabel(words);
		btnRun = new JButton("Run!");

		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

		cp.add(lblTitle);
		cp.add(lblWords);
		cp.add(btnRun);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		HistogramGUI gui = new HistogramGUI();
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();
		}
	}
}