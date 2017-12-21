package util;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 
 * Title.<br> 
 * Description.注册用户时 超时注册会删除用户名
 * <p>
 * Copyright: Copyright (c) 2015年11月4日 下午5:07:08
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class MoniterSessionListener implements HttpSessionActivationListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
