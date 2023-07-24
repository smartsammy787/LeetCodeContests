package BiWeekly109;

import java.util.Arrays;

public class VisitArrayPosToMaxScore {

	
	//2786
	public long maxScore(int[] nums, int x) {
		int n = nums.length;
		long dp[][] = new long[n + 1][2];
		for (long[] d : dp) {
			Arrays.fill(d, -1);
		}

		return helper(0, nums, x, (nums[0] % 2 == 0) ? 0 : 1, dp);
	}

	private long helper(int idx, int nums[], int pen, int prev, long[][] dp) {

		int n = nums.length;

		if (idx == n) {
			return 0;
		}
		if (dp[idx][prev] != -1) {
			return dp[idx][prev];
		}

		long pick = Long.MIN_VALUE;
		long notPick = Long.MIN_VALUE;

		if (nums[idx] % 2 == 0) {
			if (prev == 0) {
				pick = nums[idx] + helper(idx + 1, nums, pen, (nums[idx] % 2 == 0) ? 0 : 1, dp);
			} else {
				pick = nums[idx] - pen + helper(idx + 1, nums, pen, (nums[idx] % 2 == 0) ? 0 : 1, dp);
			}

		} else {
			if (prev == 0) {
				pick = nums[idx] - pen + helper(idx + 1, nums, pen, (nums[idx] % 2 == 0) ? 0 : 1, dp);
			} else {
				pick = nums[idx] + helper(idx + 1, nums, pen, (nums[idx] % 2 == 0) ? 0 : 1, dp);
			}
		}

		notPick = helper(idx + 1, nums, pen, prev, dp);

		dp[idx][prev] = Math.max(pick, notPick);

		return dp[idx][prev];

	}
}
