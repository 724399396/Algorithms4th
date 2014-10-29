import java.util.Random;
import java.math.BigInteger;
public class RabinKarp {
	private String pat;	// needed only for las Vegas
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;	// R^(M-1) % Q

	public RabinKarp(String pat) {
		this.pat = pat;	// needed only for las Vegas
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		for (int i = 1; i <= M-1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}
  	// Las Vegas version: does pat[] match txt[i..i-M+1] ?
	private boolean check(String txt, int i) {
		for (int j = 0; j < M; j++)
			if(pat.charAt(j) != txt.charAt(i + j))
				return false;
		return true;
	}
	 // Monte Carlo version: always return true
	private boolean check(int i) {
		return true;
	}
	
	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}
	public int search(String txt) {
		int N = txt.length();
		if ( N < M) return N;
		long txtHash = hash(txt, M);
		if (patHash == txtHash && check(txt, 0)) 
			return 0;
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM*txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			if (patHash == txtHash)
				if(check(txt, i - M + 1)) return i - M + 1;
		}
		return N;
	}
	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}
	public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        // from brute force search method 1
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
