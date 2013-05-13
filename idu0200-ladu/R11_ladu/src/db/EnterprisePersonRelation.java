package db;

// Generated 12.06.2012 19:50:00 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EnterprisePersonRelation generated by hbm2java
 */
@Entity
@Table(name = "enterprise_person_relation")
public class EnterprisePersonRelation implements java.io.Serializable {

	private int enterprisePersonRelation;
	private EntPerRelationType entPerRelationType;
	private Person person;
	private Enterprise enterprise;

	public EnterprisePersonRelation() {
	}

	public EnterprisePersonRelation(int enterprisePersonRelation) {
		this.enterprisePersonRelation = enterprisePersonRelation;
	}

	public EnterprisePersonRelation(int enterprisePersonRelation,
			EntPerRelationType entPerRelationType, Person person,
			Enterprise enterprise) {
		this.enterprisePersonRelation = enterprisePersonRelation;
		this.entPerRelationType = entPerRelationType;
		this.person = person;
		this.enterprise = enterprise;
	}

	@Id
	@Column(name = "enterprise_person_relation", unique = true, nullable = false)
	public int getEnterprisePersonRelation() {
		return this.enterprisePersonRelation;
	}

	public void setEnterprisePersonRelation(int enterprisePersonRelation) {
		this.enterprisePersonRelation = enterprisePersonRelation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ent_per_relation_type_fk")
	public EntPerRelationType getEntPerRelationType() {
		return this.entPerRelationType;
	}

	public void setEntPerRelationType(EntPerRelationType entPerRelationType) {
		this.entPerRelationType = entPerRelationType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_fk")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enterprise_fk")
	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}
