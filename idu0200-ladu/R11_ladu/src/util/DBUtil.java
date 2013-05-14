package util;

import java.util.List;

import db.Item;
import db.ItemType;
import db.Store;
import db.TypeAttribute;
import db.UserAccount;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class DBUtil {
	
	static Logger log = Logger.getLogger(DBUtil.class);

	@SuppressWarnings("unchecked")
	public List<ItemType> getAllItemTypes() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ItemType> itemTypeList = null;
		try{
			session.getTransaction().begin();
			itemTypeList = (List<ItemType>) session.createCriteria(ItemType.class).list();
			//session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			log.warn("Error: getAllItemTypes()");
		}

		return itemTypeList;
	}

	public ItemType getItemTypeById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		ItemType itemType = null;
		try{ 
			session.getTransaction().begin();
			itemType = (ItemType) session.get(ItemType.class, new Long(id));
			//session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			log.warn("Error: getItemTypeById()");
		}
		return itemType;

	}
	
	@SuppressWarnings("unchecked")
	public List<ItemType> getItemTypeCatalogs(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ItemType> itemTypes = null;
		try{
			session.getTransaction().begin();
			
			Query q = session.createQuery("from ItemType as p where p.itemType_1.itemType =:id order by p.typeName");
			q.setInteger("id", id);
			itemTypes = (List<ItemType>) q.list();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			log.warn("Error: getItemTypeCatalogs()");
		}
		
		return itemTypes;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemType> getAllFirstlevelCatalogs(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ItemType> itemTypes = null;
		try{
			session.beginTransaction();
			
			Query q = session.createQuery("from ItemType as p where p.level =1 order by p.typeName");
			itemTypes = (List<ItemType>) q.list();
			//session.getTransaction().commit();
			
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
			log.warn("Error: getAllFirstLevelCatalogs");
		}
		return itemTypes;
	}
	
	public UserAccount getUserByUsername(String username){
		UserAccount userAccount=null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query=session.createQuery("from UserAccount as u where u.username= :username");
			query.setString("username", username);
			List<UserAccount> userAccountList=(List<UserAccount>)query.setMaxResults(1).list();
			if(!userAccountList.isEmpty()){
				userAccount=(UserAccount)userAccountList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userAccount ;
	}
	
	@SuppressWarnings("unchecked")
	public List<TypeAttribute> getTypeAttributesByItemType(int itemType){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TypeAttribute> typeAttributes = null;
		try{
			session.beginTransaction();
			
			Query q = session.createQuery("from TypeAttribute where itemType.itemType = :id order by orderby");
			q.setInteger("id", itemType);
			typeAttributes = (List<TypeAttribute>) q.list();
			//session.getTransaction().commit();
			
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		return typeAttributes;
	}
	
	/**
	 * Meetod leiab Item objekti id järgi.
	 * @param id - otsitava toote id
	 * @return - null kui toodet ei leita.
	 */
	public Item getItemById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Item item = null;
		try{ 
			session.getTransaction().begin();
			item = (Item) session.get(Item.class, new Long(id));
			//session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			log.warn("Error: getItemTypeById()");
			e.printStackTrace();
		}
		return item;
	}
	
	/**
	 * Meetod küsib andmebaasist kõik laod.
	 * @return - null, kui ladusid ei leita.
	 */
	@SuppressWarnings("unchecked")
	public List<Store> getAllWareHouses() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Store> storeList = null;
		try{
			session.getTransaction().begin();
			storeList = (List<Store>) session.createCriteria(Store.class).list();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			log.warn("Error: getAllWareHouses()");
			e.printStackTrace();
		}
		return storeList;
	}
}
