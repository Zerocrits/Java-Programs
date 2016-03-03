//Bill Joseph
//Motorcycle

public class Motorcycle extends Vehicle
{
	// vars that unique to a motorcycle
	private double speed, cost;
	private String fuel;

	public Motorcycle()
	{

	}
	public void getSet()
	{
		super.getSetter(100, 100000, "fuel");
	}

	public String toString()
	{
		return "Motorcycle: " + super.toString();
	}
}