package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TestGetWeek {

	public static void main(String[] args) {

		int currentMaxDays = getCurrentMonthDay();

		int maxDaysByDate = getDaysByYearMonth(2012, 11);

		String week = getDayOfWeekByDate("2012-12-25");

		System.out.println("本月天数：" + currentMaxDays);
		System.out.println("2012年11月天数：" + maxDaysByDate);
		System.out.println("2012-12-25是：" + week);

		System.out.println("月的最大天数为=" + Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("月的最小天数为=" + Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取当月的 天数
	 */
	public static int getCurrentMonthDay() {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 根据年 月 获取对应的月份 天数
	 */
	public static int getDaysByYearMonth(int year, int month) {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 根据日期 找到对应日期的 星期
	 */
	public static String getDayOfWeekByDate(String date) {
		String dayOfweek = "-1";
		try {
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date myDate = myFormatter.parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("E");
			String str = formatter.format(myDate);
			dayOfweek = str;

		}
		catch (Exception e) {
			System.out.println("错误!");
		}
		return dayOfweek;
	}

	/**
	 * 功能： Calendar类roll和add的区别. <br/>
	 * 2016年12月17日上午11:28:50 zhaomingxing
	 */
	public void testB() {
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		Calendar first = Calendar.getInstance();
		Calendar second = Calendar.getInstance();
		System.out.println(first.equals(second));
		/*
		 * roll方法只是对相应时间属性的域内做变化 例如,对月份使用roll方法，它会在1-12的范围内变化，不会影响的年 2011-1-15
		 * roll(Calendar.MONTH, -1) 后是2011-12-15
		 */
		first.roll(Calendar.MONTH, -1);
		System.out.println("roll后时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(first.getTime()));
		/*
		 * add方法会产生其他相关时间属性的连动变化 2011-1-15 roll(Calendar.MONTH, -1) 后是2011-12-15
		 */
		second.add(Calendar.MONTH, -1);
		System.out.println("add后时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(second.getTime()));
	}
}
