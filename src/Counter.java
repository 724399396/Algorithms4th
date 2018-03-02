public class Counter {
	private int count ;
	private final String id;
	public Counter(String id) {
		this.id = id;
	}
	public void increment() {
		count++;
	}
	public int tally() {
		return count;
	}
	public String toString() {
		return count + ": " + id;
	}
	public static void main(String[] args) {
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		
		heads.increment();
		heads.increment();
		tails.increment();

		StdOut.println(heads + " " + tails);
		StdOut.println(heads.tally() + tails.tally());
	}
}