package test;

import java.text.DecimalFormat;

public class BaoLiuXiaoShu {

	public void format1(String pattern, double value) { // 此方法专门用于完成数字的格式化显示
		DecimalFormat df = new DecimalFormat(pattern); // 声明一个DecimalFormat类的对象
		String str = df.format(value); // 格式化数字
		System.out.println("使用" + pattern + "格式化数字" + value + "：" + str);
	}

	public static void main(String args[]) {
		BaoLiuXiaoShu demo = new BaoLiuXiaoShu(); // 格式化对象的类
		demo.format1("###,###.###", 111222.34567);
		demo.format1("000,000.000", 11222.34567);
		demo.format1("###,###.###￥", 111222.34567);
		demo.format1("000,000.000￥", 11222.34567);
		demo.format1("##.###%", 0.000345678);
		demo.format1("00.###%", 0.000345678);
		demo.format1("###.###\u2030", 0.345678);
	}

}
