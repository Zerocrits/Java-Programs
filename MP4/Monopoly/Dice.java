import java.util.Arrays;

public class Dice
{
	private int[] Dice;

	public Dice()
	{
		Dice = new int[6];
		getSide();
	}

	public void makeFace()
	{
		for(int i = 1; i < Dice.length; i++)
		{
			Dice[i] = i;
		}
	}

	public int getSide()
	{
		makeFace();

		return Dice[(int)(Math.random() * Dice.length) + 1];
	}

	public String toString()
	{
		String result = "" + getSide();

		return result;
	}
}