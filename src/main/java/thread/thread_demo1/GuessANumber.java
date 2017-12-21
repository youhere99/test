package thread.thread_demo1;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年10月12日 下午10:00:50
 * <p>
 * Company: 北京乐学通在线教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.8
 */
// 文件名 : GuessANumber.java
// 通过继承 Thread 类创建线程

public class GuessANumber extends Thread {

	private int number;

	public GuessANumber(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		int counter = 0;
		int guess = 0;
		do {
			guess = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " guesses " + guess);
			counter++;
		}
		while (guess != number);
		System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**");
	}
}
