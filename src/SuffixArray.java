public class SuffixArray {
	private final String[] shuffixes;
	private final int N;

	public SuffixArray(String s) {
		N = s.length();
		shuffixes = new String[N];
		for (int i = 0; i < N; i++)
			shuffixes[i] = s.substring(i);
		Quick3way.sort(shuffixes);
	}

	public int length() { return N; }
	public String select(int i) { return shuffixes[i]; }
	public int index(int i) { return N - shuffixes[i].length(); }
	private static int lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i)) return i;
		return N;
	}

	public int lcp(int i) {
		return lcp(shuffixes[i], shuffixes[i-1]);
	}

	public int rank(String key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(shuffixes[mid]);
			if	(cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	   public static void main(String[] args) {
	           String s = StdIn.readAll().replaceAll("\\s+", " ").trim();
		   SuffixArray suffix = new SuffixArray(s);

            	   // StdOut.println("rank(" + args[0] + ") = " + suffix.rank(args[0]));
		
	           StdOut.println("  i ind lcp rnk select");
	           StdOut.println("---------------------------");

	           for (int i = 0; i < s.length(); i++) {
	                  int index = suffix.index(i);
 	                  String ith = "\"" + s.substring(index, Math.min(index + 50, s.length())) + "\"";
	                  assert s.substring(index).equals(suffix.select(i));
   	                  int rank = suffix.rank(s.substring(index));
	                  if (i == 0) {
	                  StdOut.printf("%3d %3d %3s %3d %s\n", i, index, "-", rank, ith);
		 	  }
             		  else {
	                       int lcp = suffix.lcp(i);
	                       StdOut.printf("%3d %3d %3d %3d %s\n", i, index, lcp, rank, ith);
	                   }
	         }
	}
}
