package createPatch;

import java.io.IOException;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/** notice :暂时没想到好的办法
 * 
 * Title.<br> 
 * Description.导出java编译后的class按目录结构存放
 * <p>
 * Copyright: Copyright (c) 2016年1月8日 下午4:44:55
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class ExportIncrementFiles {

	public static final String incrementalFiles = "C:/Users/Administrator/Desktop/sso_java_Patch/src/";//增量文件java包

	public static final String classPath = "D:/workspaces/MyEclipse Professional 2014/sso/WebRoot/WEB-INF/classes/";//class存放路径  

	public static final String patchPath = "C:/Users/Administrator/Desktop/sso_class_patch/";//补丁文件包存放路径  

	public static final String version = "1.1";//补丁版本  

	public static void complier() throws IOException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList("Foo.java"));
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
		boolean success = task.call();
		fileManager.close();
		System.out.println("Success: " + success);
	}

}
