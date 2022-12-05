package WeeklyContest321;

public class AppendCharToStringToMakeSubsequence {

	public int appendCharacters(String s, String t) {

		int i = 0;
		int j = 0;

		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				j++;
			}
			i++;
		}
		return t.length() - j;
	}
}
