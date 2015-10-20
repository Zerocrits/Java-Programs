//Name -
//Prog -
//Spec -

public class HistogramClient
{
	public static void main(String args[])
	{
		String data = "", histo = "";
		Histogram test = new Histogram("1 5 3 4 5 5 5 4 3 2 5 5 5 3");

		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);

		test.setList("2 3 4 5 6 7 8 9 0 2 3 5 6 8 8 8 9 4 5");
		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);

		test.setList("2 3 4 5 6 7 8 2 0 2 3 5 6 8 8 8 9 4 5");
		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);
	}
}