package src;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
// Servlet����̳�HttpServlet��
@WebServlet(name="firstServlet"
	, urlPatterns={"/firstServlet"})
public class FirstServlet extends HttpServlet
{
	File file=new File("F:/hh11.txt");
	 FileOutputStream filout;
	HashMap<String,String> usertable=new HashMap<String,String>();
	
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
		usertable.put("admin", "admin");
		}
		// �ͻ��˵���Ӧ������ʹ�ø÷���������Ӧ�ͻ����������͵�����
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,java.io.IOException
	{
		// ���ý��뷽ʽ
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charSet=GBK");
		// ��ȡname���������ֵ
	    response.reset();  
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=UTF-8");  
        response.setHeader("Content-Disposition", "attachment; filename=\"");
		String commend = request.getParameter("commond");
		// ��ȡgender���������
		if(commend.equals("regest")){
		
			Iterator iter = usertable.entrySet().iterator();
			 PrintWriter pp=response.getWriter();
			String logname=null;
			String logpassword=null;
			boolean userid_flag=false;
			String kkk=null;
			while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			 logname = (String) entry.getKey();
			if(request.getParameter("regestname").equals(logname)){
				userid_flag=true;
				System.out.println("��������");
			 break;}
			}
			if(userid_flag){
				kkk="1";
			}
			else
			{
				usertable.put(request.getParameter("regestname"),request.getParameter("regestpassword"));
				kkk="0";
				System.out.println("ע��ɹ�");
			}
			pp.print(kkk);
			pp.flush();
			System.out.println("ע��");
		}
		else if(commend.equals("login")){
			Iterator iter = usertable.entrySet().iterator();
			String logname=null;
			String logpassword=null;
			while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			 logname = (String) entry.getKey();
			if((request.getParameter("username").equals(logname))){
			 logpassword = (String) entry.getValue();
			 break;}
			}
			String kkk=null;
			 PrintWriter pp=response.getWriter();
			if((request.getParameter("password").equals(logpassword)))
			kkk="0";
			else{
			 kkk="1";
			}
			pp.print(kkk);
			pp.flush();
			System.out.println("��¼");
		}
		else{
			System.out.println("δ֪����");
			
		}
		//byte[] bb=request.getParameter("name").getBytes();
		//filout.write(bb);

	}
}
