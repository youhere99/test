package cdi;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 原文链接：https://blog.csdn.net/ilovewqf/article/details/50482981
 */
@WebServlet("/drink.do")
public class DrinkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private Instance<DrinkShop> drink;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().append("You got a ").append(drink.get().coffee()).append(".");
	}

}
