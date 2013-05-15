package util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import db.Enterprise;
import db.Item;
import db.ItemAttribute;
import db.ItemType;
import db.Store;
import db.TypeAttribute;
import db.UnitType;
import db.UserAccount;

import model.AttributeModel;
import model.ProductModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBUtil {

    static Logger log = Logger.getLogger(DBUtil.class);

    @SuppressWarnings("unchecked")
    public List<ItemType> getAllItemTypes() {

	Session session = HibernateUtil.getSessionFactory().openSession();
	List<ItemType> itemTypeList = null;
	try {
	    session.getTransaction().begin();
	    itemTypeList = (List<ItemType>) session.createCriteria(ItemType.class).list();
	    // session.getTransaction().commit();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    log.warn("Error: getAllItemTypes()");
	}

	return itemTypeList;
    }

    public ItemType getItemTypeById(int id) {

	Session session = HibernateUtil.getSessionFactory().openSession();
	ItemType itemType = null;
	try {
	    session.getTransaction().begin();
	    itemType = (ItemType) session.get(ItemType.class, new Long(id));
	    // session.getTransaction().commit();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    log.warn("Error: getItemTypeById()");
	}
	return itemType;

    }

    @SuppressWarnings("unchecked")
    public List<ItemType> getItemTypeCatalogs(int id) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	List<ItemType> itemTypes = null;
	try {
	    session.getTransaction().begin();

	    Query q = session.createQuery("from ItemType as p where p.itemType_1.itemType =:id order by p.typeName");
	    q.setInteger("id", id);
	    itemTypes = (List<ItemType>) q.list();
	    session.getTransaction().commit();
	} catch (Exception e) {
	    log.warn("Error: getItemTypeCatalogs()");
	}

	return itemTypes;
    }

    @SuppressWarnings("unchecked")
    public List<ItemType> getAllFirstlevelCatalogs() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	List<ItemType> itemTypes = null;
	try {
	    session.beginTransaction();

	    Query q = session.createQuery("from ItemType as p where p.level =1 order by p.typeName");
	    itemTypes = (List<ItemType>) q.list();
	    // session.getTransaction().commit();

	} catch (RuntimeException e) {
	    session.getTransaction().rollback();
	    System.out.println(e.getMessage());
	    log.warn("Error: getAllFirstLevelCatalogs");
	}
	return itemTypes;
    }

    /*
	 * 
	 */
    public UserAccount getUserByUsername(String username) {
	UserAccount userAccount = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
	    session.beginTransaction();
	    Query query = session.createQuery("from UserAccount as u where u.username= :username");
	    query.setString("username", username);
	    List<UserAccount> userAccountList = (List<UserAccount>) query.setMaxResults(1).list();
	    if (!userAccountList.isEmpty()) {
		userAccount = (UserAccount) userAccountList.get(0);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return userAccount;
    }

    @SuppressWarnings("unchecked")
    public List<TypeAttribute> getTypeAttributesByItemType(int itemType) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	List<TypeAttribute> typeAttributes = null;
	try {
	    session.beginTransaction();
	    Query q = session.createQuery("from TypeAttribute where itemType.itemType = :id order by orderby");
	    q.setInteger("id", itemType);
	    typeAttributes = (List<TypeAttribute>) q.list();

	} catch (RuntimeException e) {
	    e.printStackTrace();
	}
	return typeAttributes;
    }

    /**
     * Meetod leiab Item objekti id järgi.
     * 
     * @param id
     *            - otsitava toote id
     * @return - null kui toodet ei leita.
     */
    public Item getItemById(int id) {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Item item = null;
	try {
	    session.getTransaction().begin();
	    item = (Item) session.get(Item.class, new Long(id));
	    // session.getTransaction().commit();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    log.warn("Error: getItemTypeById()");
	    e.printStackTrace();
	}
	return item;
    }

    /**
     * Meetod küsib andmebaasist kõik laod.
     * 
     * @return - null, kui ladusid ei leita.
     */
    @SuppressWarnings("unchecked")
    public List<Store> getAllWareHouses() {

	Session session = HibernateUtil.getSessionFactory().openSession();
	List<Store> storeList = null;
	try {
	    session.getTransaction().begin();
	    storeList = (List<Store>) session.createCriteria(Store.class).list();
	    session.getTransaction().commit();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    log.warn("Error: getAllWareHouses()");
	    e.printStackTrace();
	}
	return storeList;
    }

    /**
     * Toote lisamine koos attribuutidega
     * 
     * @param model
     * @return
     */
    public Item saveItem(ProductModel model) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	Item item = new Item();
	item.setDescription(model.getDescription().getAttributeValue());
	item.setName(model.getName().getAttributeValue());
	item.setSalePrice(new BigDecimal(model.getPrice().getAttributeValue()));
	item.setCreated(new Date());
	item.setUnitType((UnitType) session.get(UnitType.class, 1L));
	item.setItemType((ItemType) session.get(ItemType.class, new Long(model.getItemType())));
	item.setEnterprise((Enterprise) session.get(Enterprise.class, 2));
	Set<ItemAttribute> attributes = new HashSet<ItemAttribute>();
	DBUtil dbUtil = new DBUtil();
	// Otsime toote attribuudid ning paneme ID järgi map-i
	List<TypeAttribute> itemAttributes = dbUtil.getTypeAttributesByItemType(Integer.parseInt(model.getItemType()));
	Map<Long, TypeAttribute> attributeMap = new HashMap<Long, TypeAttribute>();
	for (TypeAttribute a : itemAttributes) {
	    attributeMap.put(a.getTypeAttribute(), a);
	}
	for (Long key : model.getAttributes().keySet()) {
	    AttributeModel currentAttribute = model.getAttributes().get(key);
	    // tühja attribuuti ei lisa
	    if (StringUtils.isNotBlank(currentAttribute.getAttributeValue())) {
		ItemAttribute attribute = new ItemAttribute();
		TypeAttribute attributeDefinition = attributeMap.get(key);
		// kas on tekstiväli
		if (attributeDefinition.getItemAttributeType().getDataType().equals(1L)) {
		    attribute.setDataType(1L);
		    attribute.setValueText(currentAttribute.getAttributeValue());
		} else if (attributeDefinition.getItemAttributeType().getDataType().equals(2L)) {
		    attribute.setDataType(2L);
		    attribute.setValueNumber(new BigDecimal(currentAttribute.getAttributeValue()));
		}
		attribute.setItemAttributeType(attributeDefinition.getItemAttributeType());
		attribute.setOrderby(attributeDefinition.getOrderby());
		attribute.setItem(item);
		attributes.add(attribute);
	    }

	}
	item.setItemAttributes(attributes);
	session.save(item);
	trans.commit();
	return item;
    }

    /**
     * Toote lisamine koos attribuutidega
     * 
     * @param model
     * @param itemId
     * @return
     */
    public Item updateItem(ProductModel model, Long itemId) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	Item item = (Item) session.get(Item.class, itemId);
	item.setDescription(model.getDescription().getAttributeValue());
	item.setName(model.getName().getAttributeValue());
	item.setSalePrice(new BigDecimal(model.getPrice().getAttributeValue()));
	Set<ItemAttribute> attributes = item.getItemAttributes();
	Map<Long, ItemAttribute> existingAttributes = new HashMap<Long, ItemAttribute>();
	for (ItemAttribute at : attributes) {
	    existingAttributes.put(at.getItemAttribute(), at);
	}
	DBUtil dbUtil = new DBUtil();
	// Otsime toote attribuudid ning paneme ID järgi map-i
	List<TypeAttribute> itemAttributes = dbUtil.getTypeAttributesByItemType(Integer.parseInt(model.getItemType()));
	Map<Long, TypeAttribute> attributeMap = new HashMap<Long, TypeAttribute>();
	for (TypeAttribute a : itemAttributes) {
	    attributeMap.put(a.getTypeAttribute(), a);
	}
	for (Long key : model.getAttributes().keySet()) {
	    AttributeModel currentAttribute = model.getAttributes().get(key);
	    // kas baasis on juba attribuudi kirje olemas
	    if (currentAttribute.getAttributeId() != null) {
		ItemAttribute attr = existingAttributes.get(currentAttribute.getAttributeId());
		if (attr.getDataType().equals(1L)) {
		    attr.setValueText(currentAttribute.getAttributeValue());
		} else if (attr.getDataType().equals(2L)) {
		    attr.setValueNumber(new BigDecimal(currentAttribute.getAttributeValue()));
		}
	    } else {
		// tühja väärtust pole mõtet lisada
		if (StringUtils.isNotBlank(currentAttribute.getAttributeValue())) {
		    ItemAttribute attribute = new ItemAttribute();
		    TypeAttribute attributeDefinition = attributeMap.get(key);
		    // kas on tekstiväli
		    if (attributeDefinition.getItemAttributeType().getDataType().equals(1L)) {
			attribute.setDataType(1L);
			attribute.setValueText(currentAttribute.getAttributeValue());
		    } else if (attributeDefinition.getItemAttributeType().getDataType().equals(2L)) {
			attribute.setDataType(2L);
			attribute.setValueNumber(new BigDecimal(currentAttribute.getAttributeValue()));
		    }
		    attribute.setItemAttributeType(attributeDefinition.getItemAttributeType());
		    attribute.setOrderby(attributeDefinition.getOrderby());
		    attribute.setItem(item);
		    attributes.add(attribute);
		}
	    }
	}
	session.save(item);
	trans.commit();
	return item;
    }
}
