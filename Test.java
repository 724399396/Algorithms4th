public class Test {
	public static void main(String[] args) {
		String s1 = args[0], s2 = args[1], s3 = args[2];
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		String[] ss = s1.split(s3);
		for (String s : ss) {
			if (s.equals(s2)) {
				System.out.print(s);
				break;
			}
		}
	}
}
