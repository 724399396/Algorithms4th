public class LRS {
	public static void main(String[] args) {
		String text = StdIn.readAll().replaceAll("\\s+", " ").trim();
		SuffixArray sa = new SuffixArray(text);
		int N = sa.length();
		String lrs = "";
		for (int i = 1; i < N; i++) {
			int length = sa.lcp(i);
			if (length > lrs.length()) {
				StdOut.println(length);
				lrs = sa.select(i).substring(0, length);
			}
		}
		StdOut.println(lrs);
	}
}
