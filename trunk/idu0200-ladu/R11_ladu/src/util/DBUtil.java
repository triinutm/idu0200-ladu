package util;

import java.util.List;

import db.ItemType;
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

}
