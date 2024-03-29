package db;

// Generated 12.06.2012 19:50:00 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SubjectAttribute generated by hbm2java
 */
@Entity
@Table(name = "subject_attribute")
public class SubjectAttribute implements java.io.Serializable {

	private int subjectAttribute;
	private SubjectType subjectType;
	private SubjectAttributeType subjectAttributeType;
	private Integer subjectFk;
	private Integer orderby;
	private String valueText;
	private BigDecimal valueNumber;
	private Date valueDate;
	private Integer dataType;

	public SubjectAttribute() {
	}

	public SubjectAttribute(int subjectAttribute) {
		this.subjectAttribute = subjectAttribute;
	}

	public SubjectAttribute(int subjectAttribute, SubjectType subjectType,
			SubjectAttributeType subjectAttributeType, Integer subjectFk,
			Integer orderby, String valueText, BigDecimal valueNumber,
			Date valueDate, Integer dataType) {
		this.subjectAttribute = subjectAttribute;
		this.subjectType = subjectType;
		this.subjectAttributeType = subjectAttributeType;
		this.subjectFk = subjectFk;
		this.orderby = orderby;
		this.valueText = valueText;
		this.valueNumber = valueNumber;
		this.valueDate = valueDate;
		this.dataType = dataType;
	}

	@Id
	@Column(name = "subject_attribute", unique = true, nullable = false)
	public int getSubjectAttribute() {
		return this.subjectAttribute;
	}

	public void setSubjectAttribute(int subjectAttribute) {
		this.subjectAttribute = subjectAttribute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_type_fk")
	public SubjectType getSubjectType() {
		return this.subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_attribute_type_fk")
	public SubjectAttributeType getSubjectAttributeType() {
		return this.subjectAttributeType;
	}

	public void setSubjectAttributeType(
			SubjectAttributeType subjectAttributeType) {
		this.subjectAttributeType = subjectAttributeType;
	}

	@Column(name = "subject_fk")
	public Integer getSubjectFk() {
		return this.subjectFk;
	}

	public void setSubjectFk(Integer subjectFk) {
		this.subjectFk = subjectFk;
	}

	@Column(name = "orderby")
	public Integer getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	@Column(name = "value_text")
	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	@Column(name = "value_number", precision = 131089, scale = 0)
	public BigDecimal getValueNumber() {
		return this.valueNumber;
	}

	public void setValueNumber(BigDecimal valueNumber) {
		this.valueNumber = valueNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "value_date", length = 13)
	public Date getValueDate() {
		return this.valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	@Column(name = "data_type")
	public Integer getDataType() {
		return this.dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

}
