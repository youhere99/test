package database.backup;

import java.io.File;
import java.io.IOException;

/**
 * 
 * Title.<br> MySQL数据库备份
 * Description.
 * <p>
 * Copyright: Copyright (c) 2015年11月25日 上午10:44:33
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */

public class MySqlDatabaseBackup {

	/**
	 * Java代码实现MySQL数据库导出
	 * 
	 * @author GaoHuanjie
	 * @param hostIP MySQL数据库所在服务器地址IP
	 * @param userName 进入数据库所需要的用户名
	 * @param password 进入数据库所需要的密码
	 * @param savePath 数据库导出文件保存路径
	 * @param fileName 数据库导出文件文件名
	 * @param databaseName 要导出的数据库名
	 * @return 返回true表示导出成功，否则返回false。
	 */
	public static boolean exportDatabaseTool(String hostIP, String port, String userName, String password, String savePath, String fileName,
	        String databaseName) {
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}
		if (!savePath.endsWith(File.separator)) {
			savePath = savePath + File.separator;
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("cmd.exe /c mysqldump").append(" --opt").append(" --host=").append(hostIP).append(" --port=").append(port);
		stringBuilder.append(" --user=").append(userName).append(" --password=").append(password).append(" --lock-all-tables=true");
		stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ").append(" --databases ")
		        .append(databaseName);
		try {
			Process process = Runtime.getRuntime().exec(stringBuilder.toString());
			if (process.waitFor() == 0) {// 0 表示线程正常终止。
				return true;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException {
		//		if (exportDatabaseTool("192.168.2.201", "3306", "root", "root", "C:\\Users\\Administrator\\Desktop\\backupDatabase", "test.sql", "test")) {
		//			System.out.println("数据库备份成功！！！");
		//		} else {
		//			System.out.println("数据库备份失败！！！");
		//		}
		System.out.println(Runtime.getRuntime().maxMemory());//最大可用内存，对应-Xmx 

		System.out.println(Runtime.getRuntime().freeMemory()); //当前JVM空闲内存 

		System.out.println(Runtime.getRuntime().totalMemory()); //当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和 
	}
}