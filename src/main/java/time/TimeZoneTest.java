package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

/**
 * TimeZone的测试程序
 */
public class TimeZoneTest {

	@Test
	public void test1() {
		Date date = new Date(1391174450000L); // 2014-1-31 21:20:50
		String dateStr = "2014-1-31 21:20:50 ";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			Date dateTmp = dateFormat.parse(dateStr);
			System.out.println(dateTmp);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		String dateStrTmp = dateFormat.format(date);
		System.out.println(dateStrTmp);
	}

}
