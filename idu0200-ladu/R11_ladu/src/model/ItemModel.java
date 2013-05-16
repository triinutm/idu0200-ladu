package model;

public class ItemModel {
	private int id;
	private String name;
	private Double discount_price;
	private Double sale_price;
	private Double discount_xtra;
	
	public int getId() {
		return id;
	}
	public Double getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(Double discount_price) {
		this.discount_price = discount_price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public Double getDiscount_xtra() {
		return discount_xtra;
	}
	public void setDiscount_xtra(Double discount_xtra) {
		this.discount_xtra = discount_xtra;
	}
	
	

}
