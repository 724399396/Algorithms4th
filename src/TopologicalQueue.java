public class ToplogicalQueue {
	private Queue<Integer> order;
	private int[] indegree;
	private int[] rank;
	private int count;

	public TopologicalQueue(Digraph G) {
		indegree = new int[G.V()];
		rank = new int[G.V()];
		order = new Queue<Integer>();

		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				indegree[w]++;
			}
		}

		Queue<Integer> queue = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++)
			if (indegree[v] == 0) queue.enqueue(v);

		for (int j = 0; !queue.isEmpty(); j++) {
			int v = queue.dequeue();
			order.enqueue(v);
			rank[v] = count++;
			for (int w : G.adj(v)) {
				indegree[w]--;
				if(indegree[w] == 0) queue.enqueue(w);
			}
		}

		public boolean isDAG() {
			for(int v = 0; v < indegree.length; v++)
				if(indegree[v] != 0) return false;
			return true;
		}

		public Iterable<Integer> order() {
			return order;
		}
		public int rank(int v) {
			return rank[v];
		}

		private boolean check(Digraph G) {
			if(isDAG()) {
				boolean[] found = new boolean[G.V()];
				for (int i = 0; i < G.V(); i++) {
					found[rank(i)] = true;
				}
				for (int i = 0; i < G.V(); i++) {
					if(!found[i]) {
						System.err.println("No Vertext with rank " + i;
						return;
					}
				}

				for (int v = 0; v < G.V(); v++) {
					for (int w : G.adj(v)) {
						if(rank(v) > rank(w) {
							System.err.printf("%d-%d: rank(%d) = %d, rank(%d) = %d\n", v, w, v, rank(v), w, rank(w));
							return false;
						}
					}
				}

				int r = 0;
				for (int v : order()) {
					if (rank(v) != r) {
						System.err.println("order() and rank() inconsistent");
						return false;
					}
					r++;
				}
			}
		}
		return true;
	}
}
