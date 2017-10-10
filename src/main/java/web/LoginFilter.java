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
		// ������ǿ��ת��Ϊ������
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		// ��ȡ�û��ĵ�½��Ϣ
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
//		if(session.getAttribute("user") instanceof User){
//			User user = (User)session.getAttribute("user");
//		} 
		// �˴�ʵ�ֹ����û���½
		String p = req.getServletPath();
		String[] paths = new String[]{
				"/home","/login.do","/tologin.do","/land.com","/check.com",
				"/toland.com","/createImg.do","/tobacklogin.cn","/backlogin.cn"};
		for(String path:paths){
			if(path.equals(p)){
				// ��ҳ�͵�½ҳ��ע��ҳ����֤�����ֱ��ִ��
				chain.doFilter(req, res);
				//System.out.println(p);
				return ;
			}
		}
		//System.out.println(user);	
		if(obj==null){
			// û��½�Ӷ��򵽵�½  ����·��
			req.getRequestDispatcher("tologin.do").forward(req, res);
		} else {
			// ��½�ɹ��ļ���ִ������
			chain.doFilter(req, res);
		}
				
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
