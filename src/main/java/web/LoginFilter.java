package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 将参数强制转换为子类型
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		// 获取用户的登陆信息
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
//		if(session.getAttribute("user") instanceof User){
//			User user = (User)session.getAttribute("user");
//		} 
		// 此处实现过滤用户登陆
		String p = req.getServletPath();
		String[] paths = new String[]{
				"/home","/login.do","/tologin.do","/land.com","/check.com",
				"/toland.com","/createImg.do","/tobacklogin.cn","/backlogin.cn"};
		for(String path:paths){
			if(path.equals(p)){
				// 主页和登陆页，注册页，验证码加载直接执行
				chain.doFilter(req, res);
				//System.out.println(p);
				return ;
			}
		}
		//System.out.println(user);	
		if(obj==null){
			// 没登陆从定向到登陆  绝对路径
			req.getRequestDispatcher("tologin.do").forward(req, res);
		} else {
			// 登陆成功的继续执行请求
			chain.doFilter(req, res);
		}
				
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
