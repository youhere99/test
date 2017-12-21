package java8;

/**
 * Title.<br>
 * Description.java8接口新特性
 * <p>
 * Copyright: Copyright (c) 2017年5月24日 上午11:34:03
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public interface Formula {

	double calculate(int a);

	// default 关键字给接口增加非抽象的方法实现。
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	// static 静态方法
	static double staticMethod(int a) {
		return Math.sqrt(a);
	}

}
