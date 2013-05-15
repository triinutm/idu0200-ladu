package util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import model.AttributeModel;
import model.ProductModel;

public class FormUtil {
    
    public static ProductModel getProductFromParameterMap(Map<String, String[]> parameterMap){
	ProductModel model = new ProductModel();
	model.getName().setAttributeValue(getValueFromMap("name", parameterMap));
	model.getDescription().setAttributeValue(getValueFromMap("description", parameterMap));
	model.getPrice().setAttributeValue(getValueFromMap("price", parameterMap));
	model.setType(getValueFromMap("type", parameterMap));
	model.setItemType(getValueFromMap("itemType", parameterMap));
	for(String key : parameterMap.keySet()){
	    String[] valueAndName = parameterMap.get(key);
	    if(StringUtils.isNumeric(key) && valueAndName.length > 1){
		AttributeModel a = new AttributeModel();
		a.setAttributeValue(valueAndName[0]);
		a.setAttributeName(valueAndName[1]);
		model.getAttributes().put(Long.parseLong(key), a);
	    }
	}
	return model;
    }

    private static String getValueFromMap(String key, Map<String, String[]> parameterMap){
	if(key != null && parameterMap != null){
	    if(parameterMap.get(key) != null && parameterMap.get(key).length > 0){
		return parameterMap.get(key)[0];
	    }
	}
	return null;
    }
}
