//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

public class Car
{
	private String name;
	private String[] split;
	private int count;

	public Car()
	{
		name = "";
	}

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
	   return name;
	}
}