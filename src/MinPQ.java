public class MinPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	public MinPQ(int min) {
		pq = (Key[]) new Comparable[min];
	}
	public MinPQ() {
		pq = (Key[]) new Comparable[1];
	}
	private void resize(int max) {
		Key[] rpq = (Key[]) new Comparable[max];
		for (int i = 1; i <= N; i++) 
			rpq[i] = pq[i];
		pq = rpq;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void insert(Key v) {
		if (N+1 == pq.length) resize(pq.length*2);
		pq[++N] = v;
		swim(N);
	}
	public Key  delMin() {
		Key min = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		skin(1);
		if (N+1 == pq.length/4) resize(pq.length/2);
		return min;
	}
	public void swim(int k) {
		while (k > 1 && greater(k/2,k)){ 
			exch(k/2, k);
			k = k/2;
		}
	}
	public void skin(int k) {
		while (2*k <= N) {
			int j = 2 * k;
			if (j < N && greater(j, j+1)) j++;
			if (!greater(k, j)) break;
			exch(k,j);
			k = j;
		}
	}
	public boolean greater(int i, int j) {
		return pq[i].compareTo(pq[j]) > 0;
	}
	public void exch(int w, int v) {
		Key t = pq[w]; pq[w] = pq[v]; pq[v] = t;
	}
	public static void main(String[] args) {
		MinPQ<Integer> m = new MinPQ();
		m.insert(2);
		m.insert(10);
		m.insert(3);
		m.insert(5);
		m.insert(7);
		m.insert(11);
		StdOut.println(java.util.Arrays.toString(m.pq));
		StdOut.println(m.delMin());
		StdOut.println(m.delMin());
		StdOut.println(m.delMin());
	}
}
