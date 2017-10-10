package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.MessageDao;
import dao.UserDao;
import entity.User;

public class LandServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 转发给land.jsp
		String path = req.getServletPath();
		// System.out.println(path);
		if("/toland.com".equals(path)){
			req.getRequestDispatcher("WEB-INF/denglu/land.jsp").forward(req, res);
		} else if("/check.com".equals(path)){
			// 验证是否被注册
			check(req,res);
		} else if("/land.com".equals(path)) {
			// 注册请求页面处理
			land(req,res);
			
			/** 拿到用户注册的信息  先放着  以后做~*/
			
		} else if("/toAmend.com".equals(path)){
			// 去修改页
			req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
		} else if("/amend.com".equals(path)){
			// 修改照片请求
			amend(req,res);
		} else if("/amends.com".equals(path)){
			//  修改信息请求
			amends(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
	}
	
	// 注册请求
	protected void land(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String nickName = req.getParameter("nickname");
		String password = req.getParameter("password");
		System.out.println(email+nickName+password);
		User u = new User();
		u.setEmail(email);
		u.setNickName(nickName);
		u.setPassword(password);
		UserDao dao = new UserDao();
		dao.save(u);
		res.sendRedirect("tologin.do");
	}
	
	// 验证邮箱是否被注册
	protected void check(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String email = req.getParameter("email");
		UserDao dao = new UserDao();
		boolean bool = false;// 没有
		try {
			bool = dao.check(email);
		} catch (Exception e) {
		
		}
		if(bool){
			out.println("邮箱已被注册");
		} else {
			String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
			if(email.matches(regex)){
				out.println("邮箱可用");
			} else {
				out.println("邮箱不合法");
			}
		}
	}	
	// 修改信息请求
	protected void amends(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String nickName = req.getParameter("nickname");
		String password = req.getParameter("password");
		String game = req.getParameter("text");
		// 利用session获取玩家对象
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user");
		
		MessageDao md = new MessageDao();
		md.updateWords(u.getNickName(),nickName);

		u.setNickName(nickName);
		u.setPassword(password);
		u.setGames(game);
		UserDao dao = new UserDao();
		dao.update(u);
		res.sendRedirect("toluntan.tan");
		
	}
	
	// 修改图片请求
	protected void amend(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		res.setContentType("text/html;charset=utf-8");
//		// 为解析类提供配置信息
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		// 创建解析类的实例
//		ServletFileUpload sfu = new ServletFileUpload(factory);
//		// 开始解析
//		sfu.setFileSizeMax(1024 * 400);
//		// 每个表单域中数据会封装到一个对应的FileItem对象上
//		try {
//			List<FileItem> items = sfu.parseRequest(req);
//			// 区分表单域
//			for (int i = 0; i < items.size(); i++) {
//				FileItem item = items.get(i);
//				// isFormField为true，表示这不是文件上传表单域
//				if (item.isFormField()) {
//					ServletContext sctx = getServletContext();
//					// 获得存放文件的物理路径
//					// upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹
//
//					String path = sctx.getRealPath("/upload");
//					System.out.println(path);
//					// 获得文件名
//					String fileName = item.getName();
//					System.out.println(fileName);
//					// 该方法在某些平台(操作系统),会返回路径+文件名
//					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
//					File file = new File(path + "\\" + fileName);
//					if (!file.exists()) {
//						item.write(file);
//						// 将上传图片的名字记录到数据库中
//
//						res.sendRedirect("/upload/ok.html");
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		//		  //保存的图片的名称  
//		req.setCharacterEncoding("utf-8");
//        String fileName =System.currentTimeMillis() + ".jpg";    
//       //获得imge文件夹在tomcat中的决定路径，basePath的值是C:\Program Files\Apache Software Foundation\Apache Tomcat 6.0.20\webapps\flexTest\imge  
//        String basePath = req.getSession().getServletContext().getRealPath("/img/");  
//        System.out.println("保存图片的地址为："+basePath);  
//        //String realFilePath = basePath+"\\"+fileName;  
//        // 获得一个图片文件流，我这里是从flex中传过来的  
//        BufferedImage bufferedImage = ImageIO.read(req.getInputStream());    
//        System.out.println(bufferedImage);
//        if (bufferedImage != null) {    
//           //保存图片到指定的目录和文件中  
//    	   System.out.println(11111);
//           ImageIO.write(bufferedImage, "jpg", new File(basePath , fileName));    
//       }  
		
		
			// 取出登录的账号
			HttpSession session = req.getSession();
			User u = (User)session.getAttribute("user");
			// 修改用户信息
	        res.setContentType("text/html;charset=utf-8");
	        // step1,创建一个DiskFileItemFactory对象
	        // 为解析器提供解析时的缺省的配置。
	        DiskFileItemFactory dfif = new DiskFileItemFactory();
	        // step2,创建一个解析器
	        ServletFileUpload sfu = new ServletFileUpload(dfif);
	        sfu.setHeaderEncoding("utf-8");
	        // step3,使用解析器解析
	        try {
	            // FileItem对象封装了一个表单域当中的所有的
	            // 数据。
	            List<FileItem> items = sfu.parseRequest(req);
	            if(items==null){
	            	req.setAttribute("cuowu", "没有选中图片");
	            	req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
	            }
	            for (int i = 0; i < items.size(); i++) {
	                FileItem item = items.get(i);
	                // 要判断是一个普通的表单域还是
	                // 上传文件域
	                if (item.isFormField()) {
	                    // 是一个普通的表单域
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    System.out.println(name + ":" + value);
	                } else {
	                    // 上传文件域,要将文件保存在服务器端
	                    ServletContext sc = this.getServletContext();
	                    // 获得实际部署时物理路径
	                    String path = sc.getRealPath("img");
	                    System.out.println(path);
	                    // 获得上传文件的名称
	                    String fileName = item.getName();
	                    System.out.println(fileName);
	                    // 修改图像
	                    u.setPhoto("img/"+fileName);
	                    File file = new File(path + "//" + fileName);
	                    System.out.println(file);
	                    item.write(file);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        // 修改
	        MessageDao dao = new MessageDao();
	        dao.updateImg(u.getNickName(), u.getPhoto());
	        req.setAttribute("img", u.getPhoto());
	        req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
	       // req.getRequestDispatcher("WEB-INF/home/home.jsp").forward(req, res);
	        
	}
	
	
}
