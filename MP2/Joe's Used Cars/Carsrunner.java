//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Carsrunner
{
	public static void main(String[] args)
	{
		int choice = 0;

		Scanner sc = new Scanner(System.in);

		Carlot car = new Carlot();

		while(choice != 9)
		{
			System.out.println("***************************");
			System.out.println("*1. Add a Car             *");
			System.out.println("*2. Insert                *");
			System.out.println("*3. Remove                *");
			System.out.println("*4. Number of Cars on Lot *");
			System.out.println("*5. Value of Cars on Lot  *");
			System.out.println("*6. View a Car            *");
			System.out.println("*7. Sort by Price         *");
			System.out.println("*8. View the Lot          *");
			System.out.println("*9. Exit                  *");
			System.out.println("***************************");
			System.out.print("Choice: ");
			choice = sc.nextInt();

			if(choice == 1)
				car.getAdd();
			else if(choice == 2)
				car.getInsert();
			else if(choice == 3)
				car.getRemove();
			else if(choice == 4)
				car.getNumber();
			else if(choice == 5)
				car.getValue();
			else if(choice == 6)
				car.getViewCar();
			else if(choice == 7)
				car.getSort();
			//else if(choice == 8)
				//car.getViewLot();
			else if(choice == 9)
				System.out.println("Thanks for using CarLot!");
				//edit to exit
			else
				System.out.println("Not A Valid Input!");
		}
	}
}