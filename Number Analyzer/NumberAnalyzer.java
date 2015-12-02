// Name:
// Prog:
// Spec:

import java.util.ArrayList;
import java.util.Scanner;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer()
	{
		list = new ArrayList();
	}

	public NumberAnalyzer(String numbers)
	{

	}

	public void setList(String numbers)
	{
		String[] strNums = numbers.split(" ");
		for(int i = 0; i < strNums.length; i++)
			list.add(new Number(Integer.parseInt(strNums[i])));
	}

	public int countOdds()
	{
      	int oddCount=0;
      	for(int i = 0; i < list.size(); i++)
      	{
			if(list[i] % 2 != 0)
				oddCount++;
		}
      	return oddCount;
	}

	public int countEvens()
	{
      	int evenCount=0;



      	return evenCount;
	}

	public int countPerfects()
	{
		int perfectCount=0;



      	return perfectCount;
	}

	public String toString()
	{
		return "";
	}
}