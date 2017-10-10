package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import entity.Message;
import entity.User;

public class LuntanServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/toluntan.tan".equals(path)) {
			toluntan(req,res);
		} else if("/word.tan".equals(path)){
			// 留言功能
			addWord(req,res);
		} else if("/sayfenye.tan".equals(path)){
			// 分页功能
			fenye(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
		
	}
	
	/** 留言请求 */
	protected void addWord(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String word = req.getParameter("word");
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user");
		Message m = new Message();
		m.setNickName(u.getNickName());
		m.setWords(word);
		m.setPath(u.getPhoto());
		MessageDao dao = new MessageDao();
		dao.save(m);
		res.sendRedirect("toluntan.tan");
	}
	
	/** 分页*/
	protected void fenye(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取请求参数
				String page = req.getParameter("page");
				if (page == null || page.equals("")) {
					page = "1";
				}
				// 获取常量
				String size = getServletContext().getInitParameter("size");
				// 查询资费
				MessageDao dao = new MessageDao();
				List<Message> list = dao.findByPage(new Integer(page), new Integer(size));
				// System.out.println(list.size());
				// 查询总行数，计算出总页数
				int rows = dao.findRow();
				int total = rows / new Integer(size);
				if (rows % new Integer(size) != 0) {
					total++;
				}
				// 转发到查询页面
				req.setAttribute("message", list);
				req.setAttribute("total", total);
				req.setAttribute("page", page);
				req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
	}
	
	// 去论坛页
	protected void toluntan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取请求参数
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// 获取常量
		String size = getServletContext().getInitParameter("size");
		//System.out.println(page+size+"wode ");
		// 查询资费
		MessageDao dao = new MessageDao();
		List<Message> list = dao.findByPage(new Integer(page), new Integer(size));
		// System.out.println(list.size());
		// 查询总行数，计算出总页数
		int rows = dao.findRow();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}
		// 转发到查询页面
		req.setAttribute("message", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
		
		
		//		// 查询所有留言转发给论坛页
//		MessageDao dao = new MessageDao();
//		List<Message> list = dao.findAll();
//		// System.out.println(list);
//		req.setAttribute("message", list);
//		req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
	}
	
}
