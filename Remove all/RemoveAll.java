//ArrayList remove() exercise

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveAll
{
	public static void main(String args[])
	{
		String again = "y";
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		String[] words = new String[10];
		while(again.equalsIgnoreCase("y"))
		{
			words[0]=("all");
			words[1]=("all");
			words[2]=("fun");
			words[3]=("dog");
			words[4]=("bat");
			words[5]=("cat");
			words[6]=("all");
			words[7]=("dog");
			words[8]=("all");
			words[9]=("all");

			System.out.println("Which Program?");
			System.out.println("1. For Loop Forwards");
			System.out.println("2. For Loop Backwards");
			System.out.println("3. While Loop Forwards");
			System.out.println("4. While Loop Backwards");
			System.out.println("5. Exit");
			System.out.print("Which Program?: ");
			choice = sc.nextInt();
			if(choice == 1)
				forForward(words);
			else if(choice == 2)
				forBackward(words);
			else if(choice == 3)
				whileForward(words);
			else if(choice == 4)
				whileBackward(words);
			else
				again = "no";
			System.out.print("Would You like to Try a different version?(y/n): ");
			again = sc.nextLine();
		}
		System.out.println("Thanks for Using Remove All!\n");
	}
	//While Loop Forwards
	public static void whileForward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 10; i > 0; i--)
			ray.add(words[i]);

		int i = 0;
		while(i < ray.size())
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i--;
			}
			i++;
		}
		System.out.println("\nWhile Loop Forwards:");
		System.out.println(ray);
		System.out.println(ray.size());
	}
	//While loop backwards
	public static void whileBackward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 10; i > 0; i--)
			ray.add(words[i]);

		int i = ray.size()-1;
		while(i >= 0)
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i++;
			}
			i--;
		}
		System.out.println("\nWhile Loop Backwards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
	//For loop forwards
	public static void forForward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 10; i > 0; i--)
			ray.add(words[i]);

		for(int i = 0; i < ray.size(); i++)
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i--;
			}
			i++;
		}
		System.out.println("\nFor Loop Forwardswards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
	//For loop backwards
	public static void forBackward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 10; i > 0; i--)
			ray.add(words[i]);

		for(int i = ray.size()-1; i >= 0; i--)
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i++;
			}
			i--;
		}
		System.out.println("\nFor Loop Forwardswards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
}