import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
	private Node first;	// 只想最早添加的结点的链接
	private Node last;	// 指向最近添加的结点的链接
	private int N;		// 队列中的元素数量
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; } // or: N == 0
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		// 向表尾添加元素
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else	       oldLast.next = last;
		N++;
	}
	public Item dequeue() {
		//从表头删除元素
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove() {}
	}
	public static void main(String[] args) {
		//创建一个队列并操作字符串入列或出列
		Queue<String> q = new Queue<String>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}
