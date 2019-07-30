package test;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TemporaryFolder;

/**
 * 利用Rule扩展JUnit
 * description://https://blog.csdn.net/u013001763/article/details/80256892
 * 
 * @author zhaomingxing 2019年7月30日
 *
 */

public class JunitTest {

	// 创建TemporaryFolder Rule
	// 可以在构造方法上加入路径参数来指定临时目录，否则使用系统临时目录
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testTempFolderRule() throws IOException {
		// 在系统的临时目录下创建文件或者目录，当测试方法执行完毕自动删除
		tempFolder.newFile("test.txt");
		tempFolder.newFolder("test");
	}

	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	@Test
	public void testErrorCollector() {
		errorCollector.addError(new Exception("Test Fail 1"));
		errorCollector.addError(new Throwable("fff"));
	}
}
