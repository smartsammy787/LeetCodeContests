package BiWeekly109;

import java.util.Arrays;

public class WaysIntegerAsSumOfPowers {

	int mod = 1_000_000_007;

	public int numberOfWays(int n, int x) {

		int dp[][] = new int[n + 1][n + 1];
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		return helper(1, n, x, dp);
	}

	int helper(int i, int req, int x, int dp[][]) {

		if (req == 0) {
			return 1;
		}
		int num = (int) Math.pow(i, x);
		if (num > req) {
			return 0;
		}

		if (dp[i][req] != -1) {
			return dp[i][req];
		}

		int take = helper(i + 1, req - num, x, dp) % mod;

		int notTake = helper(i + 1, req, x, dp) % mod;

		return dp[i][req] = (take + notTake) % mod;
	}

	public static void main(String[] args) {

		WaysIntegerAsSumOfPowers obj = new WaysIntegerAsSumOfPowers();

		System.out.println(obj.numberOfWays(4, 1));
	}
}
