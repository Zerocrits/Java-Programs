public class ArrayRunner
{
	public static void main(String[] args)
	{
		int[] intArr = {5,8,3,22,64,81};
		double[] dblArr = {3.4, 6.2, 9.8};
		int intResult;
		double dblResult;
		long lngResult;
		int[] intArrBackwards;
		String word = "APCS";

		intResult = ArrayUtility.getSum(intArr);
		System.out.println("\nSum of integers: " + intResult);

		dblResult = ArrayUtility.getSum(dblArr);
		System.out.println("\nSum of doubles: " + dblResult);

		lngResult = ArrayUtility.getProduct(intArr);
		System.out.println("\nProduct of integers: " + lngResult);

		System.out.println("\nInteger array forwards: ");
		System.out.println(ArrayUtility.arrayToString(intArr));

		intArrBackwards = ArrayUtility.reverseArray(intArr);
		System.out.println("\nInteger array backwards: ");
		System.out.println(ArrayUtility.arrayToString(intArrBackwards))    ;

		intResult = ArrayUtility.findMax(intArr);
		System.out.println("\nMax integer: " + intResult);

		intResult = ArrayUtility.findMin(intArr);
		System.out.println("\nMin integer: " + intResult);

		System.out.println("\nfoo contains \'e\': " + ArrayUtility.contains("foo",'e'));

		System.out.println("\nInteger array contains 6: " + ArrayUtility.contains(intArr, 6));

		System.out.print("\n" + word);
		word = ArrayUtility.pmEncrypt(word);
		System.out.println(" encrypted is: " + word);

		word = ArrayUtility.pmDecrypt(word);
		System.out.println("\ndecrypted it's: " + word + "\n");
	}
}