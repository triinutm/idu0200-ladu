package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AttributeModel;
import model.ProductModel;

import util.DBUtil;
import util.FormUtil;

import db.TypeAttribute;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/insert")
public class InsertController extends BaseController implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertController() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doOnPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException,
	    SQLException {
	RequestDispatcher view = request.getRequestDispatcher("/insert.jsp");
	Map<String, String[]> parameterMap = request.getParameterMap();
	for(String key : parameterMap.keySet()){
	   
	    if(parameterMap.get(key).length > 1){
		 System.out.println("Key: "+key+"  Value: "+parameterMap.get(key)[0] + "  " + parameterMap.get(key)[1]);
	    }else{
		 System.out.println("Key: "+key+"  Value: "+parameterMap.get(key)[0]);
	    }
	}
	ProductModel m = FormUtil.getProductFromParameterMap(parameterMap);
	request.setAttribute("productModel", m);
	view.forward(request, response);
    }

    @Override
    protected void doOnGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException,
	    SQLException {
	if(request.getParameter("catalog") != null){
	    RequestDispatcher view = request.getRequestDispatcher("/insert.jsp");
	    Integer id = Integer.parseInt(request.getParameter("catalog"));
	    DBUtil m = new DBUtil();
	    List<TypeAttribute> itemAttributes = m.getTypeAttributesByItemType(id);
	    ProductModel model = new ProductModel();
	    model.setType(m.getItemTypeById(id).getTypeName());
	    for(TypeAttribute attribute : itemAttributes){
		AttributeModel attibute = new AttributeModel();
		attibute.setAttributeName(attribute.getItemAttributeType().getTypeName());		
		model.getAttributes().put(attribute.getTypeAttribute(), attibute);
	    }
	    request.setAttribute("productModel", model);
	    view.forward(request, response);
	}
	
	
    }

}
