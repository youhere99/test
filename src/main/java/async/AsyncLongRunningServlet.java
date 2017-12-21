package async;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title.<br>
 * Servlet 3特性：异步Servlet Description.
 * <p>
 * Copyright: Copyright (c) 2016年4月7日 上午10:59:11
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * 
 * @author ZhaoMingxing
 * @version 1.0
 */
@WebServlet(urlPatterns = "/AsyncLongRunningServlet.do", asyncSupported = true)
public class AsyncLongRunningServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long startTime = System.currentTimeMillis();
		System.out.println("AsyncLongRunningServlet Start::Name=" + Thread.currentThread().getName() + "::ID=" + Thread.currentThread().getId());

		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

		String time = request.getParameter("time");
		int secs = Integer.valueOf(time);
		// max 10 seconds
		if (secs > 10000)
			secs = 10000;

		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new AppAsyncListener());
		asyncCtx.setTimeout(9000);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) request.getServletContext().getAttribute("executor");

		executor.execute(new AsyncRequestProcessor(asyncCtx, secs));
		long endTime = System.currentTimeMillis();
		System.out.println("AsyncLongRunningServlet End::Name=" + Thread.currentThread().getName() + "::ID=" + Thread.currentThread().getId()
		        + "::Time Taken=" + (endTime - startTime) + " ms.");
	}

}
