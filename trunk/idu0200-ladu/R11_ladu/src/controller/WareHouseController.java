package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Item;
import db.Store;

import util.DBUtil;

/**
 * Lao toiminguid juhtiv kontroller.
 * Näite url: localhost/warehouse?item=3
 */
@WebServlet("/warehouse")
public class WareHouseController extends BaseController {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doOnGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
			RequestDispatcher view = request.getRequestDispatcher("/warehouse.jsp");
			request.setCharacterEncoding("UTF-8");
			
			if(request.getParameter("item") != null){	
				Integer itemId = Integer.parseInt(request.getParameter("item"));
				DBUtil dbUtil = new DBUtil();
				Item item = dbUtil.getItemById(itemId);
				List<Store> allStores = dbUtil.getAllWareHouses();
				
				if(item != null){
					request.setAttribute("item", item);
					if(allStores != null){
						request.setAttribute("allStores", allStores);
					}
				}
			}
			view.forward(request, response); 
	}


	@Override
	protected void doOnPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		RequestDispatcher view = request.getRequestDispatcher("/warehouse.jsp");
		request.setCharacterEncoding("UTF-8");
		
		view.forward(request, response); 
		
	}

}
