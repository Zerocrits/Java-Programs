// Name:
// Prog:
// Spec:


public class Monster implements Monsterable, Comparable
{
	private int myHeight;
	private int myWeight;
	private int myAge;

	//Default Constructor
	public Monster()
	{
		setMonster(0, 0, 0);
	}

	//Initialization  Constructor
	public Monster(int ht)
	{
		setMonster(ht, 0, 0);
	}
	 //Initialization  Constructor
	public Monster(int ht, int wt)
	{
		setMonster(ht, wt, 0);
	}

	public Monster(int ht, int wt, int age)
	{
		setMonster(ht, wt, age);
	}

	public void setMonster(int ht, int wt, int age)
	{
		myHeight = ht;
		myWeight = wt;
		myAge = age;
	}

	//Modifiers - These methods change the Object's values
	public void setHeight(int ht)
	{
		myHeight = ht;
	}

	public void setWeight(int wt)
	{
		myWeight = wt;
	}

	public void setAge(int age)
	{
		myAge = age;
	}

	//Accessors - These methods can only look at the Object's values
	public int getHeight()
	{
		return myHeight;
	}


	public int getWeight()
	{
		return 0;
	}

	public int getAge()
	{
		return 0;
	}

	//creates a new copy of this Object
	public Object clone()
	{
      return new Monster();
	}

	// returns true if height, weight and age are equal, otherwise false
	public boolean equals(Object o)
	{
		return true;
	}

	public int compareTo(Object monster)
	{
		return 0;
	}

	// Label and display the height, weight and age of this monster
	public String toString( )
	{
		String result = "";
		result += "Height = " + getHeight() + " Weight = " + getWeight() + " Age = " + getAge();
		return result;
	}
}