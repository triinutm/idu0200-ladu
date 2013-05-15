package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import db.PriceList;
import db.PriceListStatusType;
import dao.dbconnection;

public class PriceListDAO {
	public List<PriceList> findAll(){
		List<PriceList> list = new LinkedList<PriceList>();
		ResultSet result = dbconnection.executeQuery("SELECT price_list, price_list_status_type_fk, default_discount_xtra, date_from, date_to, note FROM price_list ORDER BY price_list");
		if (result == null) {
			return null;
		}
		try {
			while (result.next()) {
				PriceList p = new PriceList();
				p.setPriceList(result.getLong("price_list"));
				p.setDefaultDiscountXtra(result.getLong("default_discount_xtra"));
				p.setPriceListStatusType(findStatusType(result.getInt("price_list_status_type_fk")));
				p.setDateFrom(result.getDate("date_from"));
				p.setDateTo(result.getDate("date_to"));
				p.setNote(result.getString("note"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("PriceListDAO.findAll() : "+e.getMessage());
			return null;
		}	
	}

	public PriceListStatusType findStatusType(int status){
		ResultSet result = dbconnection.executeQuery("SELECT price_list_status_type, type_name FROM price_list_status_type WHERE price_list_status_type="+status);
		PriceListStatusType s= new PriceListStatusType();
		try {
			if (!result.next()) {
				return null;
			}
			else {
				s.setPriceListStatusType(result.getLong("price_list_status_type"));
				s.setTypeName(result.getString("type_name"));

			}
			return s;
		} catch (SQLException e) {
			System.out.println("PriceListDAO.findStatusType() : "+e.getMessage());
			return null;
		}	
	}

	public void createNewPriceList(PriceList priceList) {
		if (priceList == null) {
			return;
		}
		Connection connection = dbconnection.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO price_list(price_list_status_type_fk, default_discount_xtra, date_from, date_to, note, created_by, created)" +
							"VALUES (?,?,?,?,?,?,LOCALTIMESTAMP(0))");
			statement.setLong(1, priceList.getPriceListStatusType().getPriceListStatusType());
			statement.setLong(2, priceList.getDefaultDiscountXtra());
			statement.setDate(3, new java.sql.Date(priceList.getDateFrom().getTime()));
			statement.setDate(4, new java.sql.Date(priceList.getDateTo().getTime()));
			statement.setString(5, priceList.getNote());
			statement.setLong(6, 1); //sisse loginud kasutaja
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("PriceListDAO.createNewPriceList()"+e.getMessage());
		}
	}
	
	public PriceList findById(int id){
		ResultSet result = dbconnection.executeQuery("SELECT * FROM price_list WHERE price_list=" + id);
		PriceList p = new PriceList();
		try {
			if (!result.next()) {
				return null;
			}
			else {
				p.setPriceList(result.getLong("price_list"));
				p.setDefaultDiscountXtra(result.getLong("default_discount_xtra"));
				p.setPriceListStatusType(findStatusType(result.getInt("price_list_status_type_fk")));
				p.setDateFrom(result.getDate("date_from"));
				p.setDateTo(result.getDate("date_to"));
				p.setNote(result.getString("note"));      
			}
			return p;
		} catch (SQLException e) {
			System.out.println("PriceListDAO.findById() : "+e.getMessage());
			return null;
		}	
	}

	public void udatePriceList(PriceList priceList) {
		if (priceList == null) {
			return;
		}
		Connection connection = dbconnection.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE price_list SET price_list_status_type_fk=?, default_discount_xtra=?, date_from=?, date_to=?, note=?, updated_by=?, updated=LOCALTIMESTAMP(0)" +
							"WHERE price_list=?");
			statement.setLong(1, priceList.getPriceListStatusType().getPriceListStatusType());
			statement.setLong(2, priceList.getDefaultDiscountXtra());
			statement.setDate(3, new java.sql.Date(priceList.getDateFrom().getTime()));
			statement.setDate(4, new java.sql.Date(priceList.getDateTo().getTime()));
			statement.setString(5, priceList.getNote());
			statement.setLong(6, 1); //sisse loginud kasutaja
			statement.setLong(7,priceList.getPriceList());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("PriceListDAO.updateNewPriceList()"+e.getMessage());
		}
	}
	
	public void deletePriceList(int id) {
		Connection connection = dbconnection.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM price_list WHERE price_list="+id);
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("PriceListDAO.deletePriceList()"+e.getMessage());
		}
	}
}