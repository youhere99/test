package enums;

/**
 * Title.<br>
 * Description.带方法的枚举类型
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:06:23
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public enum SharpShooter_3 {
	LOCKED, AIM, SHOOT;

	public String getDesc() {
		switch (this.ordinal()) {
			case 0:
				return "锁定目标";
			case 1:
				return "瞄准目标";
			case 2:
				return "射击";
			default:
				return "没有该枚举值！";
		}
	}

}
