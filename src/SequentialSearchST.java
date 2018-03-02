public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	public int size() {
		return N;
	}
	public Value get(Key key) {
		for (Node x  = first; x!=null; x = x.next) 
			if (key.equals(x.key))
				return x.val;	// get!
		return null;		        // Not get
	}
	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = val;	// update
				return;
			}
		first = new Node(key, val, first);	// insert new 
		N++;
	}
	public void delete(Key key) {
		first = delete(first, key);
	}
	public Node delete(Node x, Key key) {
		if (x == null) return null;
		if (key.equals(x.key)) return x.next;
		x.next = delete(x.next, key);
		return x;
	}
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}
	public static void main(String[] args) {
		SequentialSearchST<String,Integer> st;
		st = new SequentialSearchST<>();
		for (int i=0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for(String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
