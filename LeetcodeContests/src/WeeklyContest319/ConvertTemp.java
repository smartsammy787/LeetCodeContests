package WeeklyContest319;

public class ConvertTemp {
	public double[] convertTemperature(double celsius) {

		double kelvin = celsius + 273.15d;
		double fah = celsius * 1.80 + 32.00;

		return new double[] { kelvin, fah };
	}
}
