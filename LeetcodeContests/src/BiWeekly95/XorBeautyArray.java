package BiWeekly95;

public class XorBeautyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int xorBeauty(int[] nums) {
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}

		return sum;
	}

}
