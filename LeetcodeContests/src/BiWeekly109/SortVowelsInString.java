package BiWeekly109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInString {

	public String sortVowels(String s) {

		StringBuilder sb = new StringBuilder();
		int len = s.length();
		List<Character> l = new ArrayList();
		for (int i = 0; i < len; i++) {
			if (isVowel(s.charAt(i))) {
				l.add(s.charAt(i));
			}
		}

		Collections.sort(l);
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (isVowel(s.charAt(i))) {
				sb.append(l.get(j++));
			} else {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}

	boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		}
		return false;
	}
}
