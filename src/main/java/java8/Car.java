package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月24日 下午3:21:41
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class Car {

	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

	@Test
	public void test() {
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);
		cars.forEach(Car::collide);
		cars.forEach(Car::repair);
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);

	}
}
