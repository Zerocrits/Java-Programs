public class Trio implements MenuItem
{
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;

	public Trio(Sandwich aSandwich, Salad aSalad, Drink aDrink)
	{
		sandwich = aSandwich;
		salad = aSalad;
		drink = aDrink;
	}

	public String getName()
	{
		String name = sandwich.getName();

		return name;
	}

	public double getPrice()
	{
		double smallest = sandwich.getPrice();
		double total = 0;
		if(smallest > salad.getPrice())
		{
			total += smallest;
			smallest = salad.getPrice();
		}
		if(smallest > drink.getPrice())
		{
			total += smallest;
			smallest = drink.getPrice();
		}

		return smallest;
	}

	public String toString()
	{
		return "";
	}
}


