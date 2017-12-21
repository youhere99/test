package enums;

/**
 * Title.<br>
 * Description.每个枚举值自己实现接口
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:06:23
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 */
public enum SharpShooter_6 implements IDesc {
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
	}
}