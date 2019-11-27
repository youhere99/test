package httpcomponents.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import common.SysConstant;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class HttpClientUtil {

    private static final Log log = LogFactory.getLog(HttpClientUtil.class);

    private static final String ULIST = "http://www.cas.com:8090/bg/ucenter/ulist.do?test=request";

    private static final String UINFO = "http://www.cas.com:8090/bg/ucenter/uinfo.do?";

    /**
     * get方式
     * 
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
            // 3.执行getMethod,调用http接口
            httpClient.executeMethod(getMethod);

            // 4.读取内容
            byte[] responseBody = getMethod.getResponseBody();

            // 5.处理返回的内容
            responseMsg = new String(responseBody);
            log.info(responseMsg);

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.释放连接
            getMethod.releaseConnection();
        }
        return responseMsg;
    }

    /**
     * post方式
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String postHttp2(String param1, String param2) {
        String responseMsg = "";

        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        httpClient.getParams().setContentCharset("GBK");

        String url = "http://localhost:8080/UpDown/httpServer";

        // 2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);

        // 3.把参数值放入到PostMethod对象中
        // 方式1：
        /*
         * NameValuePair[] data = { new NameValuePair("param1", param1), new
         * NameValuePair("param2", param2) }; postMethod.setRequestBody(data);
         */

        // 方式2：
        postMethod.addParameter("param1", param1);
        postMethod.addParameter("param2", param2);

        try {
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);// 200

            // 5.读取内容
            responseMsg = postMethod.getResponseBodyAsString().trim();
            log.info(responseMsg);

            // 6.处理返回的内容

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }

    /**
     * https://www.cnblogs.com/keyi/p/8512496.html<br/>
     * //请求体中
     * 
     * @param url
     * @param paramsMap
     * @return
     * @throws ParseException
     * @throws IOException
     *             2018年11月20日 zhaomingxing
     */
    public static String post(String url, Map<String, String> paramsMap) throws ParseException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        // RequestConfig requestConfig =
        // RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
        // .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
        // .setSocketTimeout(60000)// 设置读取数据连接超时时间
        // .build();
        // // 为httpPost实例设置配置
        // httpPost.setConfig(requestConfig);
        // // 设置请求头
        // httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;
        // charset=UTF-8");
        // 请求体中
        // 对象实体属性
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Entry<String, String>> entrySet = paramsMap.entrySet();
        Iterator<Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, String> next = iterator.next();
            params.add(new BasicNameValuePair(next.getKey(), next.getValue()));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, SysConstant.UTF8));
        // 请求体中
        // json实体属性
        // JSONObject json = new JSONObject();
        // json.put("key", "value");
        // httpPost.setEntity(new StringEntity(json.toString(), HTTP.UTF_8));
        CloseableHttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
            || response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
            String string = EntityUtils.toString(response.getEntity(), SysConstant.UTF8);
            log.info("-------------返回的参数 : " + string);
            return string;
        } else {
            throw new RuntimeException("POST请求失败");
        }
    }

    public static String post2(String url, JSONObject params) throws ParseException, IOException {
        StringEntity StringEntity = new StringEntity(params.toJSONString(), ContentType.APPLICATION_JSON);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(StringEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
            || response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
            String string = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
            log.debug("-------------返回的参数 : " + string);
            return string;
        } else {
            throw new RuntimeException("POST请求失败");
        }
    }

    public static void main(String[] args) {
        // System.out.println(postHttp(null, null, "www.bookmall.com", null, null, null,
        // UINFO));
        // String filePath = postHttp(null, 100, null, null, null, null, null, ULIST);
        // downloadHumanActivityRecognitionData(filePath);

    }

    // 远程下载
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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
