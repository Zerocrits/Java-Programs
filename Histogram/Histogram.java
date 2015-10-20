//Name -
//Prog -
//Spec -

import java.util.Scanner;

public class Histogram
{
	private int[] numCount;

	public Histogram(String line)
	{
		numCount = new int[10];
		setList(line);
	}

	// setList() goes through the line and makes use of the fact
	// that the numbers correspond to the indices in the numCount array
	// When a number appears it increments that value in the numCount array
	public void setList(String line)
	{
		for(int i = 0; i < numCount.length; i++)
			numCount[i] = line.charAt(i);
	}

	// getData() returns a String with the numbers 0 to 9 along with the occurences of each
	public String getData()
	{
		String data = "";
		for(int i = 0; i < numCount.length; i++)
			data += i + " - " + numCount[i] +"\n";
		return data;
	}

	// getHistogram() returns a String with the numbers 0 to 9
	//					and a visual representation with *'s
	public String getHistogram()
	{
		String histogram = "";
		int stars = 0;
		for(int i = 0; i < numcount.length; i++)
			if(stars
			histogram += i + ":" + getStars(stars);
	}

	// getStars returns a String with x number of *'s
	// this is a helper method for getHistogram
	public String getStars(int x)
	{

	}

	// toString() returns a String representation of Histogram
	//			 based on the numArray.  Essentially it just calls
	//			 getHistogram and makes this the default action for printing state
	public String toString()
	{
		return getHistogram();
	}
}