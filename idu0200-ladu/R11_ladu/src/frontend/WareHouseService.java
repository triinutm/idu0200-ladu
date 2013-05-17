package frontend;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import util.DBUtil;
import db.Item;
import db.ItemAction;
import db.ItemStore;
import db.Store;
import db.UserAccount;

public class WareHouseService {
	
	/**
	 * Meetod, mis loob lao registreerimise toimingu.
	 * @param userAccount - kasutaja
	 * @param paramtereMap - parameetrite map
	 * @param allStores - ladude nimekiri
	 * @param item - arvele võetav toode
	 * @return
	 */
	public ItemAction createWareHouseRegisterItemAction(UserAccount userAccount, Map<String,String[]> paramtereMap, List<Store> allStores, Item item){
		
		ItemAction itemAction = new ItemAction();
		DBUtil dbUtil = new DBUtil();
		
		itemAction.setEmployee(userAccount.getEmployeeBySubjectFk());
		itemAction.setItem(item);
		String actionPrice = getString(paramtereMap, "warehouse_register_price");
		BigDecimal actionPriceBigInt = new BigDecimal(actionPrice);
		itemAction.setActionPrice(actionPriceBigInt);
		itemAction.setItemActionType(dbUtil.getItemActionType(1));
		
		String selectedStore = getString(paramtereMap, "register_select_store");
		long selectedStoreId = Integer.parseInt(selectedStore);
		Store store = getSelectedStore(allStores, selectedStoreId);
		itemAction.setStoreByStoreToFk(store);

		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
		Date actionDate = new Date(today.getTime().getTime());
		itemAction.setActionDate(actionDate);
		itemAction.setCreated(actionDate);
		String itemCount = getString(paramtereMap, "warehouse_register_quantity");
		long itemCountLong = Integer.parseInt(itemCount);
		itemAction.setItemCount(itemCountLong);
		
		ItemStore itemStore = dbUtil.getItemStoreByItemAndStore(item, store);
		
		BigDecimal itemCountAdded = new BigDecimal(itemCount);
		
		if(itemStore != null){
			BigDecimal itemCountBefore = itemStore.getItemCount();
			itemStore.setItemCount(itemCountBefore.add(itemCountAdded));
			dbUtil.updateItemStore(itemStore);
		}else{
			ItemStore newItemStore = new ItemStore();
			newItemStore.setItem(item);
			newItemStore.setItemCount(itemCountAdded);
			newItemStore.setStore(store);
			dbUtil.insertItemStore(newItemStore);
		}
		return itemAction;
	}

	/**
	 * Meetod, mis leiab etteantud mapist atribuudi järgi väärtuse.
	 * @param map - parameetrite map
	 * @param attribute - otsitav atribuut
	 * @return - null, kui väärtust ei leita
	 */
	public String getString(Map<String, String[]> map, String attribute) {
		String[] array = map.get(attribute);
		if (array != null && array.length > 0) {
			return array[0];
		}
		return null;
	}
	
	public Store getSelectedStore(List<Store> allStores, long selectedStore){
		Store restultStore = null;
		
		for(Store store : allStores){
			if(store.getStore() == selectedStore){
				restultStore = store;
			}
		}
		return restultStore;
	}
}
