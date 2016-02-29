//Bill Joseph
//Boat

public class Boat extends Vehicle
{
	private double topSpeed, cost;
	private String fuelType;
	public Boat()
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
		return topSpeed + ", " + cost + ", " + fuelType;
	}
}