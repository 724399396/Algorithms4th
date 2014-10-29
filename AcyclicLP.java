public class AcyclicLP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];

		for (int v = 0; v < G.V(); v++)
			distTo[v] = 0;

		Topological top = new Topological(G);
		for (int v : top.order())
			relax(G, v);
	}
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] < distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		AcyclicLP aLP = new AcyclicLP(G, s);
		
		for (int v = 0; v < G.V(); v++) {
			if (aLP.hasPathTo(v)) {
				System.out.format("%s to %s (%.2f) :  ", s, v, aLP.distTo(v));
				for (DirectedEdge e : aLP.pathTo(v))
					StdOut.print(e + "   ");		
				StdOut.println();
			}
		}
	}
}
