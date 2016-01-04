//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Joesusedcars
{
	private ArrayList<Usedcar> carList;

	public Joesusedcars()
	{
		carList = new ArrayList<Usedcar>();
	}

	/** Load toys takes a String such as "Clue Clue Clue Sorry Sorry" as a parameter
	*   It will parse this String into an array of Strings and then either:
	* 	a) Add that toy if it does not yet exist in the toyList or
	*	b) Increment the count for that toy by one
	*/
	public void loadToys( String toys )
	{
		String[] toy = toys.split(" ");
		for(int i = 0; i < toy.length; i++)
		{
			if(getThatToy(toy[i]) != null)
				getThatToy(toy[i]).setCount(getThatToy(toy[i]).getCount() + 1);
			else
				toyList.add(new Toy(toy[i]));
		}
	}

	/** Searches toyList for a toy with the same name as the parameter nm
	*   @return the toy if found, otherwise null
	*/
	public Usedcar getChoice( String nm )
	{
		for(int i = 0; i < toyList.size(); i++)
		{
			if(toyList.get(i).getName().equals(nm))
				return toyList.get(i);
		}
		return null;
	}

	/** @return the name of the toy that occurs the most frequently in toyList */
	public String getMostFrequentToy()
	{
		Toy constant = toyList.get(0);
		for(int i = 1; i < toyList.size(); i++)
			if(toyList.get(i).getCount() > constant.getCount())
				constant = toyList.get(i);
		return "Max is: " + constant.toString();
	}

	public String toString()
	{
	   return toyList.toString();
	}
}

/*




*/