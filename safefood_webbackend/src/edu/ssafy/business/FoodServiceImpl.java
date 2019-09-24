package edu.ssafy.business;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

public class FoodServiceImpl implements IFoodService{

	private IMemManager man = new MemManagerImpl();

	@Override
    public void SignUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        // 2.파라미터 작업(name 속성 쫓는다)
                String id = request.getParameter("pid");
                String pw1 = request.getParameter("ppw1");
                String pw2 = request.getParameter("ppw2");
                String name = request.getParameter("pname");
                String addr = request.getParameter("paddr");
                String email1=request.getParameter("pemail1");
                String email2=request.getParameter("pemail2");
                
                String email=email1+"@"+email2;
                
                String tel1=request.getParameter("ptel1");
                String tel2=request.getParameter("ptel2");
                String tel3=request.getParameter("ptel3");
                
                String tel=tel1+"-"+tel2+"-"+tel3;
                
                String alinfo="알러지다ㅏ";
                
                // 3
                boolean res = man.addMem(id, pw1, name, addr, email, tel,alinfo);
                // 4
                if (res) {
                    String msg = "success";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                } else {
                    String msg = "fail";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                }
    }
	
	
	@Override
	public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		boolean isLogin = man.isLogin(id, pw);
		if (isLogin) {
			//세션에 로그인 저장
			request.getSession().setAttribute("islogin", "isLogin");
			request.getSession().setAttribute("id",id);


			///메인과의 연동 필요~
			///로그인 상태 알려주기 Ajax
			response.sendRedirect("main.jsp");
		} else {
			//
		}
	}
	@Override
	   public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String id = request.getParameter("pid");
	       boolean del = man.delMem(id);
	       if (del) {
	           String msg = "success";
	            request.setAttribute("msg", msg);
	            request.getSession().invalidate();
	            request.getRequestDispatcher("mypage.jsp").forward(request, response);
	       } else {
	           String msg = "fail";
	            request.setAttribute("msg", msg);
	            request.getRequestDispatcher("main.jsp").forward(request, response);
	       }
	   }
	
	@Override
	public void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String addr = request.getParameter("paddr");
		String email = request.getParameter("pemail");
		String tel = request.getParameter("ptel");
		String alinfo = request.getParameter("palinfo");

		
		boolean update = man.updateMem(id, pw, name, addr, email, tel, alinfo);


		if (update) {
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 수정이 실패하였습니다");
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		}
	}

	@Override
	public void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVO> list = man.getList();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회실패입니다.!!!");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}


}