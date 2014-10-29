public class EdgeWeightedDirectedCycle {
	private boolean[] marked;
	private DirectedEdge[] edgeTo;
	private Stack<DirectedEdge> cycle;
	private boolean[] onStack;

	public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G) {
		onStack = new boolean[G.V()];
		marked = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v]) dfs(G, v);
	}
	private void dfs(EdgeWeightedDigraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (this.hasCycle()) return;
			else if (!marked[w]) {
				edgeTo[w] = e;
				dfs(G, w);
			}
			else if(onStack[w]) {
				cycle = new Stack<DirectedEdge>();
				while (e.from() != w) {
					cycle.push(e);
					e = edgeTo[e.from()];
				}
				cycle.push(e);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<DirectedEdge> cycle() {
		return cycle;
	}
}
