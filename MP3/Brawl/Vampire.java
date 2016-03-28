public class Vampire extends Character
{
	private int health, level;
	public Vampire(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getNameOfAttack()
	{
		int r = (int)(Math.random() * 3+1);
		String attack = "";

		switch(r)
		{
			case(1): attack = "";
			case(2): attack = "";
			case(3): attack = "";
			case(4): attack = "";
		}

		return attack;
	}

	public int getHealth()
	{
		return health;
	}

	public int getLevel()
	{
		return level;
	}

	public String displayCharacter()
	{
		String character = "";


		return character;
	}

	public String toString()
	{
		String result = "";
		result += displayCharacter();
		result += "\nAttack Used: " + getNameOfAttack();
		result += "\nVampire's Level: " + getLevel();
		result += "\nVampire's Health: " + getHealth();
		return result;
	}
}