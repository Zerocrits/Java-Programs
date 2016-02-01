public class HorseBarnRunner
{
	public static void main(String[] args)
	{
		Horse trigger = new Horsey("Trigger", 1340);
		Horse one = null;
		Horse silver = new Horsey("Silver", 1210);
		Horse lady = new Horsey("Lady", 1575);
		Horse four = null;
		Horse patches = new Horsey("Patches", 1350);
		Horse duke = new Horsey("Duke", 1410);

		Horse[] horses = {trigger, one, silver, lady, four, patches, duke};

		HorseBarn mrAsFarm = new HorseBarn(horses);

		System.out.println("Trigger is in slot number " + mrAsFarm.findHorseSpace("Trigger"));
		System.out.println("Patches is in slot number " + mrAsFarm.findHorseSpace("Patches"));

		System.out.println("\nMr A's Horse Farm BEFORE Consolidation:");
		System.out.println(mrAsFarm);
		System.out.println("\nMr A's Horse Farm AFTER Consolidation:");
		mrAsFarm.consolidate();
		System.out.println(mrAsFarm);
	}
}