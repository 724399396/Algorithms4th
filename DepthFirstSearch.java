public class DepthFirstSearch {
	private boolean[] marked;
	private in count;

	public DepthFirstSearch(Graph G, int s) {
		market = new boolean[G.V()];
		dfs(G, s);
	}
	private void dfs(Graph G, int V) {
		marked[v] = true;
		count++;
		for (int w : G.adj(V))
			if (!marked[w]) dfs(G,w);
	}

	public boolean marked(int w) {
		return marked[w];
	}
	public int count() {
		return count; 
	}
}
