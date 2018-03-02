public class MergeBU {
	private static Comparable[] aux;	//归并所需辅助数组
	public static void sort(Comparable[] a) {
		//进行lgN次两两归并
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz)	//sz子数组大小
			for (int lo = 0; lo < N-sz; lo += sz+sz)//lo:子数组索引
			  merge(a, lo, lo+sz -1, Math.min(lo+sz+sz-1, N-1));
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo; j = mid + 1;
		
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for (int k = lo; k <= hi; k++)
		if(lo > mid)		a[k] = aux[j++];
		else if (j > hi)	a[k] = aux[i++];
		else if (less(a[i],a[j])a[k] = aux[i++];
		else			a[k] = aux[j++];
	}
	private static boolean less(Comparable w, Comparable v) {
		return w.compareTo(v) < 0;
	}
}
