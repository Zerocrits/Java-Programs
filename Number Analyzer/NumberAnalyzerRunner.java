// Your Name
// Number Analyzer Runner
// Spec: A client program to demonstrate the use of Number Analyzer.

import java.util.ArrayList;
import java.util.Scanner;

public class NumberAnalyzerRunner
{
	public static void main(String[] args)
	{
		NumberAnalyzer test = new NumberAnalyzer("5 12 9 6 1 4 8 6");
		System.out.println(test);
		System.out.println("odd count = " + test.countOdds());
		System.out.println("even count = " + test.countEvens());
		System.out.println("perfect count = " + test.countPerfects()+"\n");

		test = new NumberAnalyzer("5 12 3 7 28 496 81 65 33 11");
		System.out.println(test);
		System.out.println("odd count = " + test.countOdds());
		System.out.println("even count = " + test.countEvens());
		System.out.println("perfect count = " + test.countPerfects()+"\n");

		test = new NumberAnalyzer("1 2 3 4 5 6 7 8 11 13 151 16 17 18 19 20");
		System.out.println(test);
		System.out.println("odd count = " + test.countOdds());
		System.out.println("even count = " + test.countEvens());
		System.out.println("perfect count = " + test.countPerfects()+"\n");


		// ***************************************
		// add the two other test cases from the spec
		// along with the same code to test out printing, odds, evens and perfect numbers

	}
}