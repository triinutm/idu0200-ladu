package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import db.Item;
import frontend.AutoAdapter;

@WebServlet("/productservice")
public class ProductService extends HttpServlet {
	private static final long serialVersionUID = 8094645263589180560L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		DBUtil dbUtil = new DBUtil();
		Item item = null;
		if (request.getParameter("id") != null) {
			int id = 0;

			try {
				id = Integer.parseInt(request.getParameter("id"));
				item = dbUtil.getItemById(id);
			} catch (Exception e) {
				
				RequestDispatcher view= request
						.getRequestDispatcher("/error.jsp");
				view.forward(request, response);
				return;
			}

			if (item != null) {
				
			    GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson gson = gsonBuilder.registerTypeAdapter(Item.class, new AutoAdapter()).create();
			    String json  = gson.toJson(item);
				PrintWriter out = response.getWriter();  
	            out.write(json);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("/error.jsp");
				view.forward(request, response);
			}
		}else{
			response.sendRedirect("/search");
			return;
		}
	}
}
