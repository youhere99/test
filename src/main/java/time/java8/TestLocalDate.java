package time.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * 
 * description:Java 8是如何处理时间及日期的
 * http://ifeve.com/20-examples-of-date-and-time-api-from-java8/
 * 
 * @author zhaomingxing 2018年10月15日
 *
 */
public class TestLocalDate {

	@Test
	public void testA() {
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);

		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);

		LocalDate date1 = LocalDate.of(2014, 01, 14);
		if (!date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		}

		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}

		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);

		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
		// 由于LocalDate也是不可变的，因此任何修改操作都会返回一个新的实例，因此别忘了保存起来
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);

		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);

	}
}
