package time;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

public class FormatDemo {

	private Calendar now;

	@Before
	public void before() {
		now = Calendar.getInstance();
		TimeZone tz = TimeZone.getDefault();
		now.setTimeZone(tz);
	}

	@Test
	public void testformat() throws Exception {
		String partten = "yyyy-MM-dd 00:00:00";
		String sendTime = DateUtil.formatDate(now.getTime(), partten);

		//		Long l = sendTime.getTime();
		//		now.setTimeInMillis(l);

		Date sendTime2 = DateUtils.parseDate(sendTime, partten);
	}

	@Test
	public void testTruncate() throws Exception {
		String partten = "yyyy-MM-dd 00:00:00";
		Date t = now.getTime();
		System.err.println(DateUtil.formatDate(t, partten));
		Set<String> set = new HashSet<String>();
		set.add(partten);
		System.err.println(DateUtil.formatDate(DateUtils.addDays(t, -29), partten));
		System.err.println(DateUtil.parseDate(DateUtil.formatDate(DateUtils.addDays(t, -29), partten), set));
		System.err.println(DateUtils.parseDate(DateUtil.formatDate(DateUtils.addDays(t, -29), partten), partten));
	}

	public static void main(String[] args) {
		Date today;
		Calendar now;
		DateFormat f1, f2;
		String s1, s2;

		System.out.println("\n显示Date类的相关用法");

		today = new Date();
		System.out.println("new Date()= \t" + today);

		System.out.println("\n用DateFormat类显示各种日期格式");

		//显示各种日期格式 
		f1 = DateFormat.getDateInstance();
		s1 = f1.format(today);
		System.out.println("DateFormat.getDateInstance()= \t" + s1);

		f1 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getDateInstance(DateFormat.LONG,Locale.CHINA)= \t" + s1);

		f1 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.CHINA)= \t" + s1);

		f1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getDateInstance(DateFormat.SHORT,Locale.CHINA)= \t" + s1);

		System.out.println("\n用DateFormat类显示各种时间格式");

		//显示各种时间格式 
		f1 = DateFormat.getTimeInstance();
		s1 = f1.format(today);
		System.out.println("DateFormat.getTimeInstance()= \t" + s1);

		f1 = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getTimeInstance(DateFormat.LONG,Locale.CHINA)= \t" + s1);

		f1 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.CHINA)= \t" + s1);

		f1 = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
		s1 = f1.format(today);
		System.out.println("DateFormat.getTimeInstance(DateFormat.SHORT,Locale.CHINA)= \t" + s1);

		System.out.println("\n显示Calendar的相关时间用法");

		now = Calendar.getInstance();
		today = now.getTime();
		System.out.println("Calendar.getInstance().getTime()= \t" + today.toString());

	}

}
