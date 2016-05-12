import java.util.Arrays;

public class GameBoard
{
	private int[][] board;
	private Dice dice;

	public GameBoard()
	{
		board = new int[13][13];
		dice = new Dice();
		numberBoard();
	}

	public void numberBoard()
	{
		int label = 1;

		for(int i = 0; i < board[0].length-1; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(i == 0)
				{
					board[i][j] = label;
					label++;
				}
				else if(j == board.length-1)
				{
					board[i][j] = label;
					label++;
				}
			}
		}

		for(int i = board[0].length-1; i >= 0; i--)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(i == 0)
				{
					board[i][j] = label;
					label++;
				}
				else if((i > 0 && i < board.length-1) && (j == board.length-1))
				{
					board[i][j] = label;
					label++;
				}

			}
		}
		for(int i = board[0].length; i >= 0; i--)
		{
			for(int j = board.length-1; j >= 0; j--)
			{
<<<<<<< HEAD
				if(i == board[i].length-1)
=======
				if(i == board.length-1)
>>>>>>> origin/master
				{
					board[i][j] = label;
					label++;
				}
				else if((i > 0 && i < board.length-1) && (j == 0))
				{
					board[i][j] = label;
					label++;
				}

			}
		}
		int die = dice.getSide();
		board[board[0].length /2][board.length/2] = die;
		board[board[0].length /2 -1][board.length/2] = die;

		die = dice.getSide();
		board[board[0].length /2][board.length/2 -1] = die;
		board[board[0].length /2 -1][board.length/2 -1] = die;
	}

	public String toString()
	{
		String result = "";

		for(int i = 0; i < board[0].length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(j == board.length-1)
					result += board[i][j];
				else
					result += board[i][j] + ", ";
			}
			result += "\n";
		}

		return result;
	}
}