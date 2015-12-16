import java.util.Scanner;

public class Inventory
{
	boolean burgerIt, hotDogsIt, friesIt, sodaIt, saladIt;
	int burgerInv, hotDogsInv, friesInv, sodaInv, saladInv;
	String result;

	int numOrder;
	String Order, input;

	public Inventory()
	{
		burgerInv = hotDogsInv = friesInv = sodaInv = saladInv = numOrder = 0;
		Order = "";
		result = "";
	}

	public void setInventories()
	{
		burgerInv = 200;
		hotDogsInv = 250;
		friesInv = 500;
		sodaInv = 500;
		saladInv = 150;
	}

	private int getOrdernum(String Order)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("How many ");
		System.out.println(Order);
		System.out.print(" would you like to order?");

		numOrder = sc.nextInt();
		return numOrder;
	}

	public void Chosen()
	{
		if(Order == "burger")
			burgerInv = burgerInv - numOrder;
		else if(Order == "hotdog")
			hotDogsInv = hotDogsInv - numOrder;
		else if(Order == "fries")
			hotDogsInv = hotDogsInv - numOrder;
		else if(Order == "soda")
			sodaInv = sodaInv - numOrder;
		else if(Order == "salad")
			saladInv = saladInv - numOrder;
	}

	public String toString()
	{
		result += Order + " " + numOrder + "\n";
		return "" + result;
	}

	public String getOrder(String input)
	{
		String order = input;

		return order;
	}

}

