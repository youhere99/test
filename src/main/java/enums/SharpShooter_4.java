package enums;

/**
 * Title.<br>
 * Description.带私有构造方法的枚举类型
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:06:23
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public enum SharpShooter_4 {
	LOCKED("锁定目标"), AIM("瞄准目标"), SHOOT("射击");

	private String desc; // 枚举说明

	/**
	 * 私有的构造方法
	 */
	private SharpShooter_4(String desc) {
		this.desc = desc;
	}

	/**
	 * 获取枚举值的说明
	 * 
	 * @return String
	 */
	public String getDesc() {
		return desc;
	}
}
