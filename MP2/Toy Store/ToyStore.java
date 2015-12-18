//Name:
//Prog:
//Spec:

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		getThatToy("");
	}

	/** Load toys takes a String such as "Clue Clue Clue Sorry Sorry" as a parameter
	*   It will parse this String into an array of Strings and then either:
	* 	a) Add that toy if it does not yet exist in the toyList or
	*	b) Increment the count for that toy by one
	*/
	public void loadToys( String toys )
	{
		int temp = 0;

		String[] toy = toys.split(" ");
		ArrayList<Toy> toyList = new ArrayList(Arrays.asList(toy));

		for(int i = 0; i < toy.length; i++)
		{
			for(int j = 0; j < toy.length; j++)
			{
				if(toy[i] == toy[j] && j != 0)
					toyList.remove(j);
			}
		}
		for(int i = 0; i < toyList.size(); i++)
		{
			toyList.get(i).getName();
			toyList.get(i).getCount();
		}
	}

	/** Searches toyList for a toy with the same name as the parameter nm
	*   @return the toy if found, otherwise null
	*/
	public Toy getThatToy( String nm )
	{
		toyList = new ArrayList();

		for(int i = 0; i < toyList.size(); i++)
		{
			if(toyList.get(i).equals(nm))
				return toyList.get(i);
		}
		return null;
	}

	/** @return the name of the toy that occurs the most frequently in toyList */
	public String getMostFrequentToy()
	{
		String name = "";
		int temp = 0;
		int temp1 = 0;
		for(int i = 0; i < toyList.size(); i++)
		{
			for(int j = 0; j < toyList.size(); j++)
				if(toyList.get(i) == toyList.get(j))
					temp++;
					temp1 = i;
		}
		name = toyList.get(temp1).getName();
		return name;
	}

	public void sortToysByCount()
	{
	}

	public String toString()
	{
	   return toyList.toString();
	}
}