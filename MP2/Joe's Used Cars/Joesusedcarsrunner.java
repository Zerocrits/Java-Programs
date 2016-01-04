//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Joesusedcarsrunner
{
	public static void main(String[] args)
	{
		int choice = 0;

		Scanner sc = new Scanner(System.in);

		Joesusedcars car = new Joesusedcars();

		System.out.println("1. Add a Car");
		System.out.println("2. Insert");
		System.out.println("3. Remove");
		System.out.println("4. Number of Cars on Lot");
		System.out.println("5. Value of Cars on Lot");
		System.out.println("6. View a Car");
		System.out.println("7. Sort by Price");
		System.out.println("8. View the Lot");
		System.out.println("9. Exit");

		if(choice == 1)
			car.getAdd();
		else(choice == 2)
			car.getInsert();
		else(choice == 3)
			car.getRemove();
		else(choice == 4)
			car.getNumber();
		else(choice == 5)
			car.getValue();
		else(choice == 6)
			car.getViewCar();
		else(choice == 7)
			car.getSort();
		else(choice == 8)
			car.getViewLot();
		else(choice == 9)
			System.out.println("Not A Valid Input!");
			//edit to exit
		else
			System.out.println("Not A Valid Input!");
	}
}