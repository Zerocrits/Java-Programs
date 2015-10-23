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
	private JTextField txtWord;
	private JButton btnRun;
	private Histogram gram;
	private ButtonListener listener;

	public HistogramGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("HistoGram Client");
		lblWords = new JLabel("");
		btnRun = new JButton("Run!");
		txtWord = new JTextField(30);

		btnRun.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblWords.setFont(new Font("Comic Sans MS", Font.BOLD, 8));

		listener = new ButtonListener();

		btnRun.addActionListener(listener);

		cp.add(lblTitle);
		cp.add(lblWords);
		cp.add(txtWord);
		cp.add(btnRun);

		setSize(400, 800);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		HistogramGUI gui = new HistogramGUI();
	}

/*	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();
			String data, histo = "";
			if(source == btnRun)
			{
				Histogram gram = new Histogram(txtWord.getText());
				data = gram.getData();
				histo = gram.getHistogram();
				JOptionPane.showMessageDialog(null,data + "\n" + histo);
			}
		}
	}
	*/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();
			String data, histo = "";
			if(source == btnRun)
			{
				Histogram gram = new Histogram(txtWord.getText());
				data = gram.getData();
				histo = gram.getHistogram();
				lblWords.setText(data + "\n" + histo);
			}
		}
	}
}