// Your Name
// WordsRunner
// Spec: Test out the methods of Word and WordList

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class WordListRunner
{
	public static void main( String[] args )
	{
		WordList test = new WordList("one two three four five six seven alligator");
		//test.sortWords();
		int vowelsRemoved = 0;

		System.out.println(test);
		System.out.println("Words with 2 vowels = " + test.countWordsWithXVowels(2));
		System.out.println("Words with 3 vowels = " + test.countWordsWithXVowels(3));
		System.out.println("Words with 4 vowels = " + test.countWordsWithXVowels(4));
		System.out.println("Words with 2 chars = " + test.countWordsWithXChars(2));
		System.out.println("Words with 3 chars = " + test.countWordsWithXChars(3));
		System.out.println("Words with 4 chars = " + test.countWordsWithXChars(4));
		System.out.println("Words with 5 chars = " + test.countWordsWithXChars(5));
		vowelsRemoved = test.removeWordsWithXChars(3);
		System.out.println("\nAfter removing words with 3 chars \n" + test);
		System.out.println("\nNumber of vowels in the words removed == " + vowelsRemoved);
		System.out.println("\n\n");


		test.setWords("fun fly four six times ten plus eight");
		//test.sortWords();
		System.out.println(test);
		System.out.println("Words with 2 vowels = " + test.countWordsWithXVowels(2));
		System.out.println("Words with 3 vowels = " + test.countWordsWithXVowels(3));
		System.out.println("Words with 4 vowels = " + test.countWordsWithXVowels(4));
		System.out.println("Words with 2 chars = " + test.countWordsWithXChars(2));
		System.out.println("Words with 3 chars = " + test.countWordsWithXChars(3));
		System.out.println("Words with 4 chars = " + test.countWordsWithXChars(4));
		System.out.println("Words with 5 chars = " + test.countWordsWithXChars(5));
		vowelsRemoved = test.removeWordsWithXChars(3);
		System.out.println("\nAfter removing words with 3 chars \n" + test);
		System.out.println("\nNumber of vowels in the words removed == " + vowelsRemoved);
		System.out.println("\n\n");


		test.setWords("alligator chicken dog cat pig buffalo");
		//test.sortWords();
		System.out.println(test);
		System.out.println("Words with 2 vowels = " + test.countWordsWithXVowels(2));
		System.out.println("Words with 3 vowels = " + test.countWordsWithXVowels(3));
		System.out.println("Words with 4 vowels = " + test.countWordsWithXVowels(4));
		System.out.println("Words with 2 chars = " + test.countWordsWithXChars(2));
		System.out.println("Words with 3 chars = " + test.countWordsWithXChars(3));
		System.out.println("Words with 4 chars = " + test.countWordsWithXChars(4));
		System.out.println("Words with 9 chars = " + test.countWordsWithXChars(9));
		vowelsRemoved = test.removeWordsWithXChars(3);
		System.out.println("\nAfter removing words with 3 chars \n" + test);
		System.out.println("\nNumber of vowels in the words removed == " + vowelsRemoved);
		System.out.println("\n\n");

	}
}