public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	public Key  delMax() {
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		skin(1);
		return max;
	}
	public void swim(int k) {
		while (k > 1 && less(k/2,k)){ 
			exch(k/2, k);
			k = k/2;
		}
	}
	public void skin(int k) {
		while (2*k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k,j);
			k = j;
		}
	}
	public boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	public void exch(int w, int v) {
		Key t = pq[w]; pq[w] = pq[v]; pq[v] = t;
	}
	public static void main(String[] args) {
		MaxPQ<String> m = new MaxPQ<>(20);
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("*"))
				System.out.println(m.delMax());
			else
				m.insert(s);
		}
	}
}
