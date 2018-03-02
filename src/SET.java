import java.util.Iterator;
public class SET<T> implements Iterable<T> {
	private int N;
	private int M = 16;
	private T[] items;
	public SET() {
		items = (T[]) new Object[M];
	}
	public SET(int cap) {
		items = (T[]) new Object[cap];
	}
	private int hash(T t) {
		return (t.hashCode() & 0x7fffffff) % M;
	}
	private void resize(int cap) {
		SET<T> set = new SET<T>(cap);
		for (int i = 0; i < M; i++)
			if (items[i] != null)
				set.add(items[i]);
		N = set.N;
		M = set.M;
		items = set.items;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void add(T t) {
		if (N >= M/2) resize(2*M);
		int i = hash(t);
		for ( ; items[i] != null; i = (i + 1) % M)
			if (t.equals(items[i]))
				return;
		items[i] = t;
		N++;
	}
	public boolean contains(T t) {
		if (t == null) return false;
		int i = hash(t);
		for ( ; items[i] != null; i = (i+1)%M)
			if (t.equals(items[i]))
				return true;
		return false;
	}
	public void delete(T t) {
		if (t == null) return;
		int i = hash(t);
		while (!items[i].equals(t))
			i = (i + 1) % M;
		items[i] = null;
		i = (i + 1) % M;
		while (items[i] != null) {
			T toRedo = items[i];
			items[i] = null;
			N--;
			add(toRedo);
			i = (i + 1) % M;
		}
		N--;
	}
	public Iterator<T> iterator() {
		Queue<T> queue = new Queue<T>();
		for (int i = 0; i < M; i++)
			if (items[i] != null)
				queue.enqueue(items[i]);
		return queue.iterator();
	}
}
