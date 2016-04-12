//Madison Miatke
//Cripple Chris
//Extend Character low level chracter to fight

public class CrippleChris extends Character
{
	public CrippleChris()
	{
		super(1,10);
	}
	/** @return a random attack from a list appropriate to the particular Character */
	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Cripple Chris hit you with his cane!";
			case 2 : return "Cripple Chris falls onto you!";
			case 3 : return "Cripple Chris calls in his EMS buddies!";
			case 4 : return "Cripple Chris throws his prostetic leg at you!";
		}

		return "Attack Failed";
	}

	/**	@return a String with an ASCII picture of the particular Character */
	public String displayCharacter()
	{
		String result = "";
		result +="\n          .---             ";
		result +="\n          / # o            ";
		result +="\n          \\,__>            ";
		result +="\n       .o-'-'--._          ";
		result +="\n      / |\\_      '.        ";
		result +="\n     |  |  \\   -,  \\       ";
		result +="\n     \\  /   \\__| ) |       ";
		result +="\n      '|_____[)) |,/       ";
		result +="\n         |===H=|\\ >>       ";
		result +="\n         \\  __,| \\_\\       ";
		result +="\n          \\/   \\  \\_\\      ";
		result +="\n          |\\    |  \\/      ";
		result +="\n          | \\   \\   \\\\     ";
		result +="\n          |  \\   |   \\\\    ";
		result +="\n          |__|\\ ,-ooD \\\\   ";
		result +="\n          |--\\_(\\.-'   \\o  ";
		result +="\n          '-.__)           ";
		return result;
	}

	/** @return the level and health of this particular Character */
	public String toString()
	{
		return "Cripple ChrisLv." + getLevel() + "\nHealth: " + getHealth();
	}
}