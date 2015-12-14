// Name:
// Prog:
// Spec:

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class WordList
{
	private ArrayList<Word> words;

	public WordList()
	{
		setWords("");
	}

	public WordList(String listOfWords)
	{
		setWords(listOfWords);
	}

	public void setWords(String listOfWords)
	{
		words = new ArrayList();

		String[] word = listOfWords.split(" ");

		for(int i = 0; i < word.length; i++)
			words.add(new Word(word[i]));
	}

	public int countWordsWithXChars(int size)
	{
		int count=0;
		for(int i = 0; i < words.size(); i++)
		{
			String item = words.get(i);
			int itemLength = item.length();
			if(itemLength == size)
				count++;
		}
		return count;
	}
	/*

	public int removeWordsWithXChars(int size)
	{

	    words<Word> iterator = words.iterator();
	    while(iterator.hasNext())
	    {
	        String word = iterator.next();
	        if(word.length() == size)
	        {
	            iterator.remove(word);
	        }
	    }
	    return 0;
}*/

	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{





		return 0;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;






		return count;
	}

	public String toString()
	{
	   return "";
	}
}