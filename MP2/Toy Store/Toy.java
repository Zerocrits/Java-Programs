//Name:
//Prog:
//Spec:


public class Toy
{
	private String name;
	private int count;

	/** creates a generic toy named 'toy' with a count of 1 */
	public Toy()
	{
		name = "toy";
	}

	/** assigns the name given with a count of 1*/
	public Toy( String nm )
	{
		name = nm + count;
	}

	public int getCount()
	{
		if(name == "toy")
		{
			count++;
		}
		return count;
	}

	public void setCount( int cnt )
	{
		count = cnt;
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