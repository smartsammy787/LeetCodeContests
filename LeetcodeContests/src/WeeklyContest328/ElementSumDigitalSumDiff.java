package WeeklyContest328;

public class ElementSumDigitalSumDiff {
//2535
	public int differenceOfSum(int[] nums) {
		int esum = 0;
		int dsum = 0;
		for (int i = 0; i < nums.length; i++) {
			esum += nums[i];
			int curnum = nums[i];
			while (curnum != 0) {
				dsum += curnum % 10;
				curnum = curnum / 10;
			}

		}

		return esum - dsum;

	}
}
