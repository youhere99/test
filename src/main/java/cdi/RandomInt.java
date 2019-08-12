package cdi;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class RandomInt {

	@Produces
	public int get() {

		return new Random().nextInt(100);

	}

}
