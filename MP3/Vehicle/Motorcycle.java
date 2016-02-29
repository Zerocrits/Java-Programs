//Bill Joseph
//Motorcycle

public class Motorcycle extends Vehicle
{
	private double topSpeed, cost;
	private String fuelType;
	public Motorcycle()
	{
		topSpeed = cost = 0;
		fuelType = "";
	}
	public double getSpeed()
	{
		return topSpeed;
	}
	public void setSpeed()
	{
		topSpeed = 10;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost()
	{
		cost = 100;
	}
	public String getFuel()
	{
		return fuelType;
	}
	public void setFuel()
	{
		fuelType = "diesel";
	}
	public String toString()
	{
		Vehicle one = new Vehicle(topSpeed, cost, fuelType);
		return topSpeed + ", " + cost + ", " + fuelType;
	}
}