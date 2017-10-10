package backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.GameDao;
import dao.InformatDao;
import dao.MessageDao;
import dao.UserDao;
import entity.Admin;
import entity.Game;
import entity.Informat;
import entity.Message;
import entity.User;

public class BackServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/tobacklogin.cn".equals(path)){
			// 转发到后台登陆页
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else if("/deleteMsg.cn".equals(path)){
			deleteMsg(req,res);
		} else if("/toBackMsg.cn".equals(path)){
			// 去留言板
			toBackMsg(req,res);
		} else if("/deleteInform.cn".equals(path)){
			deleteInfo(req,res);
		} else if("/addInform.cn".equals(path)){
			addInform(req,res);
		} else if("/toAddinform.cn".equals(path)){
			// 去游戏新闻发布页
			req.getRequestDispatcher("WEB-INF/back/addInform.jsp").forward(req, res);
		} else if("/tobackInform.cn".equals(path)){
			// 去咨询信息管理页
			toBackInform(req,res);
		} else if("/deleteUser.cn".equals(path)){
			deleteUser(req,res);
		} else if("/addUser.cn".equals(path)){
			// 添加请求
			addUser(req,res);
		} else if("/toAddUser.cn".equals(path)){
			// 去用户添加页
			req.getRequestDispatcher("WEB-INF/back/addUser.jsp").forward(req, res);
		} else if("/tobackUser.cn".equals(path)){
			// 去管理用户信息页
			toBackUser(req,res);
		} else if("/deleteAdmin.cn".equals(path)){
			deleteAdmin(req,res);
		} else if("/toAddAdmin.cn".equals(path)){
			// 去添加管理员页
			req.getRequestDispatcher("WEB-INF/back/addAdmin.jsp").forward(req, res);
		} else if("/addAdmin.cn".equals(path)){
			// 添加一个管理员
			addAdmin(req,res);
		} else if("/deletegame.cn".equals(path)){
			deleteGame(req,res);
		} else if("/toAddgame.cn".equals(path)){
			// 去游戏发布页
			req.getRequestDispatcher("WEB-INF/back/addgame.jsp").forward(req, res);
		} else if("/addgames.cn".equals(path)){
			// 发布游戏请求
			addGame(req,res);
		} else if("/toControlGame.cn".equals(path)){
			// 去游戏管理页
			controlGame(req,res);
		} else if("/backlogin.cn".equals(path)){
			// 后台登陆请求
			backlogin(req,res);
		} else if("/backIndex.cn".equals(path)){
			// 后台管理页
			backIndex(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
		
	}
	
	// 删除留言
	protected void deleteMsg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(req.getParameter("id"));
		MessageDao dao = new MessageDao();
		dao.deleteMsg(id);
		res.sendRedirect("toBackMsg.cn");
	}
	
	// 去查看留言板
	protected void toBackMsg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MessageDao dao = new MessageDao();
		List<Message> list = dao.findAll();
		req.setAttribute("mess", list);
		req.getRequestDispatcher("WEB-INF/back/backMsg.jsp").forward(req, res);
	}
	
	// 删除一条咨询
	protected void deleteInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		InformatDao dao = new InformatDao();
		dao.deleteInfo(id);
		res.sendRedirect("tobackInform.cn");
	}
	
	// 发布游戏资讯请求
	protected void addInform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String inform = req.getParameter("inform");
		String img = req.getParameter("img");
		Informat info = new Informat();
		info.setName(name);
		info.setInform(inform);
		info.setImg(img);
		InformatDao dao = new InformatDao();
		dao.addInform(info);
		res.sendRedirect("tobackInform.cn");
	}
	
	// 去新闻信息页
	protected void toBackInform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		InformatDao dao = new InformatDao();
		List<Informat> list = dao.findAll();
		req.setAttribute("inform", list);		
		req.getRequestDispatcher("WEB-INF/back/backInform.jsp").forward(req, res);
	}
	
	// 删除一个用户
	protected void deleteUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		UserDao dao = new UserDao();
		dao.deleteUser(id);
		res.sendRedirect("tobackUser.cn");
	}
	
	// 用户增加请求
	protected void addUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String nickName = req.getParameter("nickName");
		String pwd = req.getParameter("pwd");
		String games = req.getParameter("games");
		User u = new User();
		u.setEmail(email);
		u.setNickName(nickName);
		u.setPassword(pwd);
		u.setGames(games);
		UserDao dao = new UserDao();
		dao.addUser(u);
		res.sendRedirect("tobackUser.cn");
	}
	
	// 去用户信息列表
	protected void toBackUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 查询出所有的用户信息
		UserDao dao = new UserDao();
		List<User> list = dao.findAll();
		req.setAttribute("users", list);
		req.getRequestDispatcher("WEB-INF/back/backUser.jsp").forward(req, res);
	}
	
	// 删除一个管理员
	protected void deleteAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		AdminDao dao = new AdminDao();
		dao.deleteAdmin(id);
		res.sendRedirect("backIndex.cn");
	}
	
	// 增加管理员
	protected void addAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String power = req.getParameter("power");
		Admin admin = new Admin();
		admin.setAdmin_name(name);
		admin.setAdmin_password(pwd);
		admin.setPower(power);
		// 下面是数据库操作
		AdminDao dao = new AdminDao();
		dao.addAdmin(admin);
		res.sendRedirect("backIndex.cn");
	}
	
	// 删除游戏
	protected void deleteGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		GameDao dao = new GameDao();
		if(id!=null){
			dao.deleteByID(id);
		}
		res.sendRedirect("toControlGame.cn");
	}
	
	// 发布游戏请求
	protected void addGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String rank = req.getParameter("rank");
		String type = req.getParameter("type");
		String describe = req.getParameter("describe");
		String img = req.getParameter("img");
		Game g = new Game();
		g.setName(name);
		g.setGameType(type);
		g.setRank(Integer.parseInt(rank));
		g.setInform(describe);
		g.setGameImg(img);
		GameDao dao = new GameDao();
		dao.addGame(g);
		res.sendRedirect("toControlGame.cn");
	}
	
	// 管理游戏页
	protected void controlGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GameDao dao = new GameDao();
		List<Game> list = dao.findAllGame();
		req.setAttribute("allGame", list);
		req.getRequestDispatcher("WEB-INF/back/gameBack.jsp").forward(req, res);
	}
	
	
	protected void backlogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 处理登陆提交请求
		// 检查验证码
		HttpSession session = req.getSession();
		String imgcode = (String)session.getAttribute("imgcode");
		String code = req.getParameter("code");
		if(imgcode == null || !imgcode.equalsIgnoreCase(code)){// 验证码不匹配
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
			return;
		}
		
		String admin_name = req.getParameter("admin_name");
		String password = req.getParameter("password");
		// 更据名字查询数据库
		AdminDao dao = new AdminDao();
		Admin a = dao.findAdmin(admin_name);
		
		if(a == null){
			req.setAttribute("error", "此管理员不存在");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else if(!password.equals(a.getAdmin_password())){
			req.setAttribute("error", "密码错误");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else {
			// 将登陆正确的管理员信息保存
			session.setAttribute("user", a);
			
			// 用户名密码正确  跳转到后台页
			res.sendRedirect("backIndex.cn");
		}
	}
	// 后台管理员页
	protected void backIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminDao adao = new AdminDao();
		List<Admin> list = adao.findAll();
		req.setAttribute("admins", list);
		req.getRequestDispatcher("WEB-INF/back/backstage.jsp").forward(req, res);
	}
	
}
