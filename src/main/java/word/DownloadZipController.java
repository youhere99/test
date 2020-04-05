package word;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ProjectPathListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * Title.<br> 
 * Description.下载工具类
 * <p>
 * Copyright: Copyright (c) 2015年11月4日 上午10:28:25
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
@Controller
@RequestMapping("/download/*")
public class DownloadZipController {

	private final static Logger log = LoggerFactory.getLogger(DownloadZipController.class);

	//未压缩下载
	@RequestMapping("uncompressed.do")
	public void uncompressed(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		String filename = "demo.docx";
		//设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		response.setContentType("multipart/form-data");
		//设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		//读取目标文件，通过response将目标文件写到客户端
		String systemPath = ProjectPathListener.ProjectPATH;
		log.info("system path---------" + systemPath);
		String path = systemPath + "temp\\simple.docx";
		OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(path);
		IOUtils.copy(in, out);
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
	}

	//压缩下载
	@RequestMapping("compressed.do")
	public void compressed(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		String systemPath = ProjectPathListener.ProjectPATH;
		log.info("system path---------" + systemPath);
		String path = systemPath + "temp\\simple.docx";
		String filename = "demo.zip";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		log.info("in BatchDownload................");
		ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		ZipEntry ze = new ZipEntry(f.getName());
		zos.putNextEntry(ze);
		//		byte[] buffer = new byte[1024];
		//		int r = 0;
		//		while ((r = fis.read(buffer)) != -1) {
		//			zos.write(buffer, 0, r);
		//		}

		IOUtils.copy(fis, zos);
		IOUtils.closeQuietly(fis);
		IOUtils.closeQuietly(zos);
	}

	//批量压缩文件下载
	@RequestMapping("batch_file.do")
	public void batch_file(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		String systemPath = ProjectPathListener.ProjectPATH;
		log.info("system path---------" + systemPath);
		Iterator<File> file_list = FileUtils.iterateFiles(new File(systemPath + "temp"), new String[] { "docx" }, false);
		String filename = "demo.zip";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		log.info("in BatchDownload................");
		ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
		FileInputStream fis = null;
		ZipEntry ze = null;
		while (file_list.hasNext()) {
			File file = file_list.next();
			fis = new FileInputStream(file);
			ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);
			IOUtils.copy(fis, zos);
		}
		IOUtils.closeQuietly(fis);

		IOUtils.closeQuietly(zos);

	}

	//批量压缩文件夹下载
	@RequestMapping("batch_folder.do")
	public void batch_folder(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		String systemPath = ProjectPathListener.ProjectPATH;
		log.info("system path---------" + systemPath);
		Iterator<File> file_list = FileUtils.listFilesAndDirs(new File(systemPath + "temp"), null, null).iterator();
		String filename = "demo.zip";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		log.info("in BatchDownload................");
		ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
		FileInputStream fis = null;
		ZipEntry ze = null;
		while (file_list.hasNext()) {
			File file = file_list.next();
			fis = new FileInputStream(file);
			ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);
			IOUtils.copy(fis, zos);
		}
		IOUtils.closeQuietly(fis);
		IOUtils.closeQuietly(zos);

	}
}