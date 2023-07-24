package WeeklyContest350;

import java.util.Arrays;

public class FindValueOfPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findValueOfPartition(int[] nums) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			min = Math.min(min, nums[i] - nums[i - 1]);
		}
		return min;
	}

}
