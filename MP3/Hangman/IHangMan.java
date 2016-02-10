import java.awt.Image;

public interface IHangMan
{
	void guessLetter(char guess);
	void guessWord(String guess);
	String getIncorrectLetters(); //All incorrect guesses put onto a string
	void newWord(); //Use dictionary to get a new word
	String getWordSoFar(); //The displayed word ex. co-m-p--er
	String getWord();
	int getAmtIncorrectGuesses();
	boolean win();
	String consoleDrawing();
	Image guiDrawing();
}





