package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InformatDao;
import entity.Informat;

public class InformServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		
		if("/toInform.in".equals(path)){
			toInform(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
		
	}
	
	protected void toInform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 查询所有的咨询
		InformatDao dao = new InformatDao();
		List<Informat> list = dao.findAll();
		
		// 去咨询页
		if(list!=null){
			req.setAttribute("informats", list);
		}
		req.getRequestDispatcher("WEB-INF/home/inform.jsp").forward(req, res);
	}
	
	
}
