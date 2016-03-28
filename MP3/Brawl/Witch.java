public class Witch extends Character
{
	private int health, level;
	public Witch(int h, int l)
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
			case(1): attack = "11";
			case(2): attack = "22";
			case(3): attack = "33";
			case(4): attack = "44";
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
		result += "\nAttack Used: " + getNameOfAttack();
		result += "\nWitch's Level: " + getLevel();
		result += "\nWitch's Health: " + getHealth();
		return result;
	}
}