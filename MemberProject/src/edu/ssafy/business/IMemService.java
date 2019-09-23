package edu.ssafy.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemVo;

public interface IMemService {
	
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void loginmem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public void deletemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void updatemem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void memInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	

	public void namefind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void registMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
