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
	String make, model, trans, car, word, test;
	int mileage, year, cylinders, price;
	Scanner sc = new Scanner(System.in);

	public Carlot()
	{
		carList = new ArrayList<Car>();
		make = model = trans = car = word = test = "";
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
		word = ma + " " + mo + " " + tr + " " + mi + " " + yr + " " + cy + " " + pr;
		System.out.println(test);
	}

	public String setArray()
	{
		carList = new ArrayList<Car>();
		carList.add(new Car(word));
		test = carList.get(0).getName();
		return test;
	}

	public void addText(/*String make, String model, String trans, int mileage, int year, int cylinders, int price*/) throws Exception
	{
		PrintWriter data = new PrintWriter(new FileWriter("CarData.txt", true));
		data.print(make + " ");
		data.print(model + " ");
		data.print(trans + " ");
		data.print(mileage + " ");
		data.print(year + " ");
		data.print(cylinders + " ");
		data.print(price);
		data.println();
		data.close();
		reWrite();
	}

	public void getData()
	{
		Scanner sc = new Scanner(System.in);
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
		System.out.println();

		Carlot(mileage, year, cylinders, price, make, model, trans);
	}

	public void getAdd()
	{
		getData();
		try{
		addText(/*make, model, trans, mileage, year, cylinders, price*/);
		}
		catch(Exception e)
		{
			System.out.println("There was a problem");
    	}

	}

	public void reWrite()throws Exception
	{
		carList = new ArrayList<Car>();
		Scanner file = new Scanner(new File("CarData.txt"));
		while(file.hasNext())
		{
			carList.add(new Car(file.nextLine()));
		}
	}

	public void getInsert()
	{
		carList = new ArrayList<Car>();
		getData();
		carList.add(0,null);
		carList.set(0,"test");


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
		String cars = "";
		int total = 0;
		int lines = 0;
		Scanner file = new Scanner(new File("CarData.txt"));
		while(file.hasNextLine())
		{
			cars = "";
			//cars = file.readLine();
			//carList.add(cars);
			lines++;
		}
		for(int i = 0; i < lines; i++)
		{
			total = lines/7;
		}
		return cars;
	}
	public String toString()
	{
		return null;
	}
}