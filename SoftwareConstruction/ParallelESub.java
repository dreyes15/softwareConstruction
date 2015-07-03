
public class ParallelESub{
	
	public static String ParallelESub(String name, int number) {
		String part1 = name;
		String part2 = null;
		String part3 = null;
		for (int i = 1; i <= number; i++) {
			part1 = "( ¬ " + name + i;
			while (i != number) {
				i++;
				part1 += " ^ ¬ " + name + i;
			}
			part1 += ") ^ ";
			i = 1;

			part2 = "(( ¬ " + name + i;
			while (i != number) {
				i++;
				part2 += " ^ ¬ " + name + i;
			}
			part2 += ") U ";
			i = 1;

			part3 = "(" + name + i;
			while (i != number) {
				i++;
				part3 += " ^ " + name + i;
			}
			part3 += "))";

		}

		return (part1 + part2 + part3);

	}
}