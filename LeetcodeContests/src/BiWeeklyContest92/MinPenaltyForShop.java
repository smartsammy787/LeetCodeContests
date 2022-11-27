package BiWeeklyContest92;

public class MinPenaltyForShop {
	
	public int bestClosingTime(String customers) {
		int len = customers.length();
		int yAfter[] = new int[len + 1];
		int nBefore[] = new int[len + 1];

		yAfter[yAfter.length - 1] = 0;
		for (int i = yAfter.length - 2; i >= 0; i--) {
			if (customers.charAt(i) == 'Y') {
				yAfter[i] = yAfter[i + 1] + 1;
			} else {
				yAfter[i] = yAfter[i + 1];
			}

		}
		nBefore[0] = 0;
		for (int i = 1; i < nBefore.length; i++) {
			if (customers.charAt(i - 1) == 'N') {
				nBefore[i] = nBefore[i - 1] + 1;
			} else {
				nBefore[i] = nBefore[i - 1];
			}
		}

		int minPen = Integer.MAX_VALUE;
		int minIdx = Integer.MAX_VALUE;
		int cur = 0;
		for (int i = 0; i < len + 1; i++) {

			cur = yAfter[i] + nBefore[i];
			if (cur < minPen) {
				minPen = cur;

				minIdx = i;

			}
		}

		return minIdx;

	}
}
