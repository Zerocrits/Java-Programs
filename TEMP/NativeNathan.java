//Madison Miatke
//NativeNathan
//Extend Character high level chracter to fight

public class NativeNathan extends Character
{
	public NativeNathan()
	{
		super(7,20);
	}
	/** @return a random attack from a list appropriate to the particular Character */
	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Native Nathan stabs you with a spear!";
			case 2 : return "Native Nathan hits you with a bowgun dart!";
			case 3 : return "Native Nathan throws a tomhawk!";
			case 4 : return "Native Nathan calls in tribal warriors!";
		}

		return "Attack Failed";
	}

	/**	@return a String with an ASCII picture of the particular Character */
	public String displayCharacter()
	{
		String result = "";
		result +="\n         www               ";
		result +="\n        /n n\\        /\\   ";
		result +="\n        |/^\\|       /  \\  ";
		result +="\n        | , |       ^||^  ";
		result +="\n         \\_/         ||   ";
		result +="\n         _U_         ||   ";
		result +="\n       /`   `''-----'P3   ";
		result +="\n      / |. .|''-----'||   ";
		result +="\n      \\'|   |        ||   ";
		result +="\n       \\|   |        ||   ";
		result +="\n        E   |        ||   ";
		result +="\n       /#####\\       ||   ";
		result +="\n       /#####\\       ||   ";
		result +="\n         |||         ||   ";
		result +="\n         |||         ||   ";
		result +="\n         |||         ||   ";
		result +="\n         |||         ||   ";
		result +="\n        molom        Ll   ";
		return result;
	}

	/** @return the level and health of this particular Character */
	public String toString()
	{
		return "Native Nathan Lv." + getLevel() + "\nHealth: " + getHealth();
	}
}