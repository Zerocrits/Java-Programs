//Bill joseph
//Vehicle Runner

import java.util.Scanner;

public class VehicleRunner
{
	public static void main(String[] args)
	{
		Vehicle vehicle = new Vehicle();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(choice != 6 && choice <= 5)
		{
			System.out.println("***Vehicle Runner***\n");
			System.out.println("Select a Vehicle:");
			System.out.println("1. Motorcycle");
			System.out.println("2. Plane");
			System.out.println("3. Train");
			System.out.println("4. Auto");
			System.out.println("5. Boat");
			System.out.println("6. Exit");

			System.out.print("\nChoice: ");
			choice = sc.nextInt();

			if(choice == 1)
				vehicle = new Motorcycle();

		}

	}

}