package util;

import java.util.List;

import db.ItemType;

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
			itemType = (ItemType) session.get(ItemType.class, new Integer(id));
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
			
			Query q = session.createQuery("from ItemType as p where p.SuperType =:id order by p.TypeName");
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

}
