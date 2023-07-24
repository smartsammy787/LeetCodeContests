package WeeklyContest350;

public class TotalDistanceTraveled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int distanceTraveled(int a, int b) {
		return (a + Math.min((a - 1) / 4, b)) * 10;
	}
}
