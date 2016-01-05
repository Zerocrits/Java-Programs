//Name: Bill Joseph
//Prog: Joes Used Cars
//Spec: Create a Car dealership

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class Carlot
{
	private ArrayList<Car> carList;
	String make, model, trans;
	int mileage, year, cylinders, price;
	Scanner sc = new Scanner(System.in);
	Scanner data = new Scanner(new File("CarData.txt"));

	public Carlot()
	{
		carList = new ArrayList<Car>();
		make = model = trans = "";
		mileage = year = cylinders = price = 0;
	}

	public void Carlot(int mi, int yr, int cy, int pr, String ma, String mo, String tr)
	{
		make = ma;
		model = mo;
		trans = tr;
		mileage = mi;
		year = yr;
		cylinders = cy;
		price = pr;
	}

	public void getAdd(String make, String model, String trans, int mileage, int year, int cylinders, int price)
	{
		System.out.print("\nMake: ");
		make = sc.nextLine();
		System.out.print("\nModel: ");
		model = sc.nextLine();
		System.out.print("\nTransmission Type: ");
		trans = sc.nextLine();
		System.out.print("\nMileage: ");
		mileage = sc.nextInt();
		System.out.print("\nYear: ");
		year = sc.nextInt();
		System.out.print("\nCylinders: ");
		cylinders = sc.nextInt();
		System.out.print("\nPrice: ");
		price = sc.nextInt();

		//carList.add(Carlot(mileage, year, cylinders, price, make, model, trans));
	}

	public void getInsert()
	{

	}

	public void getRemove()
	{

	}

	public int getNumber()
	{
		return 0;
	}

	public int getValue()
	{
		return 0;
	}

	public String getViewCar()
	{
		return null;
	}

	public String getSort()
	{
		return null;
	}

	public String getViewLot()
	{
	   return null;
	}
	public String toString()
	{
		return null;
	}
}