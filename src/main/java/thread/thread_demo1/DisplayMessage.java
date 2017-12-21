package thread.thread_demo1;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年10月12日 下午9:51:23
 * <p>
 * Company: 北京乐学通在线教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
// 文件名 : DisplayMessage.java
// 通过实现 Runnable 接口创建线程
public class DisplayMessage implements Runnable {

	private String message;

	public DisplayMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(message);
		}
	}
}
