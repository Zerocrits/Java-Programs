//Name:
//Prog:
//Spec:

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ToyStoreRunner
{
	public static void main(String[] args)
	{
		ToyStore toy = new ToyStore();
		System.out.println(toy);
		toy.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println(toy);
		System.out.println(toy.getMostFrequentToy());
		//System.out.println(toy.sortToysByCount);

		toy = new ToyStore();
		toy.loadToys("yahtzee, monopoly, candyland, monopoly, yahtzee, candyland");
		System.out.println("\n" + toy);
		System.out.println(toy.getMostFrequentToy());
		//System.out.println(sortToysByCount);

		toy = new ToyStore();
		toy.loadToys("operation, operation, boggle, scrabble, clue, life, clue, clue");
		System.out.println("\n" + toy);
		System.out.println(toy.getMostFrequentToy());
		//System.out.println(sortToysByCount);
	}
}