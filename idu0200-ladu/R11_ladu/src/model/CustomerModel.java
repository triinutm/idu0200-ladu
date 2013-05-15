package model;

public class CustomerModel {
	private int id;
	private String name;
	
	public CustomerModel(){}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

}
