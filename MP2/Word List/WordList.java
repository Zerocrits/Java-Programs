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
		words = new ArrayList<Word>();
		setWords("");
	}

	public WordList(String listOfWords)
	{
		words.add(new Word(listOfWords));


	}

	public void setWords(String listOfWords)
	{
		String[] split = listOfWords.split(" ");

		for(int i = 0; i < split.length; i++)
			words.add(split[i]);
	}

	public int countWordsWithXChars(int size)
	{
		int count=0;
		for(int i = 0; i < words.size(); i++)
		{
			if(words.get(i).length() == size)
				count++;
		}
		return count;
	}

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