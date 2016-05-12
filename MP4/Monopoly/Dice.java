import java.util.Arrays;

public class Dice
{
	private int[] Dice;

	public Dice()
	{
		Dice = new int[7];
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
		int num = Dice[(int)(Math.random() * Dice.length-1) + 1];
		return num;
	}

	public String toString()
	{
		String result = "" + getSide();

		return result;
	}
}