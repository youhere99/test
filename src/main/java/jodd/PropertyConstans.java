package jodd;
/**
 * 
 * description:加载资源文件
 * 		
 * @author zhaomingxing 2018年11月7日
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import jodd.util.PropertiesUtil;

public class PropertyConstans {

	private static Properties jdbcProperties = new Properties();

	static {
		System.err.println("-----------------静态代码块加载-------------");
		jdbcProperties = PropertiesUtil.createFromClasspath("log4j.properties");
		System.err.println("jodd方式加载:" + jdbcProperties);
		System.err.println("------------------------------");
		try {
			jdbcProperties = PropertiesLoaderUtils.loadAllProperties("log4j.properties");
			System.err.println("spring自带加载:" + jdbcProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("------------------------------");
		InputStream resourceAsStream = PropertyConstans.class.getClassLoader().getResourceAsStream("log4j.properties");
		try {
			// Properties jdbcProperties = new Properties();
			jdbcProperties.load(resourceAsStream);
			System.err.println(" PropertyConstans.class:" + jdbcProperties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("------------------------------");
		ClassPathResource cr = new ClassPathResource("log4j.properties");
		try {
			Properties jdbcProperties = new Properties();
			jdbcProperties.load(cr.getInputStream());
			System.err.println("ClassPathResource加载:" + jdbcProperties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("------------------------------");
	}

	public static Properties getProperty() {
		return jdbcProperties;
	}
}
