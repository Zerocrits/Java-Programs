import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Dimension;

public class Game extends JPanel implements ActionListener
{
	private Timer timer;
	private Player player;
	private Spike spike;
	private Background background;
	private JLabel lblScore;
	private int score = 0;
	private final int DELAY = 500;

	public Game()
	{
		score = 0;
		lblScore = new JLabel("Score: " + score);
		initGame();

	}


    private void initGame()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(1000, 600));

        player = new Player();
        spike = new Spike();
        background = new Background();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        doDrawing(g);
    }

	private void getScore()
	{
		if((player.getX()) > (spike.getX()))
			score++;
		lblScore = new JLabel("Score: " + score);
	}

    private void doDrawing(Graphics g)
    {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background.getImage(), 0, 0, this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);

        g2d.drawImage(spike.getImage(), spike.getX(), spike.getY(), this);

		if((player.getX()) > (spike.getX()))
			score++;
        g2d.drawString("Score: " + score,10,10);
    }

	@Override
    public void actionPerformed(ActionEvent e)
    {
        player.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            player.keyPressed(e);
        }
    }
}