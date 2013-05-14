package model;

import java.util.HashMap;
import java.util.Map;

public class ProductModel {

    private String name = "";
    private String description = "";
    private String price = "";
    private String type;
    private Map<Long, AttributeModel> attributes = new HashMap<Long, AttributeModel>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Map<Long, AttributeModel> getAttributes() {
	return attributes;
    }
    public void setAttributes(Map<Long, AttributeModel> attributes) {
	this.attributes = attributes;
    }
    
    
}
