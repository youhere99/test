package socket;

import org.junit.Test;

public class TimeOutThread extends Thread {

	/**
	 * 超时时间
	 */
	private final long timeOut;

	/**
	 * 是否取消
	 */
	private boolean cancel;

	/**
	 * 自定义超时异常
	 */
	private final TimeOutException timeOutException;

	public TimeOutThread(long timeOut, TimeOutException timeOutException) {
		super();
		this.timeOut = timeOut;
		this.timeOutException = timeOutException;
		// 设置本线程为守护线程
		this.setDaemon(true);
	}

	public synchronized void cancel() {
		cancel = true;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeOut);

			if (!cancel) {
				throw timeOutException;
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// 定义一个自己的超时异常：
// Java代码 收藏代码

class TimeOutException extends RuntimeException {

	/**
	 * 序列化号
	 */
	private static final long serialVersionUID = -8078853655388692688L;

	public TimeOutException(String errMessage) {
		super(errMessage);
	}
}

// 测试类：
// Java代码 收藏代码
class TestTimeOut {

	@Test
	public void test() {
		TimeOutThread timeOutThread = new TimeOutThread(3000, new TimeOutException("time out!"));
		try {
			timeOutThread.start();
			Thread.sleep(5000);
			timeOutThread.cancel();
		}
		catch (TimeOutException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
