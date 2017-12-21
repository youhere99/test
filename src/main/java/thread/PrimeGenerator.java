package thread;

import org.junit.Test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月31日 下午3:22:15
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime %n", number);
			}

			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted");
				return;
			}
			number++;
		}

	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}

		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		Thread task = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}
}
