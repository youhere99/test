package java8.time;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;

/**
 * http://ifeve.com/20-examples-of-date-and-time-api-from-java8/
 * 
 * @author GEEK
 *
 */
public class TestLocalDate {
	// 它定义清楚了时间日期相关的一些概念，比方说，瞬时时间（Instant）,持续时间（duration），日期（date）,时间（time），时区（time-zone）以及时间段（Period）
	@Test
	public void testA() {

		// 示例1 如何 在Java 8中获取当天的日期
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);
		// 示例2 如何在Java 8中获取当前的年月日
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

		// 示例3 在Java 8中如何获取某个特定的日期
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);

		// 示例4 在Java 8中如何检查两个日期是否相等
		LocalDate date1 = LocalDate.of(2014, 01, 14);
		if (date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		}

		// 示例5 在Java 8中如何检查重复事件，比如说生日
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}
		// 示例6 如何在Java 8中获取当前时间
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);
		// 示例7 如何增加时间里面的小时数
		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
		// 示例8 如何获取1周后的日期
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);
		// 示例9 一年前后的日期
		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);

		// 示例10 在Java 8中使用时钟
		// Returns the current time based on your system clock and set to UTC.
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);
		// Returns time based on system clock zone Clock defaultClock =
		Clock clock2 = Clock.systemDefaultZone();
		System.out.println("Clock2 : " + clock2);

		System.out.println("Clock : " + LocalDate.now(clock));
		// 示例11 在Java中如何判断某个日期是在另一个日期的前面还是后面
		LocalDate tomorrow = LocalDate.of(2014, 1, 15);
		System.err.println("atTime  " + tomorrow.atTime(5, 5));
		if (tomorrow.isAfter(today)) {
			System.out.println("Tomorrow comes after today");
		}
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
		if (yesterday.isBefore(today)) {
			System.out.println("Yesterday is day before today");
		}
		// 示例12 在Java 8中处理不同的时区
		// Date and time with timezone in Java 8
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		System.out.println("localtDateAndTime " + localtDateAndTime);
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
		System.out.println("ZoneId : " + ZoneId.systemDefault());
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

		// 示例13 如何表示固定的日期，比如信用卡过期时间
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

		// 示例14 如何在Java 8中检查闰年
		if (today.isLeapYear()) {
			System.out.println("This year is Leap year");
		} else {
			System.out.println("2014 is not a Leap year");
		}

		// 示例15 两个日期之间包含多少天，多少个月

		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());

		// 示例16 带时区偏移量的日期与时间
		// OffSetDateTime主要是给机器来理解的，如果是给人看的，可以使用ZoneDateTime类。
		LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
		ZoneOffset offset = ZoneOffset.of("+05:30");
		OffsetDateTime date = OffsetDateTime.of(datetime, offset);
		System.out.println("Date and Time with timezone offset in Java : " + date);
		// 示例17 在Java 8中如何获取当前时间戳
		Instant timestamp = Instant.now();

		System.out.println("What is value of this instant " + Instant.now(clock2));
		System.out.println("What is value of this instant " + timestamp);

		System.out.println(Date.from(timestamp));

		// 示例18 如何在Java 8中使用预定义的格式器来对日期进行解析/格式化

		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);

		// 示例19 如何在Java中使用自定义的格式器来解析日期
		String goodFriday = "Apr 18 2014";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
		} catch (DateTimeParseException ex) {
			System.out.printf("%s is not parsable!%n", goodFriday);
			ex.printStackTrace();
		}

		// 示例20 如何在Java 8中对日期进行格式化，转换成字符串
		LocalDateTime arrivalDate = LocalDateTime.now();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
			String landing = arrivalDate.format(format);
			System.out.printf("Arriving at : %s %n", landing);
		} catch (DateTimeException ex) {
			System.out.printf("%s can't be formatted!%n", arrivalDate);
			ex.printStackTrace();
		}
	}

	@Test
	public void testB() {
		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date=" + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2014);

		// Try creating date by providing invalid inputs
		// LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid date 'February 29' as '2014' is not a leap year

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(100);
		System.out.println("100th day from base date= " + dateFromBase);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014=" + hundredDay2014);
	}

	/**
	 * http://www.importnew.com/14140.html
	 */

	@Test
	public void testC() {
		// Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time=" + time);

		// Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
		System.out.println("Specific Time of Day=" + specificTime);

		// Try creating time by providing invalid inputs
		// LocalTime invalidTime = LocalTime.of(25,20);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid value for HourOfDay (valid values 0 - 23): 25

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST=" + timeKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time= " + specificSecondTime);

	}

	@Test
	public void testD() {
		// Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		// Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = " + specificTime);

		// Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);

		// Format examples
		LocalDate date = LocalDate.now();
		// default format
		System.out.println("Default format of LocalDate=" + date);
		// specific format
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

		LocalDateTime dateTime = LocalDateTime.now();
		// default format
		System.out.println("Default format of LocalDateTime=" + dateTime);
		// specific format
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

		// default format
		System.out.println("Default format of Instant=" + timestamp);

		// Parse examples
		LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
				DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
		System.out.println("Default format after parsing = " + dt);

	}

	// 作者：一大三千
	// 来源：CSDN
	// 原文：https://blog.csdn.net/u011726984/article/details/79345847
	// 版权声明：本文为博主原创文章，转载请附上博文链接！

	@Test
	public void testInstant() {
		Instant instant = Instant.now();
		System.out.println("TimeTest.testInstant 时间戳 ： " + System.currentTimeMillis());
		System.out.println(
				"TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli());
		System.out.println(
				"TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.of("GMT+08:00")).toInstant().toEpochMilli());
		System.out.println(
				"TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
	}
	
	@Test
	public void testDuration() {
	    LocalDate date1 = LocalDate.of(2017, 12, 12);
	    LocalDate date2 = LocalDate.of(2017, 12, 24);

	    LocalTime time1 = LocalTime.of(15, 7, 50);
	    LocalTime time2 = LocalTime.of(16, 8, 50);
	    Duration d1 = Duration.between(time1, time2);

	    LocalDateTime dateTime1 = LocalDateTime.of(2017, Month.MARCH, 12, 00, 00, 00);
	    LocalDateTime dateTime2 = LocalDateTime.of(2018, Month.MARCH, 11, 23, 59, 59);
	    Duration d2 = Duration.between(dateTime1, dateTime2);

	    Instant instant1 = Instant.ofEpochSecond(1);
	    Instant instant2 = Instant.now();
	    Duration d3 = Duration.between(instant1, instant2);

	    System.out.println("TimeTest.testDuration d1: " + d1.getSeconds() +"\td2: " + d2.getSeconds() +"\td3: " + d3.getSeconds());
	    System.out.println("TimeTest.testDuration d1: " + d1.toDays() +"\td2: " + d2.toDays() +"\td3: " + d3.toDays());
	    // 这里会抛异常java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
//	    Duration d4 = Duration.between(date1, date2);
	}


	@Test
	public void testF(){
		LocalDate startDate = LocalDate.of(2015, 2, 15);
		LocalDate endDate = LocalDate.of(2017, 2, 21);

		Period period = Period.between(startDate, endDate);

		System.out.println(String.format("Years:%d months:%d days:%d", period.getYears(), period.getMonths(), period.getDays()));
	}
	
}
