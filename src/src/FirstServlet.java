package src;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
// Servlet必须继承HttpServlet类
@WebServlet(name="firstServlet"
	, urlPatterns={"/firstServlet"})
public class FirstServlet extends HttpServlet
{
	File file=new File("F:/hh11.txt");
	 FileOutputStream filout;
	
	public void FirstServlet() throws ServletException{ 
		 //super();
		  try {
			filout=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void init() throws ServletException{ 
		try {
			filout=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// 客户端的响应方法，使用该方法可以响应客户端所有类型的请求
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,java.io.IOException
	{
		// 设置解码方式
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charSet=GBK");
		// 获取name的请求参数值
		String name = request.getParameter("name");
		// 获取gender的请求参数值
		
		PrintStream out = new PrintStream(response.getOutputStream());
		//输出HTML页面标签
		 
       
		byte[] bb=request.getParameter("name").getBytes();
		filout.write(bb);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet测试</title>");
		out.println("</head>");
		out.println("<body>");
		// 输出请求参数的值：name
		out.println("您的名字：" + name + "<hr/>");
		// 输出请求参数的值：gender

		out.println("</body>");
		out.println("</html>");
	}
}
