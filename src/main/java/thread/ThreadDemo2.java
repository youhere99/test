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
public class ThreadDemo2 {

	public static void main(String[] args) throws IOException {
		System.out.println("进入线程" + Thread.currentThread().getName());
		ThreadDemo2 test = new ThreadDemo2();
		MyThread thread1 = test.new MyThread();
		thread1.start();
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "等待");
			thread1.join();
			System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("进入线程" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
		}
	}
}