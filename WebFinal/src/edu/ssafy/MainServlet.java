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
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if(action.equals("calc")) {
			Calc(request, response);
			
		}
		
	}


	private void Calc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		
		ArrayList<Calc> calc = ser.calc(Integer.parseInt(op1), Integer.parseInt(op2));
		
		request.setAttribute("result", calc);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}

}
