package WeeklyContest350;

import java.util.Arrays;

public class SpecialPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpecialPermutations obj = new SpecialPermutations();
		int nums[] = { 2, 3, 6 };
		System.out.println(obj.specialPerm(nums));
	}

	int mod = 1_000_000_007;

	public int specialPerm(int[] nums) {
		//BITMASKING DP PROBLEM
		int n = nums.length;
		int dp[][] = new int[n + 1][(1 << n) + 6];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		/*
		 * int total=0; for(int i=0;i<nums.length;i++){ total+=helper(i,(1<<i),dp,nums);
		 * total%=mod; }
		 */
		return helper(-1, 0, dp, nums);

	}

	int helper(int prevIdx, int mask, int dp[][], int[] nums) {

		if (mask == (1 << nums.length) - 1) {
			return 1;
		}

		if (dp[prevIdx + 1][mask] != -1) {
			return dp[prevIdx + 1][mask];
		}
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((mask & (1 << i)) == 0) {
				if (prevIdx == -1 || (nums[prevIdx] % nums[i] == 0) || (nums[i] % nums[prevIdx] == 0)) {
					total += helper(i, mask | (1 << i), dp, nums);
					total %= mod;
				}
			}
		}

		dp[prevIdx + 1][mask] = total;
		return dp[prevIdx + 1][mask];
	}

}
