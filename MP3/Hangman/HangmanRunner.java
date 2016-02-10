//Hangman Runner(Console)

import java.util.Scanner;

public class HangmanRunner
{
	public static void main(String[] args)
	{
		HangMan man = new HangMan();
		String result;
		String title;
		String dashes;
		String incorrect;
		String word;
		String drawing;
		int incorrectGuesses;
		boolean hasWon;
		while(hasWon = false)
		{
			Refresh(title,dashes,incorrect,word,drawing,incorrectGuesses,hasWon);
			result = Picture(title,dashes,incorrect,word,drawing,incorrectGuesses,hasWon);
			System.out.println(result);
		}
	}
	public static void Refresh(String title, String dashes, String incorrect,String word,String drawing,int incorrectGuesses,boolean hasWon)
	{
		title = "~~HangMan~~";
		dashes = man.getWordSoFar();
		incorrect = man.getIncorrectLetters();
		word = man.getWord();
		drawing = man.consoleDrawing();
		incorrectGuesses = man.getAmtIncorrectGuesses();
		hasWon = man.win();
	}
	public static String Picture(String title, String dashes, String incorrect,String word,String drawing,int incorrectGuesses,boolean hasWon)
	{
		HangMan man = new HangMan();
		String guess = "";
		Scanner sc = new Scanner(System.in);
		String result = "";
		result += title + "\nWord: " + dashes + "\n" + drawing + "\nIncorrect Guesses: " + incorrect;
		result += "\tNumber Incorrect: " + incorrectGuesses + "\nYour Guess: ";
		guess = sc.nextLine();
		if(guess.length() > 1)
			man.guessWord(guess);
		else
			man.guessLetter(guess.charAt(0));

		result += guess;

		return result;

	}
}