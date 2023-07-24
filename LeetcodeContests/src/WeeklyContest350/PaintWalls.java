package WeeklyContest350;

import java.util.Arrays;

public class PaintWalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int paintWalls(int[] cost, int[] time) {

		int n = cost.length;

		int dp[][] = new int[n + 1][n + 1];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		return helper(0, n, cost, time, dp);
	}

	int helper(int idx, int wallsLeft, int[] cost, int time[], int[][] dp) {

		if (idx >= cost.length) {
			if (wallsLeft > 0) {
				return (int) 1e9;
			} else {
				return 0;
			}

		}

		if (wallsLeft <= 0) {
			return 0;
		}

		if (dp[idx][wallsLeft] != -1) {
			return dp[idx][wallsLeft];
		}

		int notTake = 0 + helper(idx + 1, wallsLeft, cost, time, dp);
		int take = helper(idx + 1, wallsLeft - time[idx] - 1, cost, time, dp) + cost[idx];
		dp[idx][wallsLeft] = Math.min(take, notTake);

		return dp[idx][wallsLeft];
	}
}
