package BiWeeklyContest92;

public class DiffBWOneZeroInRowCol {

	public int[][] onesMinusZeros(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int rowOnes[] = new int[m];
		int rowZeroes[] = new int[m];
		int colOnes[] = new int[n];
		int colZeroes[] = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					rowOnes[i] += 1;
					colOnes[j] += 1;
				}

				if (grid[i][j] == 0) {
					rowZeroes[i] += 1;
					colZeroes[j] += 1;
				}
			}
		}

		int[][] diff = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				diff[i][j] = rowOnes[i] + colOnes[j] - rowZeroes[i] - colZeroes[j];
			}
		}

		return diff;
	}
}
