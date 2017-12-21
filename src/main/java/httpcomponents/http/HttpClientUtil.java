package httpcomponents.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClientUtil {

	private static final Log log = LogFactory.getLog(HttpClientUtil.class);

	private static final String ULIST = "http://www.cas.com:8090/bg/ucenter/ulist.do?test=request";

	private static final String UINFO = "http://www.cas.com:8090/bg/ucenter/uinfo.do?";

	/**
	 * get方式
	 * @param param1
	 * @param param2
	 * @return
	*/
	public static String getHttp(String param1, String param2) {
		String responseMsg = "";

		// 1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();

		// 用于测试的http接口的url
		String url = "http://localhost:8080/UpDown/httpServer?param1=" + param1 + "&param2=" + param2;

		// 2.创建GetMethod的实例
		GetMethod getMethod = new GetMethod(url);

		// 使用系统系统的默认的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		try {
			//3.执行getMethod,调用http接口
			httpClient.executeMethod(getMethod);

			//4.读取内容
			byte[] responseBody = getMethod.getResponseBody();

			//5.处理返回的内容
			responseMsg = new String(responseBody);
			log.info(responseMsg);

		}
		catch (HttpException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//6.释放连接
			getMethod.releaseConnection();
		}
		return responseMsg;
	}

	/**
	 * post方式 
	 * @param param1 
	 * @param param2
	 * @return
	*/
	public static String postHttp2(String param1, String param2) {
		String responseMsg = "";

		//1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();

		httpClient.getParams().setContentCharset("GBK");

		String url = "http://localhost:8080/UpDown/httpServer";

		//2.构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);

		//3.把参数值放入到PostMethod对象中
		//方式1：
		/*        NameValuePair[] data = { new NameValuePair("param1", param1),
		                new NameValuePair("param2", param2) };
		        postMethod.setRequestBody(data);*/

		//方式2：    
		postMethod.addParameter("param1", param1);
		postMethod.addParameter("param2", param2);

		try {
			// 4.执行postMethod,调用http接口
			httpClient.executeMethod(postMethod);//200

			//5.读取内容
			responseMsg = postMethod.getResponseBodyAsString().trim();
			log.info(responseMsg);

			//6.处理返回的内容

		}
		catch (HttpException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//7.释放连接
			postMethod.releaseConnection();
		}
		return responseMsg;
	}

	/**
	 * post方式 
	 * @param param1 
	 * @param param2
	 * @return
	*/
	public static String postHttp(Integer pageNO, Integer pageSize, String username, String email, String realname, String phone, Integer id,
	        String reqestUrl) {
		String responseMsg = "";
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");
		PostMethod postMethod = new PostMethod(reqestUrl);
		StringBuilder sb = new StringBuilder();
		try {
			for (int i = 0; i <= pageSize; i++) {
				sb.append(i + ",");
			}
			System.err.println(sb.toString());
			postMethod.addParameter("username", sb.toString());
			postMethod.addParameter("pageSize", pageSize.toString());
			postMethod.addParameter("last_loginTime_end", new Date().getTime() + "");
			httpClient.executeMethod(postMethod);//200
			responseMsg = postMethod.getResponseBodyAsString().trim();
			log.info(responseMsg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			postMethod.releaseConnection();
		}
		return responseMsg;
	}

	public static String postHttp(Integer pageNO, Integer pageSize, String hostname, String email, String realname, String phone, String reqestUrl) {
		String responseMsg = "";
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");
		PostMethod postMethod = new PostMethod(reqestUrl);
		try {
			postMethod.addParameter("last_loginTime_end", new Date().getTime() + "");
			postMethod.addParameter("hostname", hostname);
			//			postMethod.addParameter("email", email);
			//			postMethod.addParameter("phone", phone);
			httpClient.executeMethod(postMethod);//200
			responseMsg = postMethod.getResponseBodyAsString().trim();
			log.info(responseMsg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			postMethod.releaseConnection();
		}
		return responseMsg;
	}

	public static void main(String[] args) {
		//		System.out.println(postHttp(null, null, "www.bookmall.com", null, null, null, UINFO));
		String filePath = postHttp(null, 100, null, null, null, null, null, ULIST);
		downloadHumanActivityRecognitionData(filePath);

	}

	//远程下载
	public static void downloadHumanActivityRecognitionData(String filepath) {
		InputStream is = null;
		try {
			URL website = new URL(filepath);
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setFileNameInZip("yourfilename.xls");
			parameters.setSourceExternalStream(true);
			ZipFile zipFile = new ZipFile("C:\\Users\\Administrator\\Desktop\\data.zip");
			is = website.openStream();
			zipFile.addStream(is, parameters);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (is != null) {
				try {
					is.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
