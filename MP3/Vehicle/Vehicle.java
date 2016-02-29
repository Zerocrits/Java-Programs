//Bill Joseph
//vehicle

public class Vehicle
{
	private double topSpeed, cost;
	private String fuelType;
	public Vehicle()
	{
		topSpeed = cost = 0;
		fuelType = "";
	}
	public Vehicle(double speed, double cost, String fuel)
	{
		topSpeed = speed;
		this.cost = cost;
		fuelType = fuel;
	}
	public String toString()
	{
		return topSpeed + ", " + cost + ", " + fuelType;
	}
}
