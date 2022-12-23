package WeeklyContest323;

import java.util.Arrays;

public class DeleteGreatesValueInRow {
	public int deleteGreatestValue(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int curmax = 0;
		int ans = 0;
		for (int i = 0; i < m; i++) {
			Arrays.sort(grid[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			curmax = 0;
			for (int j = 0; j < m; j++) {
				curmax = Math.max(curmax, grid[j][i]);
			}
			ans += curmax;
		}
		return ans;
	}
}
