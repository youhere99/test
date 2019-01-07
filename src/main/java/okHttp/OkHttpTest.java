package okHttp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * description:<br/>
 * https://www.ibm.com/developerworks/cn/java/j-lo-okhttp/index.html
 * https://www.jianshu.com/p/ca8a982a116b
 * 
 * @author zhaomingxing 2018年11月26日
 *
 */
public class OkHttpTest {

	@Test
	public void testSyncGet() throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("http://www.baidu.com").build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("服务器端错误: " + response);
		}

		Headers responseHeaders = response.headers();
		for (int i = 0; i < responseHeaders.size(); i++) {
			System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
		}

		System.out.println(response.body().string());
	}

	@Test
	public void testHeaders() throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("http://www.baidu.com").header("User-Agent", "My super agent")
				.addHeader("Accept", "text/html").build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("服务器端错误: " + response);
		}

		System.out.println(response.header("Server"));
		System.out.println(response.headers("Set-Cookie"));
	}

	/**
	 * POST 请求
	 * 
	 * @throws IOException
	 *             2019年1月7日 zhaomingxing
	 */
	@Test
	public void testPostString() throws IOException {
		OkHttpClient client = new OkHttpClient();
		MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
		String postBody = "Hello World";

		Request request = new Request.Builder().url("http://www.baidu.com")
				.post(RequestBody.create(MEDIA_TYPE_TEXT, postBody)).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("服务器端错误: " + response);
		}

		System.out.println(response.body().string());
	}

	/**
	 * 响应缓存
	 * 
	 * @throws IOException
	 *             2019年1月7日 zhaomingxing
	 */
	@Test
	public void testCacheResponse() throws IOException {
		int cacheSize = 100 * 1024 * 1024;
		File cacheDirectory = Files.createTempDirectory("cache").toFile();
		Cache cache = new Cache(cacheDirectory, cacheSize);
		OkHttpClient client = new OkHttpClient().newBuilder().cache(cache).build();
		Request request = new Request.Builder().url("http://www.baidu.com").build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("服务器端错误: " + response);
		}

		System.out.println(response.cacheResponse());
		System.out.println(response.networkResponse());
	}
}