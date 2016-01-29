public class HorseBarn
{
	/** The spaces in the barn. Each array element holds a reference to the horse
	* that is currently occupying the space. A null value indicates an empty space.
	*/
	private Horse[] spaces;

	/** Implemented but not currently used
	*   To utilize this we would need to add an assignHorse() method
	*	For now, just use it to instantiate the spaces array to the appropriate size
	*/
	public HorseBarn(int size)
	{
		spaces = new Horse[size];
	}

	public HorseBarn(Horse[] horses)
	{
		for(int i = 0; i < horses.length; i++)
		{
			Horse animal = horses[i];
			spaces[i] = animal;
		}
	}

	/** Returns the index of the space that contains the horse with the specified name.
	* Precondition: No two horses in the barn have the same name.
	* @param name the name of the horse to find
	* @return the index of the space containing the horse with the specified name;
	* -1 if no horse with the specified name is in the barn.
	* Horses Part A
	*    Mr. A Note: We need to check for null first to avoid a NullPointerException.
	*/

	public int findHorseSpace(String name)
	{
		for(int i = spaces.length; i > 0; i--)
		{
			Horse animal = spaces[i];
			if(animal != null && name.equals(animal.getName()))
				return i;
		}
		return -1;
	}

	/** Consolidates the barn by moving horses so that the horses are in adjacent spaces,
	* starting at index 0, with no empty space between any two horses.
	* Postcondition: The order of the horses is the same as before the consolidation.
	* Horses Part B
	*/
	public void consolidate()
	{

	}

	/** @return a String that shows "Empty Stall" or the horses Name and Weight
	*	each stall should appear on it's own line
	*/
	public String toString()
	{
		String result = "Horses on the farm: \n\n";

		for(int i = 0; i < spaces.length; i++)
			result += spaces[i] + ", Weight = ";
		// Create the result string to be returned here

		return result;
	}
}