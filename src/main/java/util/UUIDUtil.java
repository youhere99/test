package util;

import java.util.UUID;

/**
 * Title.<br>
 * Description.生成32位长度的唯一字符串
 * <p>
 * Copyright: Copyright (c) 2015年7月8日 下午2:31:06
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * 
 * @author ZhaoMingxing
 * @version 1.0
 */
public class UUIDUtil {

	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
