package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年6月6日 上午10:29:39
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TimerTest2 {

	static class MyTimerTask1 extends TimerTask {

		@Override
		public void run() {
			System.out.println("爆炸1！！！");
			new Timer().schedule(new MyTimerTask2(), 2000);
		}
	}

	static class MyTimerTask2 extends TimerTask {

		@Override
		public void run() {
			System.out.println("爆炸2！！！");
			new Timer().schedule(new MyTimerTask1(), 3000);
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask2(), 2000);
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
