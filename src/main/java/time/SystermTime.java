package time;

public class SystermTime {

	public static void main(String[] args) {

		// returns the current value of the system timer, in nanoseconds
		System.out.print("time in nanoseconds = ");
		System.out.println(System.nanoTime());

		// returns the current value of the system timer, in milliseconds
		System.out.print("time in milliseconds = ");
		System.out.println(System.currentTimeMillis());
	}
}
