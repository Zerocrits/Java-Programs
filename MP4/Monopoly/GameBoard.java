import java.util.Arrays;

public class GameBoard
{
	private int[][] board;

	public GameBoard()
	{
		board = new int[10][10];
		numberBoard();
	}

	public void numberBoard()
	{
		int label = 1;

		for(int i = 0; i < board[0].length; i++)
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
				if(i == board.length-1)
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