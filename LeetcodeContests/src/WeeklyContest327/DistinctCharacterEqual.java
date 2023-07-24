package WeeklyContest327;

import java.util.HashMap;
import java.util.Map;

public class DistinctCharacterEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DistinctCharacterEqual obj=new DistinctCharacterEqual();
		String word1 = "abcc";
		String word2 = "aab";
		System.out.println(obj.isItPossible(word1, word2));
	}

	public boolean isItPossible(String word1, String word2) {

		Map<Character, Integer> map1 = new HashMap();
		Map<Character, Integer> map2 = new HashMap();

		for (char c : word1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		for (char c : word2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}

		for (char i = 'a'; i <= 'z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				if (!map1.containsKey(i) || !map2.containsKey(j)) {
					continue;
				}

				map1.put(j, map1.getOrDefault(j, 0) + 1);
				map1.put(i, map1.getOrDefault(i, 0) - 1);// putting j in map1
				if (map1.get(i) == 0) {
					map1.remove(i);
				}

				map2.put(i, map2.getOrDefault(i, 0) + 1);
				map2.put(j, map2.getOrDefault(j, 0) - 1);// putting i in map2
				if (map2.get(j) == 0) {
					map2.remove(j);
				}

				if (map1.size() == map2.size()) {
					return true;
				}

				map1.put(i, map1.getOrDefault(i, 0) + 1);
				map1.put(j, map1.getOrDefault(j, 0) - 1);// putting i in map1 and remove j
				if (map1.get(j) == 0) {
					map1.remove(j);
				}

				map2.put(j, map2.getOrDefault(j, 0) + 1);
				map2.put(i, map2.getOrDefault(i, 0) - 1);// putting j in map2 and remove i
				if (map2.get(i) == 0) {
					map2.remove(i);
				}

			}

		}

		return false;
	}

}
