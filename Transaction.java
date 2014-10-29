public class Transaction implements Comparable<Transaction> {
	String custName;
	Date date;
	double amount;
	public Transaction(String who, Date when,
		double amount) {
			custName = who;
			date = when;
			this.amount = amount;
		}
	public Transaction(String transaction) {
		String[] fields = transaction.split(" ");
		custName = fields[0];
		date = new Date(fields[1]);
		amount = Double.parseDouble(fields[2]);
	}
	public String who() { return custName;}
	public Date when()  { return date; }
	public double amount() { return amount; }
	public String toString() { 
		return String.format("%-10s ", custName) + date + String.format(" %6.2f", amount);
	}
	public boolean equals(Object that) {
		if (! (that instanceof Transaction))
			return false;
		Transaction t = (Transaction) that;
		if (custName.equals(t.who()))
			if (date.equals(t.when()))
				if(amount == t.amount)
					return true;
		return false;

	}
	public int compareTo(Transaction that) {
		if ( amount != that.amount)
			return amount - that.amount() < 0 ? -1 : 1;
		return 0;
	}
	public static void main(String[] args) {
		Transaction t = new Transaction("Liwei", new Date(9, 24, 2014), 100.00);
		Transaction t2 = new Transaction("A 9/24/2014 120.00");
		StdOut.println(t.compareTo(t2));
		StdOut.println(t2);
	}
}
