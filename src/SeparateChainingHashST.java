public class SeparateChainingHashST<Key, Value> {
	private int N;
	private int M;
	private SequentialSearchST<Key,Value>[] st;

	public SeparateChainingHashST() {
		this(997);
	}
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++)
			st[i] = new SequentialSearchST();
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key,Value val) {
		st[hash(key)].put(key,val);
		N++;
	}
	
	public int size() {
		return N;
	}

	public boolean contains(Key key) {
		if (key == null) return false;
		return get(key) != null;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = 0; i < M; i++)
			for (Key x : st[i].keys())
				queue.enqueue(x);
		return queue;
	}

	public static void main(String[] args) {
		SeparateChainingHashST<Integer,Integer> st
			= new SeparateChainingHashST<>();
		st.put(1,2);
		st.put(3,4);
		st.put(5,6);

		StdOut.println(st.size());
		
		for (Integer i : st.keys())
			StdOut.print(i + "   ");
		StdOut.println();
	}
}
