//Madison Miatke
//Player
//Extend Character user used object

public class Player extends Character
{
	public Player()
	{
		super(5,15);
	}
	/** @return a random attack from a list appropriate to the particular Character */
	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "You sneak up and stab him!";
			case 2 : return "You do a round-house kick!";
			case 3 : return "You swipe out his legs!";
			case 4 : return "You command your to dog attack!";
		}

		return "Attack Failed";
	}

	/**	@return a String with an ASCII picture of the particular Character */
	public String displayCharacter()
	{
		String result = "";
		result +="\n                           ,,,                      ";
		result +="\n                          i i'                      ";
		result +="\n                          \\~;\\                      ";
		result +="\n                           \\; \\                     ";
		result +="\n                            \\ ;\\    ====            ";
		result +="\n                             \\ ;\\  ==== \\           ";
		result +="\n                        __,--';;;\\-' (  0           ";
		result +="\n                  __,--';;; ;;; ;;\\      >          ";
		result +="\n           __,--'\\\\ ;;; ;;; ;;; ;;;\\--__<           ";
		result +="\n    _ _,--' __,--'\\\\  ;;; __,~~' \\ ;\\               ";
		result +="\n   (_)|_,--' __,--'\\\\;,~~'        \\ ;\\              ";
		result +="\n   |(_)|_,--'       ~~             \\; \\             ";
		result +="\n   || |                             \\ ;\\            ";
		result +="\n    |_/                              !~!,           ";
		result +="\n                                 .---'''---.        ";
		result +="\n                                 |         |        ";
		result +="\n                                 |         |        ";
		result +="\n                                 |         |        ";
		result +="\n                                 `---------'        ";
		return result;
	}

	/** @return the level and health of this particular Character */
	public String toString()
	{
		return "You Lv." + getLevel() + "\nHealth: " + getHealth();
	}
}