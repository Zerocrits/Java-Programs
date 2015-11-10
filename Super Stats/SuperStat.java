import java.util.Arrays;

public class SuperStat
{
	private String[] strNums;
	private int[] intNums;

	/** Default / No arg Constructor - instantiates both strNums and intNums arrays to zero length */
	public SuperStat()
	{
		strNums = new String[0];
		intNums = new int[0];
	}

	/** Constructor that takes a String nums and builds both a String[] and an int[] from it */
	public SuperStat(String nums)
	{
		strNums = nums.split(",");
		intNums = new int[strNums.length];
		for(int i = 0; i < strNums.length; i++)
			intNums[i] = Integer.parseInt(strNums[i]);
	}

	/** Calculates the Min for this intNums array */
	public int getMin()
	{
		int min = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			if(i > intNums[i])
				min = intNums[i];
		return min;
	}

	/** Calculates the Max for this intNums array */
	public int getMax()
	{
		int max = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			if(i < intNums[i])
				max = intNums[i];
		return max;
	}

	/** Calculates the Range for this intNums array
	/*  Note: You should make use of getMax() and getMin() here, don't re-implement code you already have */
	public int getRange()
	{
		int max = getMax();
		int min = getMin();
		int range = 0;
		range = max-min;
		return range;

	}

	/** Calculates the Arithmetic Mean for this intNums array */
	public double getMean()
	{
		double mean = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			mean += intNums[i];
		return mean;
	}

	/** Calculates the Geometric Mean for this intNums array */
	public double getGeometricMean()
	{
		double mean = 0;
		for(int i = 0; i < intNums.length; i++)
			mean+= intNums[i];
		Math.sqrt(mean);
		return mean;
	}

	/** Calculates the median for this intNums array */
	public double getMedian()
	{
		double median = 0;
		int i=0;
		int j=0;

		if(intNums.length % 2 == 1)
		{
			median = intNums[intNums.length / 2];
		}
		/*else
		{
			i = intNums[intNums.length / 2];
			j = intNums[(intNums.length / 2)+1];

			median = intNums[intNums.length / 2 + ((j-i)/2)];
		}*/

		return median;
	}

	/** Populates an int[] with a mode or modes from the intNums array
	/*  Returns null if no mode found
	/*  Note: 	Be sure to first sort the array (built-in method in Java)
	/*			Consider using nested for loops (and several vars) to track potential modes */
	public String getMode()
	{
		int testMode=0;
		int testOccur=0;
		int mode=0;
		int occur=0;
		String modeList="";

		for(int i = 0; i < intNums.length; i++)
		{
			testMode = intNums[i];


			for(int j = 0; j < intNums.length; j++)
			{
				if(testMode == intNums[j]&&testMode != mode)
				{
					testOccur++;
				}
			}

			if(testOccur > occur)
			{
				mode = testMode;
				occur = testOccur;
				modeList =  "" + mode;
			}

			else if(testOccur == occur)
			{
				mode = testMode;
				occur = testOccur;
				modeList += "," + mode;
			}

			testOccur=0;
		}

		return modeList;
	}

	/** Standard Deviation is calculated
	/*		std dev = Square root of the sum of the square differences
	/*					from the mean divided by the number of values */
	public double getStdDev()
	{
		double dev = 0;
		double mean = getMean();
		double variance = 0;

		for(int i = 0; i < intNums.length; i++)
			variance += intNums[i] * intNums[i];
		variance = variance / intNums.length;
		dev = Math.sqrt(variance);
		String.format("%.2f", dev);

		return dev;
	}

	/** Returns a String with each of the Stats on a separate line
	/*  ie. Number of Values, Mean, Median, Mode, Min, Max, Range and Standard Deviation  */
	public String toString()
	{
		String result = "";

		result += "\nNumber of Values: " + intNums.length;
		result += "\nArithmetic Mean: " + getMean();
		result += "\nGeometric Mean: " + getGeometricMean();
		result += "\nMedian: " + getMedian();
		result += "\nMode: " + getMode();
		result += "\nMin: " + getMin();
		result += "\nMax: " + getMax();
		result += "\nRange: " + getRange();
		result += "\nStandard Deviation: " + getStdDev();

		return result;
	}
}