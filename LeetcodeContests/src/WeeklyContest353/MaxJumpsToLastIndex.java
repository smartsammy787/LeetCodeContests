package WeeklyContest353;

import java.util.Arrays;

public class MaxJumpsToLastIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxJumpsToLastIndex obj=new MaxJumpsToLastIndex();
		int []nums = {1,3,6,4,1,2};
		int target = 2;
		System.out.println(obj.maximumJumps(nums, target));
	}

	public int maximumJumps(int[] nums, int target) {
		int len = nums.length;
		int dp[] = new int[len];// dp signifies the max steps to reach that idx
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		for (int i = 1; i < len; i++) {

			for (int j = 0; j < i; j++) {

				if (Math.abs(nums[j] - nums[i]) <= target) {

					if (dp[j] != Integer.MIN_VALUE) {
						//dont acces idx if previously u couldnt reach this idx
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
		}

		return dp[len - 1] == Integer.MIN_VALUE ? -1 : dp[len - 1];
	}

}
