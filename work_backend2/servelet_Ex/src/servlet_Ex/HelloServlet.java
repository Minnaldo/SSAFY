package servlet_Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public HelloServlet() { }
	
	//HttpServletRequest req : 클라이언트가 보낸 요청에 대한 정보들이 들어있음.
	//HttpServletResponse resp : 서블릿이 응답할 내용이나... 정책에 대해서 정해줄 수 있음.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		//클라이언트에게 응답하기 위한 encoding 설정
		resp.setCharacterEncoding("UTF-8");
		
		//클라이언트에게 응답하기 위한 출력 객체
		
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<titl>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>hello world</h1><p><p>현재 시간 - ");
		
		Calendar today = Calendar.getInstance();
		out.print(today.get(Calendar.HOUR_OF_DAY));
		out.print(":");
		out.print(today.get(Calendar.MINUTE));
		out.print(":");
		out.print(today.get(Calendar.SECOND));
		out.print("</p> </body>");
		out.print("</html>");
		out.close();
		
	}
	
}
