package db;

// Generated 12.06.2012 19:50:00 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * ItemAction generated by hbm2java
 */
@Entity
@Table(name = "item_action")
public class ItemAction implements java.io.Serializable {

	private long itemAction;
	private Store storeByStoreFromFk;
	private ItemActionType itemActionType;
	private Store storeByStoreToFk;
	private Employee employee;
	private Item item;
	private Date actionDate;
	private Long itemCount;
	private BigDecimal actionPrice;
	private String actionNote;
	private Date created;

	public ItemAction() {
	}

	public ItemAction(long itemAction) {
		this.itemAction = itemAction;
	}

	public ItemAction(long itemAction, Store storeByStoreFromFk,
			ItemActionType itemActionType, Store storeByStoreToFk,
			Employee employee, Item item, Date actionDate, Long itemCount,
			BigDecimal actionPrice, String actionNote, Date created) {
		this.itemAction = itemAction;
		this.storeByStoreFromFk = storeByStoreFromFk;
		this.itemActionType = itemActionType;
		this.storeByStoreToFk = storeByStoreToFk;
		this.employee = employee;
		this.item = item;
		this.actionDate = actionDate;
		this.itemCount = itemCount;
		this.actionPrice = actionPrice;
		this.actionNote = actionNote;
		this.created = created;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "item_action", unique = true, nullable = false, precision = 10, scale = 0)
	public long getItemAction() {
		return this.itemAction;
	}

	public void setItemAction(long itemAction) {
		this.itemAction = itemAction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_from_fk")
	public Store getStoreByStoreFromFk() {
		return this.storeByStoreFromFk;
	}

	public void setStoreByStoreFromFk(Store storeByStoreFromFk) {
		this.storeByStoreFromFk = storeByStoreFromFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_action_type_fk")
	public ItemActionType getItemActionType() {
		return this.itemActionType;
	}

	public void setItemActionType(ItemActionType itemActionType) {
		this.itemActionType = itemActionType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_to_fk")
	public Store getStoreByStoreToFk() {
		return this.storeByStoreToFk;
	}

	public void setStoreByStoreToFk(Store storeByStoreToFk) {
		this.storeByStoreToFk = storeByStoreToFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_fk")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "action_date", length = 29)
	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Column(name = "item_count", precision = 10, scale = 0)
	public Long getItemCount() {
		return this.itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	@Column(name = "action_price", precision = 131089, scale = 0)
	public BigDecimal getActionPrice() {
		return this.actionPrice;
	}

	public void setActionPrice(BigDecimal actionPrice) {
		this.actionPrice = actionPrice;
	}

	@Column(name = "action_note")
	public String getActionNote() {
		return this.actionNote;
	}

	public void setActionNote(String actionNote) {
		this.actionNote = actionNote;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
