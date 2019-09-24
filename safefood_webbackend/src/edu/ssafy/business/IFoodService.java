package edu.ssafy.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFoodService {

	public void SignUp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
    public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
