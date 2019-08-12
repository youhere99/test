package cdi;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class AddServlet extends HttpServlet {

	@Inject
	private Instance<RandomInt> a;

	@Inject
	private Instance<RandomInt> b;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int a1 = a.get().get();
		int b1 = b.get().get();
		resp.getWriter().append(a1 + "+" + b1 + "=" + (a1 + b1));
	}
}
