package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GameDao;
import entity.Game;

public class PaihangServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/topaihang.pai".equals(path)){
			topaihang(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
		
		
	}
	
	public void topaihang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GameDao dao = new GameDao();
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// 获取常量
		String size = getServletContext().getInitParameter("size");
		// 查询资费
		List<Game> list = dao.findBySize(new Integer(page), new Integer(size));
		// System.out.println(list.size());
		// 查询总行数，计算出总页数
		int rows = dao.findRow();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}
		// 转发到查询页面
		req.setAttribute("games", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		// 转发给排行
		req.getRequestDispatcher("WEB-INF/home/paihang.jsp").forward(req, res);
	}
	
}
