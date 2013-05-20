package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

import db.UserAccount;

import frontend.LoginService;

@WebServlet("/login")
public class LoginPageController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
		view.forward(request, response);	
	}
	/*
	 * 
	 * @see controller.BaseController#doOnPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
		request.setCharacterEncoding("UTF-8");
		UserAccount userAccount=new UserAccount();
		LoginService loginService=new LoginService();
		DBUtil dbUtil= new DBUtil();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		userAccount=dbUtil.getUserByUsername(userName);
		
		if(userAccount!=null){
			String hashedPassword=loginService.hashPassword(password);
			if(userAccount.getPassw().equals(hashedPassword)){
				request.getSession().setAttribute("user", userAccount);
				response.sendRedirect("/R11_ladu/");
				return;
			}else{
				request.setAttribute("wrongpass", "Vale parool!");
			}
		}else{
			request.setAttribute("wronguser", "Vale kasutaja!");
		}
		view.forward(request, response);	
	}

}
