package WeeklyContest332;

import java.util.Arrays;

public class CountFairPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountFairPairs obj = new CountFairPairs();
		int[] nums = { 0, 1, 7, 4, 4, 5 };
		int lower = 3;
		int upper = 6;
		System.out.println(obj.countFairPairs(nums, lower, upper));
	}

	public long countFairPairs(int[] nums, int lower, int upper) {

		long ans = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			int lowerBound = findLowerBound(nums[i], i + 1, nums, lower);
			//returns the last index till which sum will be less than lower value
			int upperBound = findUpperBound(nums[i], i + 1, nums, upper);
			// returns the last index after which sum will be greater than upper bound val
			ans += (upperBound - lowerBound);
		}
		return ans;
	}

	int findLowerBound(int curnum, int startIdx, int arr[], int target) {

		int endIdx = arr.length - 1;

		while (startIdx <= endIdx) {

			int mid = startIdx + (endIdx - startIdx) / 2;

			if (arr[mid] < target - curnum) {	//diff
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}

		}

		return startIdx - 1;
	}

	int findUpperBound(int curnum, int startIdx, int arr[], int target) {

		int endIdx = arr.length - 1;

		while (startIdx <= endIdx) {

			int mid = startIdx + (endIdx - startIdx) / 2;

			if (arr[mid] <= target - curnum) {	//diff
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}

		}

		return startIdx - 1;
	}

}
