package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerModel;
import model.ItemModel;
import model.PriceListForm;

import dao.PriceListDAO;
import db.Customer;
import db.PriceList;

/**
 * Servlet implementation class PriceListController
 */
@WebServlet("/pricelist")
public class PriceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PriceListController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PriceListDAO dao = new PriceListDAO();
		RequestDispatcher view = request.getRequestDispatcher("/pricelists.jsp");
		System.out.println(request.getParameter("action"));
		if (request.getParameter("action") != null){
			if (request.getParameter("action").equals("new")){
				try {
					dao.createNewPriceList(getPriceListFromRequest(request).convertToPriceList());
				} catch (ParseException e) {
					System.out.println("PriceListController.doGet()"+e.getMessage());
				}	
			}
			if (request.getParameter("action").equals("update")){
				try {
					dao.udatePriceList(getPriceListFromRequest(request).convertToPriceList());
				} catch (ParseException e) {
					System.out.println("PriceListController.doGet()"+e.getMessage());
				}	
			}
			if (request.getParameter("action").equals("delete")){
				dao.deletePriceList(Integer.parseInt(request.getParameter("uid")));	
			}
			if (request.getParameter("action").equals("searchcustomer")){
				view = request.getRequestDispatcher("/pricelist.jsp");
				List<CustomerModel> searchcustomers = dao.searchCustomer(request.getParameter("customer"));
				request.setAttribute("searchcustomers",searchcustomers);
			}
			if (request.getParameter("action").equals("searchitem")){
				view = request.getRequestDispatcher("/pricelist.jsp");
				System.out.println("ITEMSSEARCH:");
				List<ItemModel> searchitems = dao.searchItem(request.getParameter("item"));
				request.setAttribute("searchitems",searchitems);
			}
			if (request.getParameter("action").equals("addcustomer")){
				view = request.getRequestDispatcher("/pricelist.jsp");
				dao.addCustomer(Integer.parseInt(request.getParameter("customer")),Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("action").equals("deletecustomer")){
				view = request.getRequestDispatcher("/pricelist.jsp");
				dao.deleteCustomer(Integer.parseInt(request.getParameter("customer")),Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("action").equals("deleteitem")){
				view = request.getRequestDispatcher("/pricelist.jsp");
				dao.deleteItem(Integer.parseInt(request.getParameter("item")),Integer.parseInt(request.getParameter("id")));
			}
		}
		if (request.getParameter("id") != null){
			if(request.getParameter("id").equals("new")){
				view = request.getRequestDispatcher("/newpricelist.jsp");
			}else{
				try {
					PriceListForm pricelist = dao.findById(Integer.parseInt(request.getParameter("id"))).convertToPriceListForm();
					request.setAttribute("pricelist",pricelist);
					List<String> list = dao.findOtherStatusTypes(pricelist.getPriceListStatusType());
					request.setAttribute("otherstatus", list);
					List<CustomerModel> customers = dao.findCustomersById(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("customers", customers);
					List<ItemModel> items = dao.findItemsById(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("items", items);
				} catch (NumberFormatException | ParseException e) {
					System.out.println("PriceListController.doGet()"+e.getMessage());
				}view = request.getRequestDispatcher("/pricelist.jsp");
			}

		}else{
			request.setAttribute("pricelistElements", dao.findAll());
		}
		request.setCharacterEncoding("UTF-8");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	private PriceListForm getPriceListFromRequest(HttpServletRequest request) {
		PriceListDAO dao = new PriceListDAO();
		PriceListForm priceListForm = new PriceListForm(); 
		if(request.getParameter("id")!=null){
			priceListForm.setId(request.getParameter("id"));
		}
		priceListForm.setPriceListStatusType(""+dao.findStatusType(request.getParameter("status")).getPriceListStatusType());
		priceListForm.setDefaultDiscountXtra(request.getParameter("discount"));
		priceListForm.setDateFrom(request.getParameter("date_from"));
		priceListForm.setDateTo(request.getParameter("date_to"));
		priceListForm.setNote(request.getParameter("note"));
		return priceListForm;
	}

}
