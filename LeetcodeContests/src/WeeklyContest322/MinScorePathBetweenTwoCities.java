package WeeklyContest322;

public class MinScorePathBetweenTwoCities {

	class UF {

		int arr[];
		int size[];

		int count;

		public UF(int n) {
			arr = new int[n];
			size = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
				size[i] = 1;
			}
			count = n;
		}

		void union(int p, int q) {
			int rootp = findRoot(p);
			int rootq = findRoot(q);

			if (rootp == rootq)
				return;
			if (size[rootp] < size[rootq]) {
				arr[rootp] = rootq;
				size[rootq] += size[rootp];
			} else {
				arr[rootq] = rootp;
				size[rootp] += size[rootq];

			}
			count--;

		}

		int findRoot(int p) {
			while (p != arr[p]) {
				arr[p] = arr[arr[p]]; // path compression
				p = arr[p];
			}

			return p;
		}

		boolean isConnected(int p, int q) {
			return findRoot(p) == findRoot(q);
		}

		public long[] componentArr() {

			long[] comp = new long[arr.length];
			for (int i = 0; i < arr.length; i++) {
				comp[arr[i]]++;
			}
			return comp;
		}

	}

	public int minScore(int n, int[][] roads) {
		UF uf = new UF(n + 1);
		int len = roads.length;
		for (int i = 0; i < len; i++) {
			uf.union(roads[i][0], roads[i][1]);
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (uf.isConnected(1, roads[i][0]) || uf.isConnected(1, roads[i][1])) {
				ans = Math.min(ans, roads[i][2]);
			}
		}

		return ans;
	}
}
