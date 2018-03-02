public class SymbolDigraph {
	private SeparateChainingHashST<String,Integer> st;
	private String[] keys;
	private Digraph G;

	public SymbolDigraph(String stream, String sp) {
		st = new SeparateChainingHashST<String,Integer>();
		In in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for (int i = 0; i < a.length; i++)
				if(!st.contains(a[i]))
					st.put(a[i], st.size());
		}
		keys = new String[st.size()];
		for (String name : st.keys())
			keys[st.get(name)] = name;

		G = new Digraph(st.size());
		in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));
		}
	}
	public boolean contains(String s) { return st.contains(s); }
	public int index(String s) { return st.get(s); }
	public String name(int index) { return keys[index]; }
	public Digraph G() { return G; }

}
