public class Sound
{
	/** the array of values in this sound; guaranteed not to be  null */
	private int[] samples;

	public Sound(int[] vals)
	{
		samples = new int[vals.length];
		for(int i = 0; i < vals.length; i++)
			samples[i] = vals[i];
		toString();
	}


	/** Changes those values in this sound that have an amplitude greater than  limit.
	*	Values greater than  limit are changed to  limit.
	*	Values less than  -limit are changed to  -limit.
	*	@param limit the amplitude limit
	*	Precondition:  limit >=  0
	*	@return the number of values in this sound that this method changed  */
	//PART A
	public int limitAmplitude(int limit)
	{
		int cnt = 0;
		if(limit >= 0)
		{
			if(cnt > limit)
				cnt = limit;
			else if(cnt < -limit)
				cnt = -limit;
		}

		return cnt;
	}



	/** Removes all silence from the beginning of this sound.
	*	Silence is represented by a value of 0.
	*	Precondition:  samples contains at least one nonzero value
	*	Postcondition: the length of  samples reflects the removal of starting silence  */
	//PART B
	public void trimSilenceFromBeginning()
	{
		int[] trim;
		int removal = 0;
		for(int i = 0; i < samples.length; i++)
		{
			if(samples[i] == 0)
				removal++;
			else
				i = samples.length;
		}
		trim = new int[(samples.length)-removal];
		for(int i = 0; i < trim.length; i++)
		{
			for(int j = removal; j < samples.length; j++)
				trim[i] = samples[j];
		}
		samples = new int[trim.length];
		for(int i = 0; i < trim.length; i++)
			samples[i] = trim[i];
	}

	public String toString()
	{
		String s = "";
		for(int i = 0; i <
		return s;
	}
}
