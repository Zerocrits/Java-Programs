// Name:Bill Joseph
// Prog:FancyWordRunner
// Spec:Run Fancy Word Program

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FancyWordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File ("fancyword.dat"));
		String word;
		FancyWord fw;
		int size = file.nextInt();
		file.nextLine();

		for(int i = 0; i<size; i++)
		{
			word = file.nextLine();
			fw = new FancyWord(word);
			System.out.println(fw);
	   }
	}
}