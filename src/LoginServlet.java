import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		��������鷳��Ҳ����ʹ��һ�仰���棺
		
		response.setContentType("Text/html; charset=UTF-8");
//		�������͵�����������ݻ�ʹ��UTF-8���룬���һ�֪ͨ�����ʹ��UTF-8���뷽ʽ������ʾ����������������ʾ����
//		response.setContentType("charset=UTF-8");
//		�����Ƿ��͵��������������UTF-8����ģ�����������������ֱ��뷽ʽ��ʾ���ܡ� ���Ե����������ʾ���뷽ʽ����UTF-8��ʱ�򣬾ͻῴ�����룬��Ҫ�ֶ��ٽ���һ�����á�
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		/*System.out.println("name:" + name);
		System.out.println("password:" + password);*/
		
//		�ȸ���ISO-8859-1���룬Ȼ����UTF-8���룬�����Ϳ��Եõ���ȷ�����Ĳ�����		
		// byte[] bytes = name.getBytes("ISO-8859-1");
        // name = new String(bytes, "UTF-8");
		
		
		System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " + request.getRequestURL());
        System.out.println("����������������Դ�����֣�ȥ����Э���������: " + request.getRequestURI());
        System.out.println("�������еĲ�������: " + request.getQueryString());
        System.out.println("����������ڵĿͻ�����IP��ַ: " + request.getRemoteAddr());
        System.out.println("����������ڵĿͻ�����������: " + request.getRemoteHost());
        System.out.println("����������ڵĿͻ���ʹ�õ�����˿�: " + request.getRemotePort());
        System.out.println("��������IP��ַ: " + request.getLocalAddr());
        System.out.println("��������������: " + request.getLocalName());
        System.out.println("�õ��ͻ�������ʽ: " + request.getMethod());
		
		/*String html = null;
		
		if("admin".equals(name) && "123".equals(password))
			html = "<div style='color:green'>��¼�ɹ�</div>";
		else
			html="<div style='color:red'>��¼ʧ��</div>";
//		�������ĵ���Ӧ
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(html);
		
		System.out.println("name:" + name);*/
//		��Servlet�н��з������ת�ķ�ʽ��
		if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("success.html").forward(request, response);
        }
//		��Servlet�н��пͻ�����ת�ķ�ʽ��
		else {
/*//			302 ��ʾ��ʱ��ת���ͻ�����ת
        	response.sendRedirect("fail.html");*/
//			301��ʾ������ת
			response.setStatus(301);
			response.setHeader("Location", "fail.html");
        }
	}
}