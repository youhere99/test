package test;

/* 
 * ========================================================================
 * 
 * Copyright 2005 Tim O'Brien.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
import java.text.NumberFormat;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class TestStopWatch {

	public static void main(String[] args) {
		StopWatch clock = new StopWatch();
		NumberFormat format = NumberFormat.getInstance();

		System.out.println("How long does it take to take the sin of 0.34 ten million times?");
		clock.start();
		for (int i = 0; i < 100000000; i++) {
			Math.sin(0.34);
		}
		clock.stop();

		System.out.println("It takes " + clock.getTime() + " milliseconds");

		System.out.println("How long does it take to multiply 2 doubles one billion times?");
		clock.reset();
		clock.start();
		for (int i = 0; i < 1000000000; i++) {
			double result = 3423.2234 * 23e-4;
		}
		clock.stop();
		System.out.println("It takes " + clock.getTime() + " milliseconds.");

		System.out.println("How long does it take to add 2 ints one billion times?");
		clock.reset();
		clock.start();
		for (int i = 0; i < 1000000000; i++) {
			int result = 293842923 + 33382922;
		}
		clock.stop();
		System.out.println("It takes " + clock.getTime() + " milliseconds.");

		System.out.println("Testing the split() method.");
		clock.reset();
		clock.start();
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
		}
		clock.split();
		System.out.println("Split Time after 1 sec: " + clock.getTime());
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
		}
		System.out.println("Split Time after 2 sec: " + clock.getTime());
		clock.unsplit();
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
		}
		System.out.println("Time after 3 sec: " + clock.getTime());

	}

	@Test
	private void timingTwo() {
		// Create an instance of StopWatch and start the stopwatch.
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// Do some task and split the stopwatch time.
		doSomeTask(3000);
		stopWatch.split();
		System.out.println("Split 1: " + stopWatch.toSplitString());

		// Suspend the stopwatch and resume the stopwatch.
		stopWatch.suspend();
		doSomeTask(4000);
		stopWatch.resume();

		// Do some task and split the stopwatch time.
		doSomeTask(2500);
		stopWatch.split();
		System.out.println("Split 2: " + stopWatch.toSplitString());

		// Do some task and split the stopwatch time.
		doSomeTask(1000);
		stopWatch.split();
		System.out.println("Split 3: " + stopWatch.toSplitString());

		// Stop the stopwatch and the the total execution time.
		stopWatch.stop();
		System.out.println("Time: " + stopWatch.getTime());
	}

	private void doSomeTask(long sleep) {
		try {
			Thread.sleep(sleep);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSpringStopWatch() {

		org.springframework.util.StopWatch watch = new org.springframework.util.StopWatch();
	}
}