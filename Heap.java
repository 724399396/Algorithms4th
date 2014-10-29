public class Heap {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k = N/2; k >= 1; k--)
			sink(a,k,N);
		while ( N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	private static void sink(Comparable[] a, int w, int N) {
		while (w*2 <= N) {
			int j = w*2;
			if ( j < N && less(a,j,j+1)) j++;
			if (!less(a, w, j)) break;
			exch(a, w, j);
			w = j;
		}
	}
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i-1].compareTo(a[j-1]) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i-1]; a[i-1] = a[j-1]; a[j-1] = t;
	}
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
}
