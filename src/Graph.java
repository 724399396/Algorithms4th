public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	public Graph(int V) {
		this.V = V; this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public Graph(Graph G) {
		this(G.V());
		this.E = G.E();
		for (int v = 0; v < G.V(); v++) {
	      		Stack<Integer> reverse = new Stack<Integer>();		
			for (int w : G.adj[v])
				reverse.push(w);	
			for (int w : reverse)
				adj[v].add(w);	
		}				
	}
	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
