import java.util.*;

public class Main2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int length = str.length();
		int mid = length / 2;
		String lsh = str.substring(0,mid);
		char[] cc = lsh.toCharArray();
		Arrays.sort(cc);
		String ls = "";
		for (int i = mid - 1; i >= 0; i--)
			ls += cc[i];
		String rsh = "";
		if (length % 2 != 0) {
			ls += str.charAt(mid);
			rsh += str.substring(mid+1,length);
		}
		else{
			rsh = str.substring(mid, length);
		}
		String rs = "";
		cc = rsh.toCharArray();
		Arrays.sort(cc);
		for (int i = 0; i < cc.length; i++)
				rs += cc[i];
		System.out.println(ls+rs);
	}
}

