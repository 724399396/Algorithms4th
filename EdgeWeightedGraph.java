public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Edge>();
	}

	public EdgeWeightedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			this.addEdge(new Edge(v, w, weight));
		}
		
	}
	
	public int V() { return V; }
	public int E() { return E; }

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		Bag<Edge> b = new Bag<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adj[v])
				if(e.other(v) > v)
					b.add(e);
		return b;
	}
	
	public String toString() {
		String s = "";
		s += V + " vertexs, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (Edge w : adj(v))
				s += w + "  ";
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph EWG = new EdgeWeightedGraph(new In(args[0]));
		StdOut.println(EWG);
	}
}
