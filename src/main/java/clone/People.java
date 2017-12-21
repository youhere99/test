package clone;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * Title.<br> 
 * Description.测试拷贝
 * <p>
 * Copyright: Copyright (c) 2015年12月1日 下午7:34:48
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class People implements Cloneable {

	private String name;

	private int age;

	public People() {
	}

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		People p1 = new People("zhangsan", 18);
		People p2 = (People) p1.clone();
		p2.setName("lis");
		p2.setAge(20);
		System.err.println(p1);
		System.err.println(p2);
		//修改p2后，没有对p1产生影响。
	}
}