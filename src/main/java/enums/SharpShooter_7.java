package enums;

/**
 * Title.<br>
 * Description.带有抽象方法的枚举类型
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:06:23
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 */
public enum SharpShooter_7 {
	LOCKED() {

		@Override
		public String getDesc() {
			return "锁定目标";
		}
	},

	AIM {

		@Override
		public String getDesc() {
			return "瞄准目标";
		}
	},

	SHOOT {

		@Override
		public String getDesc() {
			return "射击";
		}
	};

	/**
	 * 抽象方法，每个枚举值都必须自己实现
	 * 
	 * @return String
	 */
	public abstract String getDesc();
}