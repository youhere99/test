package thread.juc;

import java.util.concurrent.locks.LockSupport;

import org.junit.Test;

/**
 * Title.<br>
 * Description.http://www.tuicool.com/articles/MveUNzF
 * <p>
 * Copyright: Copyright (c) 2017年6月20日 下午6:50:40
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class LockSupportTest {

	@Test
	public void testA() {
		LockSupport.park();
		System.out.println("block.");
	}

	@Test
	public void testB() {
		Thread thread = Thread.currentThread();
		LockSupport.unpark(thread);// 释放许可
		LockSupport.park();// 获取许可
		System.out.println("b");
	}

	@Test
	public void testC() {
		Thread thread = Thread.currentThread();

		LockSupport.unpark(thread);

		System.out.println("a");
		LockSupport.park();
		System.out.println("b");
		LockSupport.park();
		System.out.println("c");
	}

	@Test
	public void testD() throws InterruptedException {
		Thread t = new Thread(new Runnable() {

			private int count = 0;

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				long end = 0;

				while ((end - start) <= 1000) {
					count++;
					end = System.currentTimeMillis();
				}

				System.out.println("after 1 second.count=" + count);

				// 等待或许许可
				LockSupport.park();
				System.out.println("thread over." + Thread.currentThread().isInterrupted());

			}
		});

		t.start();

		Thread.sleep(2000);

		// 中断线程
		t.interrupt();

		System.out.println("main over");
	}
}
