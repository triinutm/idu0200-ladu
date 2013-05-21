package frontend;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import db.Item;

	public class AutoAdapter implements JsonSerializer<Item> {
		  
		public JsonElement serialize(Item item, Type type, JsonSerializationContext jsc) {
		    JsonObject jsonObject = new JsonObject();
		    jsonObject.addProperty("tootja", item.getProducer());
		    jsonObject.addProperty("tootja_kood", item.getProducerCode());
		    return jsonObject;      
		  }
	}
