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
		// 转发给login.jsp
		String path = req.getServletPath();
		// 登陆过来
		if("/tologin.do".equals(path)){
			req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
		}
		// 请求加载验证码
		if("/createImg.do".equals(path)){
			createImg(req,res);
		}
		
		//System.out.println(111111);
		if("/login.do".equals(path)){
			// 检查验证码
			//System.out.println(22222);
			HttpSession session = req.getSession();
			String imgcode = (String)session.getAttribute("imgcode");
			String code = req.getParameter("code");
			if(imgcode == null || !imgcode.equalsIgnoreCase(code)){// 验证码不匹配
				req.setAttribute("error", "验证码错误");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
				return;
			}
			
			String admin_name = req.getParameter("admin_name");
			String password = req.getParameter("password");
			// 更据名字查询数据库
			UserDao dao = new UserDao();
			User a = dao.findUser(admin_name);
			
			if(a == null){
				req.setAttribute("error", "用户名不存在");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
			} else if(!password.equals(a.getPassword())){
				req.setAttribute("error", "密码错误");
				req.getRequestDispatcher("WEB-INF/denglu/login.jsp").forward(req, res);
			} else {
				// 将登陆正确的用户信息保存
				session.setAttribute("user", a);
				
				// 用户名密码正确  跳转到论坛页
				req.setAttribute("nice", a.getNickName());
				req.getRequestDispatcher("WEB-INF/home/home.jsp").forward(req, res);
			}
			
		}
	}
	/** 加载验证码*/
	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 生产随机验证码和图片
		Object[] objs = ImageUtil.createImage();
		String code = (String)objs[0];
		BufferedImage image = (BufferedImage)objs[1];
		
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", code);
		// 设置图片类型输出
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
		
	}
	
	
}
