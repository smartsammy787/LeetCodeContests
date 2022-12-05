package WeeklyContest321;

public class PivotInteger {

	public int pivotInteger(int n) {

		for (int i = 1; i <= n; i++) {
			int sum = 0;

			for (int j = i; j <= n; j++) {
				sum += j;
			}

			if (sum == (i * (i + 1)) / 2) {
				return i;
			}
		}

		return -1;
	}
}
