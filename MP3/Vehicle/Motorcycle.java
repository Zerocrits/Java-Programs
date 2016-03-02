//Bill Joseph
//Motorcycle

public class Motorcycle extends Vehicle
{
	// vars that unique to a motorcycle
	private double speed, cost;
	private String fuel;

	public Motorcycle()
	{
		speed = 10;
		fuel = "Diesel";
		cost = 100;
	}

	public Motorcycle(double speed, double cost, String fuel)
	{
		super(speed, cost, fuel);
		super.setSpeed(speed);
	}
}