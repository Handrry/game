package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;
import util.ImageUtil;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ת����login.jsp
		String path = req.getServletPath();
		// ��½����
		if("/tologin.do".equals(path)){
			req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
		}
		// ���������֤��
		if("/createImg.do".equals(path)){
			createImg(req,res);
		}
		
		//System.out.println(111111);
		if("/login.do".equals(path)){
			// �����֤��
			//System.out.println(22222);
			HttpSession session = req.getSession();
			String imgcode = (String)session.getAttribute("imgcode");
			String code = req.getParameter("code");
			if(imgcode == null || !imgcode.equalsIgnoreCase(code)){// ��֤�벻ƥ��
				req.setAttribute("error", "��֤�����");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
				return;
			}
			
			String admin_name = req.getParameter("admin_name");
			String password = req.getParameter("password");
			// �������ֲ�ѯ���ݿ�
			UserDao dao = new UserDao();
			User a = dao.findUser(admin_name);
			
			if(a == null){
				req.setAttribute("error", "�û���������");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
			} else if(!password.equals(a.getPassword())){
				req.setAttribute("error", "�������");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
			} else {
				// ����½��ȷ���û���Ϣ����
				session.setAttribute("user", a);
				
				// �û���������ȷ  ��ת����̳ҳ
				req.setAttribute("nice", a.getNickName());
				req.getRequestDispatcher("WEB-INF/home/home.jsp").forward(req, res);
			}
			
		}
	}
	/** ������֤��*/
	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���������֤���ͼƬ
		Object[] objs = ImageUtil.createImage();
		String code = (String)objs[0];
		BufferedImage image = (BufferedImage)objs[1];
		
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", code);
		// ����ͼƬ�������
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
		
	}
	
	
}
