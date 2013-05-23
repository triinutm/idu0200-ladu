package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;
import db.Item;

import util.DBUtil;


public class TestDbUtil {
	
	/**
	 * Testime toote küsimist andmebaasist Id j2rgi ning toote hinna uuenemist.
	 */
	@Test
	public void testUpdateItemPriceInWareHouse(){
		
		DBUtil dbUtil = new DBUtil();
		Item itemBefore = dbUtil.getItemById(3);
		BigDecimal itemStorePriceBefore = itemBefore.getStorePrice();
		
		dbUtil.updateItemPriceInWareHouse(itemBefore, 30, 800);
		
		Item itemAfter = dbUtil.getItemById(3);
		BigDecimal itemStorePriceAfter = itemAfter.getStorePrice();
		assertNotNull(itemBefore);
		assertNotNull(itemAfter);
		assertFalse(itemStorePriceBefore.equals(itemStorePriceAfter));
	}

}
