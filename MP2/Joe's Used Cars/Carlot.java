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
import java.io.*;

public class Carlot
{
	private ArrayList<Car> carList;
	String make, model, trans, car;
	int mileage, year, cylinders, price;
	Scanner sc = new Scanner(System.in);

	public Carlot()
	{
		carList = new ArrayList<Car>();
		make = model = trans = car = "";
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


	public void addText(String make, String model, String trans, int mileage, int year, int cylinders, int price) throws Exception
	{
		PrintWriter data = new PrintWriter(new FileWriter("CarData.txt"));
		data.println(make + '\n');
		data.println(model + '\n');
		data.println(trans + '\n');
		data.println(mileage + '\n');
		data.println(year + '\n');
		data.println(cylinders + '\n');
		data.println(price + '\n');
		data.close();
	}

	public void getAdd()
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

		Carlot(mileage, year, cylinders, price, make, model, trans);

		try{
		addText(make, model, trans, mileage, year, cylinders, price);
		}
		catch(Exception e)
		{
			System.out.println("There was a problem");
    	}

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

	public String getViewLot() throws Exception
	{
		String cars;
		int total = 0;
		int lines = 0;
		Scanner file = new Scanner(new File("CarData.txt"));
		while(file.hasNextLine())
		{
			cars = "";
			cars = file.readLine();
			carList.add(cars);
			lines++;
		}
		for(int i = 0; i < lines; i++)
		{
			total = lines/7;
		}
	}
	public String toString()
	{
		return null;
	}
}