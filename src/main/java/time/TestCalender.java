package time;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

public class TestCalender {

	private static Calendar calendar = Calendar.getInstance(); // 得到日历

	@Test
	public void testMessageFormat() {
		String str = "{0} | {1} | {0} | {1}";
		Object[] array = new Object[] { "A", "B" };
		String value = MessageFormat.format(str, array);
		System.out.println(value); // A | B | A | B

		MessageFormat mf = new MessageFormat("String: {0}\nInteger: {1}\nDouble: {2}");
		Object[] objArray = { "This is a string", new Integer(56), new Double(12.34) };
		String message = mf.format(objArray);
		System.out.println("The message: \n" + message);

		Object[] obj = mf.parse(message, new ParsePosition(0));
		System.out.println("\n\nObjects parsed:");
		for (Object o : obj) {
			System.out.println(o + " of " + o.getClass().toString());
		}

	}

	@Test
	public void testDateFormat() {
		Date date = new Date(); // 创建日期对象
		// 获取具有默认语言环境的默认格式化风格的日期格式器
		DateFormat df = DateFormat.getDateInstance();
		System.out.println("格式化日期=====" + df.format(date));
		df = DateFormat.getDateTimeInstance();
		System.out.println("格式化日期=====" + df.format(date));
		df = DateFormat.getTimeInstance();
		System.out.println("格式化日期=====" + df.format(date));
		df = DateFormat.getInstance();
		System.out.println("格式化日期=====" + df.format(date));

		System.out.println("默认的日期/时间格式：" + date); // 输出日期对象
		// 输出格式化为默认语言环境的时间
		System.out.println("格式化为默认语言环境的12小时制的时间：" + String.format("%tr", date));
		// 输出格式化为指定语言环境为Locale.US的时间
		System.out.println("格式化为语言环境为Locale.US的12小时制的时间：" + String.format(Locale.US, "%tr", date));
		System.out.println("格式化为默认语言环境的日期/时间：" + String.format("%tc", date));// 输出格式化为默认语言环境的日期/时间
		System.out.println("格式化为指定语言环境为Locale.US的日期/时间：" + String.format(Locale.US, "%tc", date));
	}

	@Test
	public void testLocal() {
		Locale locale = Locale.getDefault(); // 获得Java虚拟机示例的当前默认语言环境
		System.out.println("当前默认语言环境如下：" + locale);
		String displayCountry = locale.getDisplayCountry();
		// 获得适合向用户显示的语言环境国家/地区名
		System.out.println("国家/地区名如下：" + displayCountry);
		String displayLanguage = locale.getDisplayLanguage();
		// 获得适合向用户显示的语言环境的语言名
		System.out.println("语言名如下：" + displayLanguage);
		String displayName = locale.getDisplayName(); // 获得适合向用户显示的语言环境名
		System.out.println("语言环境名如下：" + displayName);

	}

	@Test
	public void testDate() {
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置时间格式
		String defaultStartDate = sdf.format(dBefore); // 格式化前一天
		String defaultEndDate = sdf.format(dNow); // 格式化当前时间

		System.out.println("前一天的时间是：" + defaultStartDate);
		System.out.println("生成的时间是：" + defaultEndDate);
		calendar = Calendar.getInstance();
		System.out.println("calendar.getTime(): " + sdf.format(calendar.getTime()));
		System.out.println("时: " + calendar.get(Calendar.HOUR_OF_DAY));

	}

	@Test
	public void testCalendar() {
		// TimeZone timeZone = TimeZone.getDefault();
		// calendar.setTimeZone(timeZone);
		// System.err.println(calendar.getTime());
		// timeZone = TimeZone.getTimeZone("GMT+8");
		// calendar.setTimeZone(timeZone);
		// System.err.println(calendar.getTime());
		System.err.println("-------------------------------");
		Date now = new Date(); // 当前时间
		calendar.setTime(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z"); // 设置时间格式
		System.out.println("生成的时间是：" + sdf.format(calendar.getTime()));
		Locale locale = Locale.getDefault();
		Map<String, Integer> names = calendar.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		System.out.println(names);
		String name = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		System.out.printf("Today is a %s.%n", name);

		// 上午,下午
		System.out.println(Calendar.AM);
		System.out.println(Calendar.PM);
		System.out.println(Calendar.AM_PM);
		// 星期
		System.out.println("星期日: " + Calendar.SUNDAY);
		System.out.println("星期一: " + Calendar.MONDAY);
		System.out.println("星期二: " + Calendar.TUESDAY);
		System.out.println("星期三: " + Calendar.WEDNESDAY);
		System.out.println("星期四: " + Calendar.THURSDAY);
		System.out.println("星期五: " + Calendar.FRIDAY);
		System.out.println("星期六: " + Calendar.SATURDAY);
		// 月份
		System.out.println("一月份: " + Calendar.JANUARY);
		System.out.println("二月份: " + Calendar.FEBRUARY);
		System.out.println("三月份: " + Calendar.MARCH);
		System.out.println("四月份: " + Calendar.APRIL);
		System.out.println("五月份: " + Calendar.MAY);
		System.out.println("六月份: " + Calendar.JUNE);
		System.out.println("七月份: " + Calendar.JULY);
		System.out.println("八月份: " + Calendar.AUGUST);
		System.out.println("九月份: " + Calendar.SEPTEMBER);
		System.out.println("十月份: " + Calendar.OCTOBER);
		System.out.println("十一月份: " + Calendar.NOVEMBER);
		System.out.println("十二份: " + Calendar.DECEMBER);
		System.out.println("十三份: " + Calendar.UNDECIMBER);
		Calendar cal = new GregorianCalendar();
		System.out.println("年: " + cal.get(Calendar.YEAR));
		System.out.println("月: " + cal.get(Calendar.MONTH));
		System.out.println("本年第: " + cal.get(Calendar.DAY_OF_YEAR) + " 天");
		System.out.println("日: " + cal.get(Calendar.DATE));
		System.out.println("日: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("本年第 " + cal.get(Calendar.WEEK_OF_YEAR) + " 个星期");
		System.out.println("本月第: " + cal.get(Calendar.WEEK_OF_MONTH) + " 个星期");
		System.out.println("本周第: " + cal.get(Calendar.DAY_OF_WEEK) + " 天");
		System.out.println("时: " + cal.get(Calendar.HOUR));
		System.out.println("时: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("分: " + cal.get(Calendar.MINUTE));
		System.out.println("秒: " + cal.get(Calendar.SECOND));
		System.out.println("毫秒: " + cal.get(Calendar.MILLISECOND));
	}
}
