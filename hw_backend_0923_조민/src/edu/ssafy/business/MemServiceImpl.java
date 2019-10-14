package edu.ssafy.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVo;

public class MemServiceImpl implements IMemService{
	private IMemManager man = new MemManagerImpl();


	@Override
	public void loginmem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");

		boolean check = man.loginmem(id, pw);

		if(check) {
			listMem(request, response);
		}else {
			request.getRequestDispatcher("registermem2.html").forward(request, response);
		}
	}

	@Override
	public void deletemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		boolean del = man.delMem(id);
		if (del) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + " 의 삭제를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	@Override
	public void updatemem(HttpServletRequest request, HttpServletResponse response)
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

	@Override
	public void memInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	@Override
	public void namefind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	@Override
	public void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVo> list = man.getList();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회실패입니다.!!!");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	@Override
	public void registMem(HttpServletRequest request, HttpServletResponse response)
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
			//							request.getSession().setAttribute("result", id + msg1);
			//							response.sendRedirect("main.do?action=result&result="+id+msg1);
		} else {
			String msg2 = " 등록실패입니다. @@@";
			request.setAttribute("result", id + msg2);
			//							response.sendRedirect("main.do?action=result&result="+id+msg2);
		}

		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++) {
			cookies[i].getName();
			cookies[i].getValue();
			
			//쿠키삭제..
			cookies[i].setMaxAge(0);
		}
		
		
		response.sendRedirect("login.html");
	}
}

