public class Player extends Character
{
	private int health, level;
	public Player(int h, int l)
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
			case(1): attack = "1";
			case(2): attack = "2";
			case(3): attack = "3";
			case(4): attack = "4";
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
		result += "\n(insert name here)'s Level: " + getLevel();
		result += "\n(insert name here)'s Health: " + getHealth();
		return result;
	}
}