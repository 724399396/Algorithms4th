import java.util.*;
public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = sc.nextLine().split(" ");
		int n = Integer.parseInt(ss[0]),
		    m = Integer.parseInt(ss[1]);
		String s = sc.nextLine();
		while (s.length() > m) {
			System.out.println(s.substring(0,m));
			s = s.substring(m);
		}
		int j = m - s.length();
		System.out.print(s);
		for (int i = 0; i < j; i++)
			System.out.print("0");
		System.out.println();
	}
}
