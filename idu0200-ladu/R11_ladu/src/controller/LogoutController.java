package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doOnGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
	
		request.getSession().invalidate();
		String logoutPage = request.getParameter("/login.jsp");
		response.sendRedirect(logoutPage);
		
	}
	
	@Override
	protected void doOnPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		doOnGet(request, response);
		
	}

}
