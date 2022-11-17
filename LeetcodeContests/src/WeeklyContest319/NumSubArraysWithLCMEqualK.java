package WeeklyContest319;
public class NumSubArraysWithLCMEqualK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumSubArraysWithLCMEqualK obj = new NumSubArraysWithLCMEqualK();
		int[] nums = { 3, 6, 2, 7, 1 };
		int k = 6;
		System.out.println(obj.subarrayLCM(nums, k));
	}

	public int subarrayLCM(int[] nums, int k) {

		int len = nums.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			int temp = nums[i];
			for (int j = i; j < len; j++) {
				temp = lcm(temp, nums[j]);
				if (temp == k) {
					res++;
				}
			}
		}
		return res;
	}

	private int lcm(int num1, int num2) {
		int lcm;
		lcm = (num1 > num2) ? num1 : num2;
		while (true) {
			if (lcm % num1 == 0 && lcm % num2 == 0) {

				break;
			}
			++lcm;
		}
		return lcm;
	}

}
