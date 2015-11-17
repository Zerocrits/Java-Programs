public class Sound
{
	/** the array of values in this sound; guaranteed not to be  null */
	private int[] samples;

	public Sound(int[] vals)
	{

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
		return cnt;
	}



	/** Removes all silence from the beginning of this sound.
	*	Silence is represented by a value of 0.
	*	Precondition:  samples contains at least one nonzero value
	*	Postcondition: the length of  samples reflects the removal of starting silence  */
	//PART B
	public void trimSilenceFromBeginning()
	{
	}

	public String toString()
	{
		String s = "";
		return s;
	}
}
