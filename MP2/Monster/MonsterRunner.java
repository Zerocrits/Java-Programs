// Name:
// Prog:
// Spec:

public class MonsterRunner
{
   public static void main(String[] args)
   {
		Monster zero = new Monster();
		Monster one = new Monster(8);
		Monster sam = new Monster(9, 4);
		Monster harry = new Monster(1, 2, 3);
		System.out.println("\nMonster zero: \n" + zero);
		System.out.println("\nMonster one: \n" + one);
		System.out.println("\nMonster sam: \n" + sam);
		System.out.println("\nMonster harry: \n" + harry);

		System.out.println("\nChanging harry's properties... ");
		harry.setHeight(7);
		harry.setWeight(6);
		harry.setAge(5);
		System.out.println("\nMonster harry: \n" + harry);

		System.out.println("\nCloning sam into harry...");
		sam = (Monster)harry.clone();
		System.out.println("\nMonster sam: \n" + sam);

		Monster mOne = new Monster(33,33,11);
		Monster mTwo = new Monster(55,33,11);

		System.out.println("\nMonster 1: \n" + mOne);
		System.out.println("\nMonster 2: \n" + mTwo);

		System.out.print("\nmOne.equals(mTwo) = ");
		System.out.println(mOne.equals(mTwo));

		System.out.print("\nmOne.compareTo(mTwo) = ");
		System.out.println(mOne.compareTo(mTwo));
		System.out.print("\nmTwo.compareTo(mOne) = ");
		System.out.println(mTwo.compareTo(mOne));
	}
}