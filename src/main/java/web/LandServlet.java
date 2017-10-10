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
		// ת����land.jsp
		String path = req.getServletPath();
		// System.out.println(path);
		if("/toland.com".equals(path)){
			req.getRequestDispatcher("WEB-INF/denglu/land.jsp").forward(req, res);
		} else if("/check.com".equals(path)){
			// ��֤�Ƿ�ע��
			check(req,res);
		} else if("/land.com".equals(path)) {
			// ע������ҳ�洦��
			land(req,res);
			
			/** �õ��û�ע�����Ϣ  �ȷ���  �Ժ���~*/
			
		} else if("/toAmend.com".equals(path)){
			// ȥ�޸�ҳ
			req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
		} else if("/amend.com".equals(path)){
			// �޸���Ƭ����
			amend(req,res);
		} else if("/amends.com".equals(path)){
			//  �޸���Ϣ����
			amends(req,res);
		} else {
			throw new RuntimeException("���޴�ҳ");
		}
	}
	
	// ע������
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
	
	// ��֤�����Ƿ�ע��
	protected void check(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String email = req.getParameter("email");
		UserDao dao = new UserDao();
		boolean bool = false;// û��
		try {
			bool = dao.check(email);
		} catch (Exception e) {
		
		}
		if(bool){
			out.println("�����ѱ�ע��");
		} else {
			String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
			if(email.matches(regex)){
				out.println("�������");
			} else {
				out.println("���䲻�Ϸ�");
			}
		}
	}	
	// �޸���Ϣ����
	protected void amends(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String nickName = req.getParameter("nickname");
		String password = req.getParameter("password");
		String game = req.getParameter("text");
		// ����session��ȡ��Ҷ���
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
	
	// �޸�ͼƬ����
	protected void amend(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		res.setContentType("text/html;charset=utf-8");
//		// Ϊ�������ṩ������Ϣ
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		// �����������ʵ��
//		ServletFileUpload sfu = new ServletFileUpload(factory);
//		// ��ʼ����
//		sfu.setFileSizeMax(1024 * 400);
//		// ÿ�����������ݻ��װ��һ����Ӧ��FileItem������
//		try {
//			List<FileItem> items = sfu.parseRequest(req);
//			// ���ֱ���
//			for (int i = 0; i < items.size(); i++) {
//				FileItem item = items.get(i);
//				// isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ�����
//				if (item.isFormField()) {
//					ServletContext sctx = getServletContext();
//					// ��ô���ļ�������·��
//					// upload�µ�ĳ���ļ��� �õ���ǰ���ߵ��û� �ҵ���Ӧ���ļ���
//
//					String path = sctx.getRealPath("/upload");
//					System.out.println(path);
//					// ����ļ���
//					String fileName = item.getName();
//					System.out.println(fileName);
//					// �÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���
//					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
//					File file = new File(path + "\\" + fileName);
//					if (!file.exists()) {
//						item.write(file);
//						// ���ϴ�ͼƬ�����ּ�¼�����ݿ���
//
//						res.sendRedirect("/upload/ok.html");
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		//		  //�����ͼƬ������  
//		req.setCharacterEncoding("utf-8");
//        String fileName =System.currentTimeMillis() + ".jpg";    
//       //���imge�ļ�����tomcat�еľ���·����basePath��ֵ��C:\Program Files\Apache Software Foundation\Apache Tomcat 6.0.20\webapps\flexTest\imge  
//        String basePath = req.getSession().getServletContext().getRealPath("/img/");  
//        System.out.println("����ͼƬ�ĵ�ַΪ��"+basePath);  
//        //String realFilePath = basePath+"\\"+fileName;  
//        // ���һ��ͼƬ�ļ������������Ǵ�flex�д�������  
//        BufferedImage bufferedImage = ImageIO.read(req.getInputStream());    
//        System.out.println(bufferedImage);
//        if (bufferedImage != null) {    
//           //����ͼƬ��ָ����Ŀ¼���ļ���  
//    	   System.out.println(11111);
//           ImageIO.write(bufferedImage, "jpg", new File(basePath , fileName));    
//       }  
		
		
			// ȡ����¼���˺�
			HttpSession session = req.getSession();
			User u = (User)session.getAttribute("user");
			// �޸��û���Ϣ
	        res.setContentType("text/html;charset=utf-8");
	        // step1,����һ��DiskFileItemFactory����
	        // Ϊ�������ṩ����ʱ��ȱʡ�����á�
	        DiskFileItemFactory dfif = new DiskFileItemFactory();
	        // step2,����һ��������
	        ServletFileUpload sfu = new ServletFileUpload(dfif);
	        sfu.setHeaderEncoding("utf-8");
	        // step3,ʹ�ý���������
	        try {
	            // FileItem�����װ��һ�������е����е�
	            // ���ݡ�
	            List<FileItem> items = sfu.parseRequest(req);
	            if(items==null){
	            	req.setAttribute("cuowu", "û��ѡ��ͼƬ");
	            	req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
	            }
	            for (int i = 0; i < items.size(); i++) {
	                FileItem item = items.get(i);
	                // Ҫ�ж���һ����ͨ�ı�����
	                // �ϴ��ļ���
	                if (item.isFormField()) {
	                    // ��һ����ͨ�ı���
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    System.out.println(name + ":" + value);
	                } else {
	                    // �ϴ��ļ���,Ҫ���ļ������ڷ�������
	                    ServletContext sc = this.getServletContext();
	                    // ���ʵ�ʲ���ʱ����·��
	                    String path = sc.getRealPath("img");
	                    System.out.println(path);
	                    // ����ϴ��ļ�������
	                    String fileName = item.getName();
	                    System.out.println(fileName);
	                    // �޸�ͼ��
	                    u.setPhoto("img/"+fileName);
	                    File file = new File(path + "//" + fileName);
	                    System.out.println(file);
	                    item.write(file);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        // �޸�
	        MessageDao dao = new MessageDao();
	        dao.updateImg(u.getNickName(), u.getPhoto());
	        req.setAttribute("img", u.getPhoto());
	        req.getRequestDispatcher("WEB-INF/denglu/amend.jsp").forward(req, res);
	       // req.getRequestDispatcher("WEB-INF/home/home.jsp").forward(req, res);
	        
	}
	
	
}
