package BiWeekly96;

public class MinOpMakeArrayEqualII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinOpMakeArrayEqualII obj=new MinOpMakeArrayEqualII();
		int []nums1 = {1,2,3,4};
		int []nums2 = {1,2,3,4};
		int k = 0;
		System.out.println(obj.minOperations(nums1, nums2, k));
	}

	public long minOperations(int[] nums1, int[] nums2, int k) {
		long total1 = 0;
		long total2 = 0;
		long res = 0;
		long inc = 0;
		long dec = 0;
		for (int i = 0; i < nums1.length; i++) {
			total1 += nums1[i];
			total2 += nums2[i];
		}

		if (total1 != total2) {
			return -1;
		}

		if (k == 0) {
			return -1;
		}

		for (int i = 0; i < nums1.length; i++) {
			long diff = nums1[i] - nums2[i];
			if (diff % k != 0) {
				return -1;
			}
			res += Math.abs(diff / k);

		}

		return res / 2;
	}
}
