//Bill Joseph
//vehicle

public class Vehicle
{
	private double topSpeed, cost;
	private String fuelType;
	public Vehicle()
	{
		topSpeed = cost = 0;
		fuelType = " ";
	}
	public Vehicle(double speed, double cost, String fuel)
	{
		topSpeed = speed;
		this.cost = cost;
		fuelType = fuel;
	}
	public double getSpeed()
	{
		return topSpeed;
	}
	public void setSpeed(double speed)
	{
		topSpeed = speed;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public String getFuel()
	{
		return fuelType;
	}
	public void setFuel(String fuel)
	{
		fuelType = fuel;
	}
	public String toString()
	{
		return topSpeed + ", " + cost + ", " + fuelType;
	}
}
