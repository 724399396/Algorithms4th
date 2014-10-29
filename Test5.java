import java.util.*;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cs = sc.nextLine().toCharArray();
		System.out.println(Arrays.toString(cs));
		char[] ss = new char[cs.length];
		int i = 0;
		outer:
		for (char c : cs) {
			for (char s : ss)
				if (s == c)
					continue outer;
			ss[i++] = c;			
		}
		String result = "";
		for (int j = i - 1; j >= 0; j--)
			result += ss[j];
		System.out.println(result);
	}
}
