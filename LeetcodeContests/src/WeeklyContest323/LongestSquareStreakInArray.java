package WeeklyContest323;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSquareStreakInArray {
	public int longestSquareStreak(int[] nums) {

		Arrays.sort(nums);

		int max = nums[nums.length - 1];

		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		boolean visited[] = new boolean[nums.length];
		int maxans = -1;
		int curans = -1;
		for (int i = 0; i < nums.length; i++) {
			curans = -1;
			if (!visited[i]) {
				visited[i] = true;

				int num = nums[i];
				while (num < max) {
					num = num * num;
					if (map.containsKey(num)) {
						if (curans == -1) {
							curans = 1;
						} else {
							curans++;
						}

						visited[map.get(num)] = true;
					} else {
						break;
					}
				}
				maxans = Math.max(curans, maxans);
			}
		}

		return maxans == -1 ? -1 : maxans + 1;
	}
}
