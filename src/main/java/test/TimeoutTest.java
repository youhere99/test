package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class TimeoutTest {
	@Rule
	public TestRule timeout = Timeout.millis(3000);

	@Test
	public void should_timeout1() throws InterruptedException {
		System.out.println("A...");
		Thread.sleep(2000);
	}

	@Test
	public void should_timeout2() throws InterruptedException {
		System.out.println("B...");
		Thread.sleep(2000);
	}
}