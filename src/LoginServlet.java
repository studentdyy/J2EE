import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		如果觉得麻烦，也可以使用一句话代替：
		
		response.setContentType("Text/html; charset=UTF-8");
//		不仅发送到浏览器的内容会使用UTF-8编码，而且还通知浏览器使用UTF-8编码方式进行显示。所以总能正常显示中文
//		response.setContentType("charset=UTF-8");
//		仅仅是发送的浏览器的内容是UTF-8编码的，至于浏览器是用哪种编码方式显示不管。 所以当浏览器的显示编码方式不是UTF-8的时候，就会看到乱码，需要手动再进行一次设置。
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		/*System.out.println("name:" + name);
		System.out.println("password:" + password);*/
		
//		先根据ISO-8859-1解码，然后用UTF-8编码，这样就可以得到正确的中文参数了		
		// byte[] bytes = name.getBytes("ISO-8859-1");
        // name = new String(bytes, "UTF-8");
		
		
		System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());
		
		/*String html = null;
		
		if("admin".equals(name) && "123".equals(password))
			html = "<div style='color:green'>登录成功</div>";
		else
			html="<div style='color:red'>登录失败</div>";
//		返回中文的响应
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(html);
		
		System.out.println("name:" + name);*/
//		在Servlet中进行服务端跳转的方式：
		if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("success.html").forward(request, response);
        }
//		在Servlet中进行客户端跳转的方式：
		else {
/*//			302 表示临时跳转，客户端跳转
        	response.sendRedirect("fail.html");*/
//			301表示永久跳转
			response.setStatus(301);
			response.setHeader("Location", "fail.html");
        }
	}
}