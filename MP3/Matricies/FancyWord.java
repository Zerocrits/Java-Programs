// Name:
// Prog:
// Spec:
import java.util.Arrays;

public class FancyWord
{
	private String[][] mat;

	public FancyWord()
	{
		mat = new String[0][0];
	}

   	public FancyWord(String s)
	{
		int size = s.length();
		mat = new String[size][size];

		for(String[] row : mat)
			Arrays.fill(row," ");

		for(int i = 1; i < size-1; i++)
		{
			mat[i][i] += "" + s.charAt(i);
			for(int j = size-1; j > 1; j++)
			{
				mat[j][j] += "" + s.charAt(j);
			}
		}


		// size the matrix
		// use Arrays.fill() to fill in the matrix with spaces
		// use a for loop to load in the letters into the matrix
	}

	public String toString()
	{
		String output = "";

		// use nested for loops to build a String from the matrix

		return output + "\n";
	}
}