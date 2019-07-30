package test;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ClassRuleTest {
	@ClassRule
	public static Timeout timeout = Timeout.millis(3000);

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