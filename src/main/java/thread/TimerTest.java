package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年6月6日 上午10:28:35
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TimerTest {

	static class MyTimerTask1 extends TimerTask {

		@Override
		public void run() {
			System.out.println("爆炸！！！");
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask1(), 2000);// 两秒后启动任务
	}
}
