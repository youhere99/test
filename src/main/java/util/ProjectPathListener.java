package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title.<br>
 * Description.获得项目路径
 * <p>
 * Copyright: Copyright (c) 2015年7月23日 下午3:36:35
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * 
 * @author ZhaoMingxing
 * @version 1.0
 */
public class ProjectPathListener implements ServletContextListener {

	private final static Logger log = LoggerFactory.getLogger(ProjectPathListener.class);

	public static String ProjectPATH = null;

	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Program to destroy...");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ProjectPATH = arg0.getServletContext().getRealPath("/");
		log.info("Program to init..." + ProjectPATH);
	}

}
