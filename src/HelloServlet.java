import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void init(ServletConfig config) {
		System.out.println("init of Hello Servlet@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
//		获取头信息
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.printf("%s\t%s%n",header,value);
        }
		
		try {
			
//			设置不适用缓存
			response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("pragma", "no-cache");
			
//			设置响应格式
			response.setContentType("text/html; charset=UTF-8");
//          response.setCharacterEncoding("UTF-8");
			
			PrintWriter pw = response.getWriter();
			pw.println("<h1>啦啦啦我是卖报的小行家？</h1>");
			response.getWriter().println("<h2>Hello Servlet!</h2>");
			response.getWriter().println(new Date().toLocaleString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
