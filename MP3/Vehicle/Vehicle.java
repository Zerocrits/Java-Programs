//Bill Joseph
//vehicle

public class Vehicle
{
	private double speed, cost;
	private String fuel;
	public Vehicle()
	{
		speed = cost = 0;
		fuel = " ";
	}
	public double getSpeed()
	{
		return speed;
	}
	public double getCost()
	{
		return cost;
	}
	public String getFuel()
	{
		return fuel;
	}
	public void getSetter(double speed, double cost, String fuel)
	{
		this.speed = speed;
		this.cost = cost;
		this.fuel = fuel;
	}
	public String toString()
	{
		return "Top Speed: " + topSpeed + "\nCost: " + cost + "\nFuel Type: " + fuelType;
	}
}
