package cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DrinkShop {
	// @Produces
	public String coffee() {
		return (System.currentTimeMillis() % 2 == 0) ? "Coffee" : "Coco cola";

	}
}
