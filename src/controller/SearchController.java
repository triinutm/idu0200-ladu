package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import db.Item;
import db.ItemType;
import db.TypeAttribute;

import util.DBUtil;
import util.FormUtil;

import model.AttributeModel;
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
	List<Item> items = dbUtil.searchItems(form, request.getParameter("catalog"));
	request.setAttribute("items", items);
	request.setAttribute("form", form);
	view.forward(request, response);
    }

    @Override
    protected void doOnGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	RequestDispatcher view = request.getRequestDispatcher("/search.jsp");
	String catalog = request.getParameter("catalog");
	if (StringUtils.isNotBlank(catalog) && StringUtils.isNumeric(catalog)) {
	    SearchForm form = new SearchForm();
	    DBUtil m = new DBUtil();
	    ItemType item =  m.getItemTypeById(Integer.parseInt(catalog));
	    form.setType(item.getTypeName());
	    List<TypeAttribute> itemAttributes = m.getTypeAttributesByItemType(Integer.parseInt(catalog));
	    for (TypeAttribute attribute : itemAttributes) {
		AttributeModel attibute = new AttributeModel();
		attibute.setAttributeName(attribute.getItemAttributeType().getTypeName());
		form.getAttributes().put(attribute.getItemAttributeType().getItemAttributeType(), attibute);
	    }
	    request.setAttribute("form", form);
	}else{
	    request.setAttribute("form", new SearchForm());
	}	
	view.forward(request, response);
    }

}
