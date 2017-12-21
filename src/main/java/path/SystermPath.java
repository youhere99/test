package path;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

public class SystermPath {

	//	键 相关值的描述 
	//	java.version Java 运行时环境版本 
	//	java.vendor Java 运行时环境供应商 
	//	java.vendor.url Java 供应商的 URL 
	//	java.home Java 安装目录 
	//	java.vm.specification.version Java 虚拟机规范版本 
	//	java.vm.specification.vendor Java 虚拟机规范供应商 
	//	java.vm.specification.name Java 虚拟机规范名称 
	//	java.vm.version Java 虚拟机实现版本 
	//	java.vm.vendor Java 虚拟机实现供应商 
	//	java.vm.name Java 虚拟机实现名称 
	//	java.specification.version Java 运行时环境规范版本 
	//	java.specification.vendor Java 运行时环境规范供应商 
	//	java.specification.name Java 运行时环境规范名称 
	//	java.class.version Java 类格式版本号 
	//	java.class.path Java 类路径 
	//	java.library.path 加载库时搜索的路径列表 
	//	java.io.tmpdir 默认的临时文件路径 
	//	java.compiler 要使用的 JIT 编译器的名称 
	//	java.ext.dirs 一个或多个扩展目录的路径 
	//	os.name 操作系统的名称 
	//	os.arch 操作系统的架构 
	//	os.version 操作系统的版本 
	//	file.separator 文件分隔符（在 UNIX 系统中是“/”） 
	//	path.separator 路径分隔符（在 UNIX 系统中是“:”） 
	//	line.separator 行分隔符（在 UNIX 系统中是“/n”） 
	//	user.name 用户的账户名称 
	//	user.home 用户的主目录 
	//	user.dir 用户的当前工作目录 

	@Test
	public void test_Path() throws IOException {
		String curdir = null;
		curdir = System.getProperty("user.home");
		System.out.println(curdir);
		curdir = System.getProperty("user.dir");
		System.out.println(curdir);
		curdir = System.getProperty("java.io.tmpdir");
		System.out.println(curdir);
		curdir = System.getProperty("java.class.path");
		System.out.println(curdir);
		curdir = System.getProperty("catalina.home");
		System.out.println(curdir);
		curdir = System.getProperty("catalina.base");
		System.out.println(curdir);
		curdir = System.getProperty("webapp.root", "def--默认值");
		System.out.println(curdir);
		Map<String, String> env = System.getenv();
		for (String s : env.keySet()) {
			System.err.println(s + "==========" + env.get(s));
		}
		Properties properties = System.getProperties();
		//打印所有信息 //该方法多用于调式，开发中很少用
		properties.list(System.out);
		//想要将这个集合中的字符串键值信息持久化存储到文件中，需要关联输出流
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "\\Desktop\\info.properties");
		//将集合中的数据存储到文件中，使用store方法
		properties.store(fos, "number+name");//第二个参数表示对这个表的描述，也就是说说明这个表是什么
		fos.close();
		//		Enumeration<Object> allName = properties.keys();
		//		while (allName.hasMoreElements()) {
		//			// 获取每一个名称
		//			String name = (String) allName.nextElement();
		//			// 利用已得到的名称通过资源包获得相应的值
		//			String value = properties.getProperty(name);
		//			System.out.println(name + "============" + value);
		//		}

	}
}
