package db;

// Generated 12.06.2012 19:50:00 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PriceListStatusType generated by hbm2java
 */
@Entity
@Table(name = "price_list_status_type")
public class PriceListStatusType implements java.io.Serializable {

	private long priceListStatusType;
	private String typeName;
	private Set<PriceList> priceLists = new HashSet<PriceList>(0);

	public PriceListStatusType() {
	}

	public PriceListStatusType(long priceListStatusType) {
		this.priceListStatusType = priceListStatusType;
	}

	public PriceListStatusType(long priceListStatusType, String typeName,
			Set<PriceList> priceLists) {
		this.priceListStatusType = priceListStatusType;
		this.typeName = typeName;
		this.priceLists = priceLists;
	}

	@Id
	@Column(name = "price_list_status_type", unique = true, nullable = false, precision = 10, scale = 0)
	public long getPriceListStatusType() {
		return this.priceListStatusType;
	}

	public void setPriceListStatusType(long priceListStatusType) {
		this.priceListStatusType = priceListStatusType;
	}

	@Column(name = "type_name", length = 200)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priceListStatusType")
	public Set<PriceList> getPriceLists() {
		return this.priceLists;
	}

	public void setPriceLists(Set<PriceList> priceLists) {
		this.priceLists = priceLists;
	}

}
