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
			// ���Թ���
			addWord(req,res);
		} else if("/sayfenye.tan".equals(path)){
			// ��ҳ����
			fenye(req,res);
		} else {
			throw new RuntimeException("���޴�ҳ");
		}
		
	}
	
	/** �������� */
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
	
	/** ��ҳ*/
	protected void fenye(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ȡ�������
				String page = req.getParameter("page");
				if (page == null || page.equals("")) {
					page = "1";
				}
				// ��ȡ����
				String size = getServletContext().getInitParameter("size");
				// ��ѯ�ʷ�
				MessageDao dao = new MessageDao();
				List<Message> list = dao.findByPage(new Integer(page), new Integer(size));
				// System.out.println(list.size());
				// ��ѯ���������������ҳ��
				int rows = dao.findRow();
				int total = rows / new Integer(size);
				if (rows % new Integer(size) != 0) {
					total++;
				}
				// ת������ѯҳ��
				req.setAttribute("message", list);
				req.setAttribute("total", total);
				req.setAttribute("page", page);
				req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
	}
	
	// ȥ��̳ҳ
	protected void toluntan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ��ȡ�������
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// ��ȡ����
		String size = getServletContext().getInitParameter("size");
		//System.out.println(page+size+"wode ");
		// ��ѯ�ʷ�
		MessageDao dao = new MessageDao();
		List<Message> list = dao.findByPage(new Integer(page), new Integer(size));
		// System.out.println(list.size());
		// ��ѯ���������������ҳ��
		int rows = dao.findRow();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}
		// ת������ѯҳ��
		req.setAttribute("message", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
		
		
		//		// ��ѯ��������ת������̳ҳ
//		MessageDao dao = new MessageDao();
//		List<Message> list = dao.findAll();
//		// System.out.println(list);
//		req.setAttribute("message", list);
//		req.getRequestDispatcher("WEB-INF/home/luntan.jsp").forward(req, res);
	}
	
}
