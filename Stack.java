import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
	private Node first;	// 栈顶，最近添加的元素
	private int N;		// 元素数量
	private class Node {
		//定义了结点的嵌套类
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; } // 或: N == 0
	public int size()  { return N; }
	public void push(Item item) {
		// 向栈顶增加元素
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	public Item pop() {
		// 从栈顶删除元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek() {
		return first.item;
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
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();	
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack");
	}
}
