package test;

import java.util.UUID;

import org.junit.Test;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月24日 上午9:33:22
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class UUIDTest {

	@Test
	public void randomUUID() {
		UUID uuid = UUID.randomUUID();
		print(uuid);
		uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		print(uuid);
		String hello = "hello";
		uuid = UUID.nameUUIDFromBytes(hello.getBytes());
		print(uuid);

	}

	@Test
	public void testJUG() {
		UUID uuid = Generators.randomBasedGenerator().generate();
		print(uuid);
		UUID uuid2 = Generators.timeBasedGenerator().generate();
		print(uuid2);
		TimeBasedGenerator gen = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
		UUID uuid3 = gen.generate();
		print(uuid3);
		UUID uuid4 = gen.generate();
		print(uuid4);
	}

	protected void print(UUID uuid) {
		System.out.println(uuid.toString());
		System.out.println(uuid.toString().replace("-", ""));
		System.out.println(uuid.getLeastSignificantBits());
		System.out.println(uuid.getMostSignificantBits());
		System.out.println(uuid.hashCode());
		System.out.println(uuid.variant());
		System.out.println(uuid.version());
		// System.err.println(uuid.node());
		// System.err.println(uuid.timestamp());
		// System.err.println(uuid.clockSequence());
		System.err.println("-------------------------------------");
	}

}
