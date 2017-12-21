package java8;

import org.junit.Test;

public class FormulaTest {

	@Test
	public void testFormula() {
		Formula formula = new Formula() {

			@Override
			public double calculate(int num) {
				return this.sqrt(num * 100);
			}
		};

		System.err.println(formula.calculate(100));
		System.err.println(formula.sqrt(100));
	}

}
