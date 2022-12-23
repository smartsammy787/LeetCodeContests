package WeeklyContest324;

public class CycleLengthQueriesInTree {

	public int[] cycleLengthQueries(int n, int[][] queries) {

		int m = queries.length;
		int ans[] = new int[m];
		for (int i = 0; i < m; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			ans[i]++;
			while (x != y) {
				if (x > y) {
					x = x / 2;
				} else {
					y = y / 2;
				}
				ans[i]++;
			}
		}

		return ans;
	}
}
