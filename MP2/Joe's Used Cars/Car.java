//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

public class Car
{
	private String name;
	private String[] split;
	private int count;

	/** creates a generic toy named 'toy' with a count of 1 */
	public Car()
	{
		name = "car";
	}

	/** assigns the name given with a count of 1*/
	public Car( String nm )
	{
		name = nm;
		split = name.split(" ");
	}

	public String getName()
	{
		return name;
	}

	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return "";
	}
}