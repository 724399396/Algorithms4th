import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cc = sc.nextLine().toCharArray();
		String result = "";
		for (char c : cc) {
			switch(c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					result += c;
					break;
			}
		}
		System.out.println(result);
	}
}
