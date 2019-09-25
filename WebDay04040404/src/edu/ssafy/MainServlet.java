package edu.ssafy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IService ser = new ServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("calc")) {
			Calc(request, response);
		}
		
		
	}

	private void Calc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("호출됐냐?");
		String str =request.getParameter("op1");
		System.out.println(str);
		int num1 = Integer.parseInt(str);
		int num2 = Integer.parseInt(request.getParameter("op2"));
		
		ArrayList<edu.ssafy.Calc> calc = ser.calc(num1, num2);
		
		request.setAttribute("calc", calc);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
