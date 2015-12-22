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
		String[] toy = toys.split(" ");
		for(int i = 0; i < toy.length(); i++)
		{
			if(getThatToy(toy.get(i).getName() != null)
				toyList.setCount
		}
		/*for(int i = 0; i < toyList.size(); i++)
		{
			temp = 0;

			for(int j = i+1; j < toyList.size(); j++)
			{
				if(getThatToy(toyList.get(i).getName()) == null)
				{
					temp++;
					toyList.remove(j);
				}
			}
			toyList.get(i).setName(toyList.get(i).getName());
			toyList.remove(i);
			toyList.get(i).setCount(temp);
			toyList.get(i).getName();
			toyList.get(i).getCount();
		}*/
	}

	/** Searches toyList for a toy with the same name as the parameter nm
	*   @return the toy if found, otherwise null
	*/
	public Toy getThatToy( String nm )
	{
		toyList = new ArrayList();

		for(Toy t:toyList)
			if(t.getName().equals(nm))
				return t;
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

/*
		for(int i = 0; i < toyList.size(); i++)
		{
			for(int j = 0; j < toyList.size(); j++)
			{
				if(toyList.get(i).getName() == toyList.get(j).getName())
					temp++;
			}
			toyList.get(i).setCount(temp);
			toyList.get(i).getCount();
			toyList.get(i).getName();
*/