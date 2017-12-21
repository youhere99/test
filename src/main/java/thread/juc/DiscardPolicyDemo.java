package thread.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title.<br>
 * Description.DiscardPolicy -- 当任务添加到线程池中被拒绝时，线程池将丢弃被拒绝的任务。
 * <p>
 * Copyright: Copyright (c) 2017年6月13日 下午5:21:57
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */

public class DiscardPolicyDemo {

	private static final int THREADS_SIZE = 1;

	private static final int CAPACITY = 1;

	public static void main(String[] args) throws Exception {

		// 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(CAPACITY));
		// 设置线程池的拒绝策略为"丢弃"
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		// 新建10个任务，并将它们添加到线程池中。
		for (int i = 0; i < 10; i++) {
			Runnable myrun = new MyRunnable("task-" + i);
			System.err.println("count:" + i);
			pool.execute(myrun);
		}
		// 关闭线程池
		pool.shutdown();
	}
}
