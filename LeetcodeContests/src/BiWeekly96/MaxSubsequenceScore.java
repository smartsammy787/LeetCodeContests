package BiWeekly96;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 3, 3, 2 };
		int[] nums2 = { 2, 1, 3, 4 };
		int k = 3;

		MaxSubsequenceScore obj = new MaxSubsequenceScore();

		System.out.println(obj.maxScore(nums1, nums2, k));
	}

	public long maxScore(int[] nums1, int[] nums2, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
//min at top
		int arr[][] = new int[nums1.length][2];

		for (int i = 0; i < nums1.length; i++) {
			arr[i][0] = nums1[i];
			arr[i][1] = nums2[i];
		}

		Arrays.sort(arr, (a, b) -> b[1] - a[1]); // max to min
		long min = Integer.MAX_VALUE;
		long sum = 0;
		long res = 0;
		for (int i = 0; i < nums1.length; i++) {
			pq.add(arr[i][0]);
			sum += arr[i][0];
			if (pq.size() > k) {
				sum = sum - pq.poll();
			}
			if (pq.size() == k) {
				res = Math.max(res, sum * arr[i][1]);
			}

		}

		return res;
	}

}
