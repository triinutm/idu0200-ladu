package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.PriceListDAO;
@WebServlet("/pricelists")
public class PriceListsController extends BaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doOnPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		
			
		
		
	}

	@Override
	protected void doOnGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PriceListDAO plDAO = new PriceListDAO();
		response.getWriter().write(new Gson().toJson(plDAO.findById(Integer.parseInt(request.getParameter("id")))));
		
	}

}
