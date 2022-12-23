package WeeklyContest324;

public class SmallestValueAfterReplacingSumPrimeFactors {

	public int smallestValue(int n) {

		int min = Integer.MAX_VALUE;
		int val = 0;
		int prev = n;
		do {
			prev = n;
			val = primeFactor(n);
			min = Math.min(min, val);
			n = val;
		} while (min != prev);

		return min;
	}

	int primeFactor(int n) {
		int sum = 0;
		while (n % 2 == 0) {
			sum += 2;
			n = n / 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				sum += i;
				n = n / i;
			}
		}

		if (n > 2) {
			sum += n;
		}
		return sum;
	}
}
