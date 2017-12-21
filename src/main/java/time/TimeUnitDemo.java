package time;

import java.util.concurrent.TimeUnit;

public class TimeUnitDemo {

	private TimeUnit timeUnit = TimeUnit.DAYS;

	public static void main(String[] args) {
		TimeUnitDemo demo = new TimeUnitDemo();
		demo.outInfo(1);
		demo.timeUnit = TimeUnit.HOURS;
		demo.outInfo(1);
		demo.timeUnit = TimeUnit.MINUTES;
		demo.outInfo(1);
		demo.timeUnit = TimeUnit.SECONDS;
		demo.outInfo(1);
		demo.timeUnit = TimeUnit.NANOSECONDS;
		demo.outInfo(1);
	}

	public void outInfo(long time) {
		System.out.println(timeUnit.name());
		System.out.println(timeUnit.toDays(time));
		System.out.println(timeUnit.toHours(time));
		System.out.println(timeUnit.toMinutes(time));
		System.out.println(timeUnit.toSeconds(time));
		System.out.println(timeUnit.toMillis(time));
		System.out.println(timeUnit.toMicros(time));
		System.out.println(timeUnit.toNanos(time));
		System.out.println("1天有" + (timeUnit.convert(1, TimeUnit.DAYS)) + timeUnit.name());
		System.out.println("12小时" + (timeUnit.convert(12, TimeUnit.HOURS)) + timeUnit.name());
		System.out.println("3600 分钟有" + (timeUnit.convert(36000, TimeUnit.MINUTES)) + timeUnit.name());
		System.out.println("-------------------");
	}
}