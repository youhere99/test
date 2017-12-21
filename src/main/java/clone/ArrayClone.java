package clone;

/**
 * 
 * Title.<br> 
 * Description.由测试可知，Java数组只具备浅层复制的功能。
 * <p>
 * Copyright: Copyright (c) 2015年12月1日 下午7:43:50
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class ArrayClone {

	public static void main(String[] args) {
		People p1 = new People("wangwu", 18);
		People p2 = new People("lisi", 28);
		People[] ps1 = { p1, p2 };
		People[] ps2 = ps1.clone();
		ps2[0].setName("wanghao");
		ps2[0].setAge(22);
		System.out.println("name=" + ps1[0].getName() + ",age=" + ps1[0].getAge());
		System.out.println("name=" + ps2[0].getName() + ",age=" + ps2[0].getAge());
		//name=wanghao,age=22
	}
}