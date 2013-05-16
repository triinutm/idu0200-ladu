package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Item;
import db.ItemAction;
import db.Store;
import db.UserAccount;
import frontend.WareHouseService;

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
		
		UserAccount user = (UserAccount)request.getSession().getAttribute("user");
		Map<String,String[]> paramtereMap = request.getParameterMap();
		DBUtil dbUtil = new DBUtil();
		WareHouseService wareHouseService = new WareHouseService();
		
		List<Store> allStores = dbUtil.getAllWareHouses();
		int itemId = Integer.parseInt(wareHouseService.getString(paramtereMap, "register_item_id"));
		Item item = dbUtil.getItemById(itemId);
		
		if(request.getParameter("action").equals("register") && user != null && item != null && allStores != null){
			
			ItemAction itemAction = wareHouseService.createWareHouseRegisterItemAction(user, paramtereMap, allStores, item);
			if(itemAction != null){
				dbUtil.insertItemAction(itemAction);
				request.setAttribute("register_successful", "Toote arvele võtmine õnnestus!");
			}
			request.setAttribute("item", item);
			request.setAttribute("allStores", allStores);
		}else if(request.getParameter("action").equals("remove") && user != null && item != null && allStores != null){
			
			
		}else if(request.getParameter("action").equals("move") && user != null && item != null && allStores != null){
			
		}else{
			
		}
		
		view.forward(request, response); 	
	}
}
