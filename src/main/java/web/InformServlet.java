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
			throw new RuntimeException("���޴�ҳ");
		}
		
	}
	
	protected void toInform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ѯ���е���ѯ
		InformatDao dao = new InformatDao();
		List<Informat> list = dao.findAll();
		
		// ȥ��ѯҳ
		if(list!=null){
			req.setAttribute("informats", list);
		}
		req.getRequestDispatcher("WEB-INF/home/inform.jsp").forward(req, res);
	}
	
	
}
