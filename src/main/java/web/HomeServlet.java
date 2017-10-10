package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = new String("µÀ”≠∫Í");
		req.setAttribute("costs", name);
		req.getRequestDispatcher("WEB-INF/home/home.jsp").forward(req, res);
	}
	
}
