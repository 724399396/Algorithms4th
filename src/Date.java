public class Date implements Comparable<Date> {
	private final int month;
	private final int day;
	private final int year;
	public Date(int m, int d, int y) {
		month = m; day = d; year = y;
	}
	public Date(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
	}
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return year;
	}
	public String toString() {
		return month() + "/" + day()
			+"/" + year();
	}
	@Override public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (x.getClass() != this.getClass()) return false;
		Date that = (Date)x;
		if (this.day != that.day) 	return false;
		if (this.month != that.month) 	return false;
		if (this.year != that.year)	return false;
		return true;
	}
	public int compareTo(Date that) {
		if (this.year > that.year) return +1;
		if (this.year < that.year) return -1;
		if (this.month > that.month) return +1;
		if (this.month < that.month) return -1;
		if (this.day > that.day) return +1;
		if (this.day < that.day) return -1;
		return 0;
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		Date date = new Date(m, d, y);
		Date date2 = new Date(args[3]);
		StdOut.println(date);
		StdOut.println(date2);
	}
}
