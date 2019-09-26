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
	IService ser = new CalcServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//커넥션처리(필터에서 했음)
		String action = request.getParameter("action");
		
		if(action.trim().equalsIgnoreCase("calc")) {
			calc(request,response);
		}
		
	}

	private void calc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		//parameter
		String op1 = request.getParameter("pop1");
		String op2 = request.getParameter("pop2");
		
		//algorithm
		ArrayList<Calc> sum = ser.calc(Integer.parseInt(op1), Integer.parseInt(op2));
		//jsp로 던져줄때는 setAttribute, html 에서 가져올때는 getParameter
		request.setAttribute("op1", op1);
		request.setAttribute("op2", op2);
		request.setAttribute("sum", sum);
		

		
		//여기서 세션에 담지않는이유는 세션은 계속 남아있으니 !
//		request.getSession().setAttribute(name, o);
		request.getRequestDispatcher("calc.jsp").forward(request, response);
		
	}

}
