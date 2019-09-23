package edu.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.business.IMemService;
import edu.ssafy.business.MemServiceImpl;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMemService service = new MemServiceImpl();
	
	
	// 처음에 한 번 돌 때 실행 됨.
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
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
//		request.setCharacterEncoding("utf-8");	//KorCharSet Filter
//		response.setContentType("text/html); charset=utf-8");

		String action = request.getParameter("action");
		if (action.equals("registmem")) {
			service.registMem(request, response);
		} else if (action.equals("listmem")) {
			service.listMem(request, response);
		} else if (action.equals("meminfo")) {
			service.memInfo(request, response);
		} else if (action.equals("deletemem")) {
			service.deletemem(request, response);
		} else if (action.equals("updatemem")) {
			service.updatemem(request, response);
		} else if(action.equals("loginmem")) {
			service.loginmem(request, response);
        } else if(action.equals("namefind")) {
        	service.namefind(request, response);
		}else if(action.equals("logout")) {
			service.logout(request, response);
        }
		
	}
	
	

}
