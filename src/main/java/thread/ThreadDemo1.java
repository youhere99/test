package thread;

import java.io.IOException;

/**
 * 
 * Title.<br> 
 * Description. sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。
 * <p>
 * Copyright: Copyright (c) 2016年4月12日 上午9:24:24
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class ThreadDemo1 {

	private int i = 10;

	private final Object object = new Object();

	public static void main(String[] args) throws IOException {
		ThreadDemo1 test = new ThreadDemo1();
		MyThread thread1 = test.new MyThread();
		MyThread thread2 = test.new MyThread();
		thread1.start();
		thread2.start();
	}

	class MyThread extends Thread {

		@Override
		public void run() {
			synchronized (object) {
				i++;
				System.out.println("i:" + i);
				try {
					System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
					Thread.sleep(10000);
				}
				catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
				i++;
				System.out.println("i:" + i);
			}
		}
	}
}