package time;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Test;

/**
 * Title.<br>
 * Description.计算时间的间隔
 * <p>
 * Copyright: Copyright (c) 2016年4月18日 下午11:21:38
 * <p>
 * Company: 北京金瑞帆科技有限公司
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */

public class DurationFormat {

	// 通过传入一个毫秒数与日期格式(如：yyyy-MM-dd HH:mm:ss)，它会返回一个对应日期的字符串形式。
	@Test
	public void test_formatDuration() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		long durationMillis = (10 + 20 * 60 + 13 * 3600 + 4 * 24 * 3600) * 1000;
		String formatDate = DurationFormatUtils.formatDuration(durationMillis, pattern);
		System.out.println(formatDate);

		String s = DurationFormatUtils.formatDurationWords(durationMillis, true, true);
		System.out.println(s);
		s.replace("hour", "h").replace("hs", "h").replace("minute", "m").replace("ms", "m").replace("second", "s").replace("ss", "s");
		System.out.println(s);

		s = DurationFormatUtils.formatDuration(durationMillis, "dd'd' HH'h' mm'm' ss's'", false);
		System.out.println(s);
	}

	@Test
	public void test_formatPeriod() throws ParseException {
		String[] parsePatterns = { "yyyy-MM-dd HH:mm:ss SSS" };
		String str = "2009-09-30 15:30:12 123";
		String str2 = "2010-09-30 15:30:12 133";
		Date date = DateUtils.parseDate(str, parsePatterns);
		Date date2 = DateUtils.parseDate(str2, parsePatterns);
		long durationMillis = DateUtils.getFragmentInMilliseconds(date, Calendar.YEAR);
		long durationMillis2 = DateUtils.getFragmentInMilliseconds(date2, Calendar.YEAR);
		String s = DurationFormatUtils.formatPeriod(durationMillis, durationMillis2, "yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(s);
	}

	@Test
	public void test_Fragment() throws ParseException {

		// 返回23，表示从当月起已经过去23天了，
		System.err.println(DateUtils.getFragmentInDays(new Date(), Calendar.MONTH));
		// 返回296，表示从当年起已经过去296天了，
		System.err.println(DateUtils.getFragmentInDays(new Date(), Calendar.YEAR));
		// 返回13，表示从今天起已经过去13个小时了
		System.err.println(DateUtils.getFragmentInHours(new Date(), Calendar.DATE));
		String[] parsePatterns = { "yyyy-MM-dd HH:mm:ss" };
		String str2 = "2010-09-30 15:40:18";
		Date date = DateUtils.parseDate(str2, parsePatterns);

		System.err.println(DateUtils.getFragmentInDays(date, Calendar.MONTH));
		// 返回296，表示从当年起已经过去296天了，
		System.err.println(DateUtils.getFragmentInDays(date, Calendar.YEAR));
		// 返回13，表示从今天起已经过去13个小时了
		System.err.println(DateUtils.getFragmentInHours(date, Calendar.DATE));
		System.err.println(DateUtils.getFragmentInMinutes(date, Calendar.DATE));
	}

	@Test
	public void test_truncated() throws ParseException {

		System.err.println(DateUtils.truncate(new Date(), Calendar.DATE));
		System.err.println(DateUtils.truncate(new Date(), Calendar.YEAR));
		System.err.println(DateUtils.truncate(new Date(), Calendar.MONTH));

		System.err.println(DateUtils.ceiling(new Date(), Calendar.MONTH)); // 输出
		                                                                   // 2015-10-01

		System.err.println(DateUtils.round(new Date(), Calendar.MONTH)); // 输出
		                                                                 // 2015-09-01
		String[] parsePatterns = { "yyyy-MM-dd HH:mm:ss" };
		String str2 = "2016-05-12 15:40:18";
		Date date = DateUtils.parseDate(str2, parsePatterns);
		System.err.println(DateUtils.truncate(date, Calendar.DATE));
		boolean bool = DateUtils.truncatedEquals(date, new Date(), Calendar.DATE);
	}
}
