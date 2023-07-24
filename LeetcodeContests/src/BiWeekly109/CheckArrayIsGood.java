package BiWeekly109;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckArrayIsGood {

	public boolean isGood(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {

			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		int max = nums[len - 1];

		if (len != (max + 1)) {
			return false;
		}

		for (int i = 1; i < max; i++) {
			if (!map.containsKey(i)) {
				return false;
			} else {
				if (map.get(i) != 1) {
					return false;
				}
			}
		}
		if (map.get(max) != 2) {
			return false;
		}

		return true;
	}
}
