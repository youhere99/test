package enums;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:33:24
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public enum Color {
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

	// 成员变量
	private String name;

	private int index;

	// 构造方法
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {
		// 枚举为value
		Map<?, Color> enumMap = EnumUtils.getEnumMap(Color.class);
		System.err.println(enumMap);
		System.err.println(enumMap.get("RED"));
		// 枚举为key
		EnumMap<Color, String> enumMap2 = new EnumMap<Color, String>(Color.class);
		enumMap2.put(GREEN, "3");
		System.err.println(enumMap2);

		List<Color> enumList = EnumUtils.getEnumList(Color.class);
		System.err.println(enumList);
	}
}