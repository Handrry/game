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
			// ת������̨��½ҳ
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else if("/deleteMsg.cn".equals(path)){
			deleteMsg(req,res);
		} else if("/toBackMsg.cn".equals(path)){
			// ȥ���԰�
			toBackMsg(req,res);
		} else if("/deleteInform.cn".equals(path)){
			deleteInfo(req,res);
		} else if("/addInform.cn".equals(path)){
			addInform(req,res);
		} else if("/toAddinform.cn".equals(path)){
			// ȥ��Ϸ���ŷ���ҳ
			req.getRequestDispatcher("WEB-INF/back/addInform.jsp").forward(req, res);
		} else if("/tobackInform.cn".equals(path)){
			// ȥ��ѯ��Ϣ����ҳ
			toBackInform(req,res);
		} else if("/deleteUser.cn".equals(path)){
			deleteUser(req,res);
		} else if("/addUser.cn".equals(path)){
			// �������
			addUser(req,res);
		} else if("/toAddUser.cn".equals(path)){
			// ȥ�û����ҳ
			req.getRequestDispatcher("WEB-INF/back/addUser.jsp").forward(req, res);
		} else if("/tobackUser.cn".equals(path)){
			// ȥ�����û���Ϣҳ
			toBackUser(req,res);
		} else if("/deleteAdmin.cn".equals(path)){
			deleteAdmin(req,res);
		} else if("/toAddAdmin.cn".equals(path)){
			// ȥ��ӹ���Աҳ
			req.getRequestDispatcher("WEB-INF/back/addAdmin.jsp").forward(req, res);
		} else if("/addAdmin.cn".equals(path)){
			// ���һ������Ա
			addAdmin(req,res);
		} else if("/deletegame.cn".equals(path)){
			deleteGame(req,res);
		} else if("/toAddgame.cn".equals(path)){
			// ȥ��Ϸ����ҳ
			req.getRequestDispatcher("WEB-INF/back/addgame.jsp").forward(req, res);
		} else if("/addgames.cn".equals(path)){
			// ������Ϸ����
			addGame(req,res);
		} else if("/toControlGame.cn".equals(path)){
			// ȥ��Ϸ����ҳ
			controlGame(req,res);
		} else if("/backlogin.cn".equals(path)){
			// ��̨��½����
			backlogin(req,res);
		} else if("/backIndex.cn".equals(path)){
			// ��̨����ҳ
			backIndex(req,res);
		} else {
			throw new RuntimeException("���޴�ҳ");
		}
		
	}
	
	// ɾ������
	protected void deleteMsg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(req.getParameter("id"));
		MessageDao dao = new MessageDao();
		dao.deleteMsg(id);
		res.sendRedirect("toBackMsg.cn");
	}
	
	// ȥ�鿴���԰�
	protected void toBackMsg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MessageDao dao = new MessageDao();
		List<Message> list = dao.findAll();
		req.setAttribute("mess", list);
		req.getRequestDispatcher("WEB-INF/back/backMsg.jsp").forward(req, res);
	}
	
	// ɾ��һ����ѯ
	protected void deleteInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		InformatDao dao = new InformatDao();
		dao.deleteInfo(id);
		res.sendRedirect("tobackInform.cn");
	}
	
	// ������Ϸ��Ѷ����
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
	
	// ȥ������Ϣҳ
	protected void toBackInform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		InformatDao dao = new InformatDao();
		List<Informat> list = dao.findAll();
		req.setAttribute("inform", list);		
		req.getRequestDispatcher("WEB-INF/back/backInform.jsp").forward(req, res);
	}
	
	// ɾ��һ���û�
	protected void deleteUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		UserDao dao = new UserDao();
		dao.deleteUser(id);
		res.sendRedirect("tobackUser.cn");
	}
	
	// �û���������
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
	
	// ȥ�û���Ϣ�б�
	protected void toBackUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ѯ�����е��û���Ϣ
		UserDao dao = new UserDao();
		List<User> list = dao.findAll();
		req.setAttribute("users", list);
		req.getRequestDispatcher("WEB-INF/back/backUser.jsp").forward(req, res);
	}
	
	// ɾ��һ������Ա
	protected void deleteAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		AdminDao dao = new AdminDao();
		dao.deleteAdmin(id);
		res.sendRedirect("backIndex.cn");
	}
	
	// ���ӹ���Ա
	protected void addAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String power = req.getParameter("power");
		Admin admin = new Admin();
		admin.setAdmin_name(name);
		admin.setAdmin_password(pwd);
		admin.setPower(power);
		// ���������ݿ����
		AdminDao dao = new AdminDao();
		dao.addAdmin(admin);
		res.sendRedirect("backIndex.cn");
	}
	
	// ɾ����Ϸ
	protected void deleteGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		GameDao dao = new GameDao();
		if(id!=null){
			dao.deleteByID(id);
		}
		res.sendRedirect("toControlGame.cn");
	}
	
	// ������Ϸ����
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
	
	// ������Ϸҳ
	protected void controlGame(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GameDao dao = new GameDao();
		List<Game> list = dao.findAllGame();
		req.setAttribute("allGame", list);
		req.getRequestDispatcher("WEB-INF/back/gameBack.jsp").forward(req, res);
	}
	
	
	protected void backlogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �����½�ύ����
		// �����֤��
		HttpSession session = req.getSession();
		String imgcode = (String)session.getAttribute("imgcode");
		String code = req.getParameter("code");
		if(imgcode == null || !imgcode.equalsIgnoreCase(code)){// ��֤�벻ƥ��
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
			return;
		}
		
		String admin_name = req.getParameter("admin_name");
		String password = req.getParameter("password");
		// �������ֲ�ѯ���ݿ�
		AdminDao dao = new AdminDao();
		Admin a = dao.findAdmin(admin_name);
		
		if(a == null){
			req.setAttribute("error", "�˹���Ա������");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else if(!password.equals(a.getAdmin_password())){
			req.setAttribute("error", "�������");
			req.getRequestDispatcher("WEB-INF/back/backlogin.jsp").forward(req, res);
		} else {
			// ����½��ȷ�Ĺ���Ա��Ϣ����
			session.setAttribute("user", a);
			
			// �û���������ȷ  ��ת����̨ҳ
			res.sendRedirect("backIndex.cn");
		}
	}
	// ��̨����Աҳ
	protected void backIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminDao adao = new AdminDao();
		List<Admin> list = adao.findAll();
		req.setAttribute("admins", list);
		req.getRequestDispatcher("WEB-INF/back/backstage.jsp").forward(req, res);
	}
	
}
