import java.util.Comparator;
public class Insertion {
	public static void sort(Comparable[] a) {
		// 将a[]按升序排列
		int N = a.length;
		for (int i = 1; i < N; i++) {
			// 将a[i]插入到 a[i-1], a[i-2] ...之中
			for (int j = i; j > 0 && less(a[j],a[j-1]); j--)
				exch(a, j, j-1);
		}
	}
	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for (int i = 1; i < N; i++)
			for (int j = i; j>0 && less(c, a[j], a[j-1]); j--)
				exch(a,j,j-1);
	}
	// String
	public static void sort(String[] a, int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
				exch(a, j, j-1);
	}
	private static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v,w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t; 
	}	
	private static void exch(Object[] a, int i, int j) {
		Object t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a) {	
		for (int i = 0; i < a.length; i++)
			if (less(a[i],a[i-1])) return false;
		return true;
	}
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
