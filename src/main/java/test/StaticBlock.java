package test;

/**
 * Title.<br>
 * Description.
 * 　结论：静态代码块是在类加载时自动执行的，非静态代码块是在创建对象时自动执行的代码，不创建对象不执行该类的非静态代码块。且执行顺序为静态代码块
 * ------非静态代码块----构造函数。
 * <p>
 * Copyright: Copyright (c) 2014-11-3 下午03:01:35
 * <p>
 * Company: 北京金瑞帆科技有限公司
 * <p>
 * 
 * @author zhaomx
 * @version 1.0
 */
public class StaticBlock {

	static {
		System.out.println("静态块");
	}
	{
		System.out.println("构造块，在类中定义");
	}

	public StaticBlock() {
		System.out.println("构造方法执行");
	}

	public static void main(String[] args) {
		new StaticBlock();
		new StaticBlock();
	}

}

class T2 {

	private static int total = 200;

	static {

		total = 100;
		System.out.println("static语句块");
	}

	public static void main(String[] args) {

		System.out.println(T2.total);
		System.out.println(T2.total);
	}
}

class T3 {

	static {

		total = 100;
		System.out.println("static语句块");
	}

	private static int total = 200;

	public static void main(String[] args) {

		System.out.println(T3.total);
		System.out.println(T3.total);
	}
}