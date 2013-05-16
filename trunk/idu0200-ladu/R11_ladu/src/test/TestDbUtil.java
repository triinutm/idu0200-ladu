package test;

import java.math.BigDecimal;

import junit.framework.Assert;
import org.junit.Test;

import db.Item;

import util.DBUtil;


public class TestDbUtil {
	
	/**
	 * Testime toote küsimist andmebaasist Id järgi ning toote hinna uuenemist.
	 */
	@Test
	public void testUpdateItemPriceInWareHouse(){
		
		DBUtil dbUtil = new DBUtil();
		Item itemBefore = dbUtil.getItemById(3);
		BigDecimal itemStorePriceBefore = itemBefore.getStorePrice();
		
		dbUtil.updateItemPriceInWareHouse(itemBefore, 30, 800);
		
		Item itemAfter = dbUtil.getItemById(3);
		BigDecimal itemStorePriceAfter = itemAfter.getStorePrice();
		Assert.assertNotNull(itemBefore);
		Assert.assertNotNull(itemAfter);
		Assert.assertFalse(itemStorePriceBefore.equals(itemStorePriceAfter));
	}

}
