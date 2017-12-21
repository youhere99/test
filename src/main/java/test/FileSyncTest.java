package test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月24日 上午11:11:09
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */

import java.util.UUID;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.ext.FileBasedTimestampSynchronizer;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * Simple manual utility test class for manually checking whether file-based
 * synchronization seems to be working or not.
 */
public class FileSyncTest {

	public static void main(String[] args) throws Exception {
		FileBasedTimestampSynchronizer sync = new FileBasedTimestampSynchronizer();
		// Let's stress-test it...
		sync.setUpdateInterval(2000L);

		// must have a NIC for this to work, should be ok:
		EthernetAddress eth = EthernetAddress.fromInterface();
		TimeBasedGenerator gen = Generators.timeBasedGenerator(eth, sync);

		int counter = 1;
		while (true) {
			UUID uuid = gen.generate();
			// Default one is for convenient output
			System.out.println("#" + counter + " -> " + uuid);

			/*
			 * This allows lexical sorting by uuid... (not very useful, since
			 * 'real' UUID ordering is not lexical)
			 */
			System.out.println("" + uuid + " (#" + counter + ")");

			// And this can be used to ensure there are no dups:
			System.out.println("" + uuid);
			++counter;

			try {
				Thread.sleep(120L);
			}
			catch (InterruptedException ie) {
			}
		}
	}
}
