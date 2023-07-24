package WeeklyContest351;

public class BeautifulPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeautifulPairs obj = new BeautifulPairs();
		int[] nums = {2,5,1,4 };
		System.out.println(obj.countBeautifulPairs(nums));
	}

	public int countBeautifulPairs(int[] nums) {

		int len = nums.length;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int sum = nums[i];
			int x=0;
			while (sum != 0) {
				x = sum % 10;
				
				sum = sum / 10;
			}
			int firstI = x;
			for (int j = i + 1; j < len; j++) {
				int lastJ = nums[j] % 10;

				if (findGCD(firstI, lastJ) == 1) {
					ans++;
				}
			}
		}
		return ans;
	}

	public int findGCD(int a, int b) {

		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}
}
