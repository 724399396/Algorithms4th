import java.util.*;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cs = sc.nextLine().toCharArray();
		String result = "";
		for (char c : cs) {
			switch(c) {
				case '0':
					result += "0";
					break;
				case '1':
					result += "1";
					break;
				case '2':
					result += "2";
					break;
				default:
			}
		}
		System.out.println(result);
	}
}
