package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title.<br> Servlet 3特性：阻塞Servlet
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年4月7日 上午10:47:34
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */

//http://www.test.com:8080/LongRunningServlet?time=8000
@WebServlet("/LongRunningServlet.do")
public class LongRunningServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long startTime = System.currentTimeMillis();
		System.out.println("LongRunningServlet Start::Name=" + Thread.currentThread().getName() + "::ID=" + Thread.currentThread().getId());

		String time = request.getParameter("time");
		int secs = Integer.valueOf(time);
		// max 10 seconds
		if (secs > 10000)
			secs = 10000;

		longProcessing(secs);

		PrintWriter out = response.getWriter();
		long endTime = System.currentTimeMillis();
		out.write("Processing done for " + secs + " milliseconds!!");
		System.out.println("LongRunningServlet Start::Name=" + Thread.currentThread().getName() + "::ID=" + Thread.currentThread().getId()
		        + "::Time Taken=" + (endTime - startTime) + " ms.");
	}

	private void longProcessing(int secs) {
		// wait for given time before finishing
		try {
			Thread.sleep(secs);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
