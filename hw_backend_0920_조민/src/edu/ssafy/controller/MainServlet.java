package edu.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemVo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemManager man;

	// 처음에 한 번 돌 때 실행 됨.
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		man = MemManager.getInstance();
	}

	public MainServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html); charset=utf-8");

		String action = request.getParameter("action");
		if (action.equals("registmem")) {
			registMem(request, response);
		} else if (action.equals("listmem")) {
			listMem(request, response);
		} else if (action.equals("meminfo")) {
			memInfo(request, response);
		} else if (action.equals("deletemem")) {
			deletemem(request, response);
		} else if (action.equals("updatemem")) {
			updatemem(request, response);
		} else if(action.equals("loginmem")) {
			logIn(request, response);
		} else if(action.equals("logout")) {
			logout(request, response);
        } else if(action.equals("namefind")) {
			namefind(request, response);
		}
		
	}
	
	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("pid");
        String pw = request.getParameter("ppw");
        boolean check = man.loginmem(id, pw);
        
        if(check) {
            //listMem(request, response);
            request.getSession().setAttribute("check", check);
            request.getSession().setAttribute("id", id);
            response.sendRedirect("main.do?action=listmem");
        }else {
            response.sendRedirect("login.html");
            //request.getRequestDispatcher("registerMem.html").forward(request, response);
        }
    }
	
	private void loginmem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		
		boolean check = man.loginmem(id, pw);
		
		if(check) {
			listMem(request, response);
		}else {
			request.getRequestDispatcher("registerMem.html").forward(request, response);
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getSession().setAttribute("loginmem", null);
		
		request.getSession().invalidate();		//세션이 싹 지워져버려서, 로그아웃된다.
	
	}
	
	private void deletemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("uid");
		boolean del = man.delMem(id);
		if (del) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + " 의 삭제를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void updatemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String quantity = request.getParameter("pquantity");
		int price = Integer.parseInt(request.getParameter("pprice"));

		boolean update = man.updateMem(id, name, quantity, price);

		if (update) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 수정이 실패하였습니다");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void memInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		MemVo mem = man.memInfo(id);
		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회실패입니다.!!!");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	

	private void namefind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");
		ArrayList<MemVo> namelist = man.nameFind(keyword);
		
		if(namelist != null) {
			request.setAttribute("list", namelist);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "찾는 이름이 없습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MemVo> list = man.getList();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회실패입니다.!!!");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void registMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 2. 파라미터 처리
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String quantity = request.getParameter("pquantity");
		int price = Integer.parseInt(request.getParameter("pprice"));

		// 3. 업무 처리
		boolean res = man.addMem(id, name, quantity, price);

		// 4. 출력처리
		if (res) {
			String msg1 = " 등록성공되었습니다. !!!";
			request.setAttribute("result", id + msg1);
//					request.getSession().setAttribute("result", id + msg1);
//					response.sendRedirect("main.do?action=result&result="+id+msg1);
		} else {
			String msg2 = " 등록실패입니다. @@@";
			request.setAttribute("result", id + msg2);
//					response.sendRedirect("main.do?action=result&result="+id+msg2);
		}

		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
