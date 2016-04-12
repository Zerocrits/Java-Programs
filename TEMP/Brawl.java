//Madison Miatke
//Brawl
//Play against other character, brawl it out

import java.util.*;
public class Brawl
{
	public static void main(String[] args)
	{
		int fightCount;
		Player user = new Player();
		Character opponent = new Player();
		Scanner sc = new Scanner(System.in);
		String str="";

		System.out.println("******WELCOME TO BRAWL******");
		while(user.isNotDefeated())
		{
			user.setHealth(15);
			int r = (int) (Math.random() * 4)+1;
			switch(r)
			{
				case 1 : System.out.println("\n\nYou Are Fighting Cripple Chris!"); opponent = new CrippleChris(); break;
				case 2 : System.out.println("\n\nYou Are Fighting Native Nathan!"); opponent = new NativeNathan(); break;
				case 3 : System.out.println("\n\nYou Are Fighting Average Adam!"); opponent = new AverageAdam(); break;
				case 4 : System.out.println("\n\nYou Are Fighting Snake Charmer Sam!"); opponent = new SnakeCharmerSam(); break;
			}

			while(user.isNotDefeated() && opponent.isNotDefeated())
			{
				System.out.println("\nPress Enter To Attack!");
				str= sc.nextLine();
				System.out.println(user.displayCharacter());
				System.out.println(user.getNameOfAttack());
				System.out.println(user.attacks(opponent));
				System.out.println("\n" + user.toString());
				System.out.println("\n" + opponent.toString());
				if(opponent.isNotDefeated())
				{
					System.out.println("\nPress Enter To Defend!");
					str= sc.nextLine();
					System.out.println(opponent.displayCharacter());
					System.out.println(opponent.getNameOfAttack());
					System.out.println(opponent.attacks(user));
					System.out.println("\n" + user.toString());
					System.out.println("\n" + opponent.toString());
				}
				else
					System.out.println("\n*****YOU WON*****\n");
			}
		}
		System.out.println("\n*****YOU LOST*****\n");
	}
}
/*

    _ _,--' __,--'\\  ;;; __,~~' \ ;\
   (_)|_,--' __,--'\\;,~~'        \ ;\
   |(_)|_,--'       ~~             \; \
   || |                             \ ;\
    |_/                              !~!,
                                 .---'''---.
                                 |         |
                                 |         |
                                 |         |
                                 `---------'
You swipe out his legs!
Damage: 1

You Lv.5
Health: 12

Cripple ChrisLv.1
Health: 0

*****YOU WON*****



You Are Fighting Snake Charmer Sam!

Press Enter To Attack!


                           ,,,
                          i i'
                          \~;\
                           \; \
                            \ ;\    ====
                             \ ;\  ==== \
                        __,--';;;\-' (  0
                  __,--';;; ;;; ;;\      >
           __,--'\\ ;;; ;;; ;;; ;;;\--__<
    _ _,--' __,--'\\  ;;; __,~~' \ ;\
   (_)|_,--' __,--'\\;,~~'        \ ;\
   |(_)|_,--'       ~~             \; \
   || |                             \ ;\
    |_/                              !~!,
                                 .---'''---.
                                 |         |
                                 |         |
                                 |         |
                                 `---------'
You sneak up and stab him!
Damage: 2

You Lv.5
Health: 15

Snake Charmer Sam Lv.5
Health: 14

Press Enter To Defend!


        ___
      ,'._,`.
     (-.___.-)
     (-.___.-)
     `-.___.-'
      ((  @ @|              .            __
       \   ` |         ,\   |`.    @|   |  |      _.-._
      __`.`=-=mm===mm:: |   | |`.   |   |  |    ,'=` '=`\
     (    `-'|:/  /:/  `/  @| | |   |, @| @|   /---)W(---\
      \ \   / /  / /         @| |   '         (----| |----) ,~
      |\ \ / /| / /            @|              \---| |---/  |
      | \ V /||/ /                              `.-| |-,'   |
      |  `-' |V /                                 \| |/    @'
      |    , |-'                                 __| |__
      |    .;: _,-.                         ,--''..| |..''--.
      ;;:::' '    )                        (`--::__|_|__::--')
    ,-'     _ ,  /                          \`--...___...--'/
   (    -:--'/  /                           /`--...___...--'\
    '-._  `''._/                           /`---...___...---'\
        '-._   '---.                      (`---....___....---')
         .' ',._ ,' )                     |`---....___....---'|
         /`._|  `|  |                     (`---....___....---')
        (   \    |  /                      \`---...___...---'/
         `.  `,  ^''                        `:--...___...--;'
           `.,'                               `-._______.-'
Snake Charmer Sam makes his snake attack you!
Damage: 4

You Lv.5
Health: 11

Snake Charmer Sam Lv.5
Health: 14

Press Enter To Attack!


                           ,,,
                          i i'
                          \~;\
                           \; \
                            \ ;\    ====
                             \ ;\  ==== \
                        __,--';;;\-' (  0
                  __,--';;; ;;; ;;\      >
           __,--'\\ ;;; ;;; ;;; ;;;\--__<
    _ _,--' __,--'\\  ;;; __,~~' \ ;\
   (_)|_,--' __,--'\\;,~~'        \ ;\
   |(_)|_,--'       ~~             \; \
   || |                             \ ;\
    |_/                              !~!,
                                 .---'''---.
                                 |         |
                                 |         |
                                 |         |
                                 `---------'
You sneak up and stab him!
Damage: 1

You Lv.5
Health: 11

Snake Charmer Sam Lv.5
Health: 13

Press Enter To Defend!


        ___
      ,'._,`.
     (-.___.-)
     (-.___.-)
     `-.___.-'
      ((  @ @|              .            __
       \   ` |         ,\   |`.    @|   |  |      _.-._
      __`.`=-=mm===mm:: |   | |`.   |   |  |    ,'=` '=`\
     (    `-'|:/  /:/  `/  @| | |   |, @| @|   /---)W(---\
      \ \   / /  / /         @| |   '         (----| |----) ,~
      |\ \ / /| / /            @|              \---| |---/  |
      | \ V /||/ /                              `.-| |-,'   |
      |  `-' |V /                                 \| |/    @'
      |    , |-'                                 __| |__
      |    .;: _,-.                         ,--''..| |..''--.
      ;;:::' '    )                        (`--::__|_|__::--')
    ,-'     _ ,  /                          \`--...___...--'/
   (    -:--'/  /                           /`--...___...--'\
    '-._  `''._/                           /`---...___...---'\
        '-._   '---.                      (`---....___....---')
         .' ',._ ,' )                     |`---....___....---'|
         /`._|  `|  |                     (`---....___....---')
        (   \    |  /                      \`---...___...---'/
         `.  `,  ^''                        `:--...___...--;'
           `.,'                               `-._______.-'
Snake Charmer Sam makes his snake attack you!
Damage: 4

You Lv.5
Health: 7

Snake Charmer Sam Lv.5
Health: 13

Press Enter To Attack!


                           ,,,
                          i i'
                          \~;\
                           \; \
                            \ ;\    ====
                             \ ;\  ==== \
                        __,--';;;\-' (  0
                  __,--';;; ;;; ;;\      >
           __,--'\\ ;;; ;;; ;;; ;;;\--__<
    _ _,--' __,--'\\  ;;; __,~~' \ ;\
   (_)|_,--' __,--'\\;,~~'        \ ;\
   |(_)|_,--'       ~~             \; \
   || |                             \ ;\
    |_/                              !~!,
                                 .---'''---.
                                 |         |
                                 |         |
                                 |         |
                                 `---------'
You do a round-house kick!
Damage: 1

You Lv.5
Health: 7

Snake Charmer Sam Lv.5
Health: 12

Press Enter To Defend!


        ___
      ,'._,`.
     (-.___.-)
     (-.___.-)
     `-.___.-'
      ((  @ @|              .            __
       \   ` |         ,\   |`.    @|   |  |      _.-._
      __`.`=-=mm===mm:: |   | |`.   |   |  |    ,'=` '=`\
     (    `-'|:/  /:/  `/  @| | |   |, @| @|   /---)W(---\
      \ \   / /  / /         @| |   '         (----| |----) ,~
      |\ \ / /| / /            @|              \---| |---/  |
      | \ V /||/ /                              `.-| |-,'   |
      |  `-' |V /                                 \| |/    @'
      |    , |-'                                 __| |__
      |    .;: _,-.                         ,--''..| |..''--.
      ;;:::' '    )                        (`--::__|_|__::--')
    ,-'     _ ,  /                          \`--...___...--'/
   (    -:--'/  /                           /`--...___...--'\
    '-._  `''._/                           /`---...___...---'\
        '-._   '---.                      (`---....___....---')
         .' ',._ ,' )                     |`---....___....---'|
         /`._|  `|  |                     (`---....___....---')
        (   \    |  /                      \`---...___...---'/
         `.  `,  ^''                        `:--...___...--;'
           `.,'                               `-._______.-'
Snake Charmer Sam plays a deafening note!
Damage: 5

You Lv.5
Health: 2

Snake Charmer Sam Lv.5
Health: 12

Press Enter To Attack!


                           ,,,
                          i i'
                          \~;\
                           \; \
                            \ ;\    ====
                             \ ;\  ==== \
                        __,--';;;\-' (  0
                  __,--';;; ;;; ;;\      >
           __,--'\\ ;;; ;;; ;;; ;;;\--__<
    _ _,--' __,--'\\  ;;; __,~~' \ ;\
   (_)|_,--' __,--'\\;,~~'        \ ;\
   |(_)|_,--'       ~~             \; \
   || |                             \ ;\
    |_/                              !~!,
                                 .---'''---.
                                 |         |
                                 |         |
                                 |         |
                                 `---------'
You command your to dog attack!
Damage: 5

You Lv.5
Health: 2

Snake Charmer Sam Lv.5
Health: 7

Press Enter To Defend!


        ___
      ,'._,`.
     (-.___.-)
     (-.___.-)
     `-.___.-'
      ((  @ @|              .            __
       \   ` |         ,\   |`.    @|   |  |      _.-._
      __`.`=-=mm===mm:: |   | |`.   |   |  |    ,'=` '=`\
     (    `-'|:/  /:/  `/  @| | |   |, @| @|   /---)W(---\
      \ \   / /  / /         @| |   '         (----| |----) ,~
      |\ \ / /| / /            @|              \---| |---/  |
      | \ V /||/ /                              `.-| |-,'   |
      |  `-' |V /                                 \| |/    @'
      |    , |-'                                 __| |__
      |    .;: _,-.                         ,--''..| |..''--.
      ;;:::' '    )                        (`--::__|_|__::--')
    ,-'     _ ,  /                          \`--...___...--'/
   (    -:--'/  /                           /`--...___...--'\
    '-._  `''._/                           /`---...___...---'\
        '-._   '---.                      (`---....___....---')
         .' ',._ ,' )                     |`---....___....---'|
         /`._|  `|  |                     (`---....___....---')
        (   \    |  /                      \`---...___...---'/
         `.  `,  ^''                        `:--...___...--;'
           `.,'                               `-._______.-'
Snake Charmer Sam hits you with his flute!
Damage: 4

You Lv.5
Health: -2

Snake Charmer Sam Lv.5
Health: 7

*****YOU LOST*****

Press any key to continue . . .
*/