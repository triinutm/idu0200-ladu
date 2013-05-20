package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/R11_ladu/login");	
		}else{
			try{
				doOnGet(req,resp);
			}catch (Exception e){
				resp.sendRedirect("/R11_ladu/viga");
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/R11_ladu/login");
		}else{
			try{
				doOnPost(req,resp);
			}catch (Exception e){
				resp.sendRedirect("/R11_ladu/viga");
				e.printStackTrace();
			}
		}
	}
	
	protected abstract void doOnPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
	protected abstract void doOnGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
	
	}
