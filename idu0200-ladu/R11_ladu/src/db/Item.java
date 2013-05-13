package db;

// Generated 12.06.2012 19:50:00 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name = "item")
public class Item implements java.io.Serializable {

	private long item;
	private ItemType itemType;
	private UnitType unitType;
	private Enterprise enterprise;
	private String name;
	private BigDecimal storePrice;
	private BigDecimal salePrice;
	private String producer;
	private String description;
	private String producerCode;
	private String singleItem;
	private Long upperItemFk;
	private String serialNo;
	private Date created;
	private Set<ItemPriceList> itemPriceLists = new HashSet<ItemPriceList>(0);
	private Set<ItemAction> itemActions = new HashSet<ItemAction>(0);
	private Set<ItemStore> itemStores = new HashSet<ItemStore>(0);
	private Set<ItemAttribute> itemAttributes = new HashSet<ItemAttribute>(0);

	public Item() {
	}

	public Item(long item) {
		this.item = item;
	}

	public Item(long item, ItemType itemType, UnitType unitType,
			Enterprise enterprise, String name, BigDecimal storePrice,
			BigDecimal salePrice, String producer, String description,
			String producerCode, String singleItem, Long upperItemFk,
			String serialNo, Date created, Set<ItemPriceList> itemPriceLists,
			Set<ItemAction> itemActions, Set<ItemStore> itemStores,
			Set<ItemAttribute> itemAttributes) {
		this.item = item;
		this.itemType = itemType;
		this.unitType = unitType;
		this.enterprise = enterprise;
		this.name = name;
		this.storePrice = storePrice;
		this.salePrice = salePrice;
		this.producer = producer;
		this.description = description;
		this.producerCode = producerCode;
		this.singleItem = singleItem;
		this.upperItemFk = upperItemFk;
		this.serialNo = serialNo;
		this.created = created;
		this.itemPriceLists = itemPriceLists;
		this.itemActions = itemActions;
		this.itemStores = itemStores;
		this.itemAttributes = itemAttributes;
	}

	@Id
	@Column(name = "item", unique = true, nullable = false, precision = 10, scale = 0)
	public long getItem() {
		return this.item;
	}

	public void setItem(long item) {
		this.item = item;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_type_fk")
	public ItemType getItemType() {
		return this.itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_type_fk")
	public UnitType getUnitType() {
		return this.unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_enterprise_fk")
	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "store_price", precision = 131089, scale = 0)
	public BigDecimal getStorePrice() {
		return this.storePrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	@Column(name = "sale_price", precision = 131089, scale = 0)
	public BigDecimal getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "producer")
	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "producer_code")
	public String getProducerCode() {
		return this.producerCode;
	}

	public void setProducerCode(String producerCode) {
		this.producerCode = producerCode;
	}

	@Column(name = "single_item", length = 1)
	public String getSingleItem() {
		return this.singleItem;
	}

	public void setSingleItem(String singleItem) {
		this.singleItem = singleItem;
	}

	@Column(name = "upper_item_fk", precision = 10, scale = 0)
	public Long getUpperItemFk() {
		return this.upperItemFk;
	}

	public void setUpperItemFk(Long upperItemFk) {
		this.upperItemFk = upperItemFk;
	}

	@Column(name = "serial_no", length = 100)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemPriceList> getItemPriceLists() {
		return this.itemPriceLists;
	}

	public void setItemPriceLists(Set<ItemPriceList> itemPriceLists) {
		this.itemPriceLists = itemPriceLists;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemAction> getItemActions() {
		return this.itemActions;
	}

	public void setItemActions(Set<ItemAction> itemActions) {
		this.itemActions = itemActions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemStore> getItemStores() {
		return this.itemStores;
	}

	public void setItemStores(Set<ItemStore> itemStores) {
		this.itemStores = itemStores;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemAttribute> getItemAttributes() {
		return this.itemAttributes;
	}

	public void setItemAttributes(Set<ItemAttribute> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

}