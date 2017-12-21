package thread.juc;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年6月13日 下午5:24:53
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class MyRunnable implements Runnable {

	private String name;

	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.name + " is running.");
			Thread.sleep(200);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
