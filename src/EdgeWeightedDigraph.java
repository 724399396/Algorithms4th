public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}

	public EdgeWeightedDigraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int e = 0; e < E; e++) {
			int from = in.readInt();
			int to = in.readInt();
			double weight = in.readDouble();
			addEdge(new DirectedEdge(from, to, weight));
		}	
	}

	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++)
			for (DirectedEdge e : adj[v])
				bag.add(e);
		return bag;
	}
	public String toString() {
		String s1 = String.format("%s vertexs, %s edges\n", V, E);
		StringBuilder sb = new StringBuilder(s1);
		for (int v = 0; v < V; v++) {
			sb.append(v);
			sb.append(" : ");
			for (DirectedEdge de : adj(v)) {
				sb.append(de.toString());
				sb.append("   ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		EdgeWeightedDigraph EWD = new EdgeWeightedDigraph(new In(args[0]));
		StdOut.println(EWD);
	}
}
