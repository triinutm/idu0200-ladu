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

import util.DBUtil;
import util.FormUtil;

import model.SearchForm;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends BaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doOnPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    RequestDispatcher view = request.getRequestDispatcher("/search.jsp");
	    SearchForm form = FormUtil.getSearchFormFromRequestMap(request.getParameterMap());
	    DBUtil dbUtil = new DBUtil();
	    List<Item> items = dbUtil.searchItems(form);
	    request.setAttribute("items", items);
	    request.setAttribute("form", form);
	    view.forward(request, response);
	}

	@Override
	protected void doOnGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    RequestDispatcher view = request.getRequestDispatcher("/search.jsp");
	    request.setAttribute("form", new SearchForm());
	    view.forward(request, response);
	}


}
