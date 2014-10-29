public class KruskalMST {
	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) pq.insert(e);
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
		
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)) continue;
			uf.union(v,w);
			mst.enqueue(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : mst)
			weight += e.weight();
		return weight;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G;
		G = new EdgeWeightedGraph(in);

		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges())
			StdOut.println(e);
		StdOut.println(mst.weight());
	}
}
