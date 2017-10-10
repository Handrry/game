package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GameDao;
import entity.Game;

public class FenleiServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/tofenlei.fen".equals(path)){
			tofenlei(req,res);
		} else if("/todetail.fen".equals(path)){
			toDetail(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
		
	}
	
	protected void toDetail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 去详情页
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		GameDao dao = new GameDao();
		Game game = dao.findByName(name);
		req.setAttribute("game", game);
		req.getRequestDispatcher("WEB-INF/home/detail.jsp").forward(req, res);
	}
	
	/**
	 * 去分类页
	 * */
	protected void tofenlei(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GameDao dao = new GameDao();
		List<Game> list1 = dao.findAllName("冒险");
		List<Game> list2 = dao.findAllName("动作");
		List<Game> list3 = dao.findAllName("棋牌");
		List<Game> list4 = dao.findAllName("射击");
		req.setAttribute("risk", list1);
		req.setAttribute("action", list2);
		req.setAttribute("chess", list3);
		req.setAttribute("shoot", list4);
		req.getRequestDispatcher("WEB-INF/home/fenlei.jsp").forward(req, res);
	}
	
}
