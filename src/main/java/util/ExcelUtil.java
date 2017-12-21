package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtil<T> {

	private final static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * 
	 *功能：生成excel
	 *@param t 集合
	 *@param templatePath 模板路径
	 *@param downloadPath 下载路径
	 *2015年9月24日下午4:46:44 ZhaoMingxing
	 */
	public void exporter(List<T> t, String templatePath, String downloadPath) {
		try (InputStream is = new FileInputStream(templatePath)) {
			try (OutputStream os = new FileOutputStream(downloadPath)) {
				Context context = new Context();
				context.putVar("t", t);
				JxlsHelper.getInstance().processTemplate(is, os, context);
				log.info("Generate excel-----" + downloadPath);
			}
		}
		catch (IOException e) {
			log.trace(e.getMessage());
			e.printStackTrace();
		}
	}
}