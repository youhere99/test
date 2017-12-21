package path;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.filechooser.FileSystemView;

import org.junit.Test;

public class FilePathTest {

	@Test
	public void test_File() throws IOException {
		String path = "E:\\MyEclipse 8.5\\qhrccbjob\\WebRoot\\excel\\abc.xls";

		File dir = new File(path); // 文件夹对象
		File f = dir.getAbsoluteFile();
		System.out.println("getAbsoluteFile()" + f);
		String s = dir.getAbsolutePath();
		System.out.println("getAbsolutePath()" + s);
		f = dir.getCanonicalFile();
		System.out.println("getCanonicalFile()" + f);
		long l = dir.getFreeSpace();
		System.out.println("getFreeSpace()" + l);
		s = dir.getParent();
		System.out.println("getParent()" + s);
		f = dir.getParentFile();
		System.out.println("getParentFile()" + f);
		s = dir.getPath();
		System.out.println("getPath();" + s);
		l = dir.getTotalSpace();
		System.out.println("getTotalSpace();" + l);
		l = dir.getUsableSpace();
		System.out.println("getUsableSpace();" + l);
		s = dir.getName();
		System.out.println("getName();" + s);
	}

	/**
	 * 获取硬盘的每个盘符
	 */
	@Test
	public void driver() {
		// 当前文件系统类
		FileSystemView fsv = FileSystemView.getFileSystemView();
		// 列出所有windows 磁盘
		File[] fs = File.listRoots();
		// 显示磁盘卷标
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fsv.getSystemDisplayName(fs[i]));
			System.out.print("总大小" + FormetFileSize(fs[i].getTotalSpace()));
			System.out.println("剩余" + FormetFileSize(fs[i].getFreeSpace()));
		}
	}

	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

}