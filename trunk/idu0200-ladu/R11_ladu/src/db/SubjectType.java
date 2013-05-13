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
 * SubjectType generated by hbm2java
 */
@Entity
@Table(name = "subject_type")
public class SubjectType implements java.io.Serializable {

	private int subjectType;
	private String typeName;
	private Set<Contact> contacts = new HashSet<Contact>(0);
	private Set<SubjectAttributeType> subjectAttributeTypes = new HashSet<SubjectAttributeType>(
			0);
	private Set<UserAccount> userAccounts = new HashSet<UserAccount>(0);
	private Set<SubjectAttribute> subjectAttributes = new HashSet<SubjectAttribute>(
			0);
	private Set<Customer> customers = new HashSet<Customer>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	public SubjectType() {
	}

	public SubjectType(int subjectType) {
		this.subjectType = subjectType;
	}

	public SubjectType(int subjectType, String typeName, Set<Contact> contacts,
			Set<SubjectAttributeType> subjectAttributeTypes,
			Set<UserAccount> userAccounts,
			Set<SubjectAttribute> subjectAttributes, Set<Customer> customers,
			Set<Address> addresses) {
		this.subjectType = subjectType;
		this.typeName = typeName;
		this.contacts = contacts;
		this.subjectAttributeTypes = subjectAttributeTypes;
		this.userAccounts = userAccounts;
		this.subjectAttributes = subjectAttributes;
		this.customers = customers;
		this.addresses = addresses;
	}

	@Id
	@Column(name = "subject_type", unique = true, nullable = false)
	public int getSubjectType() {
		return this.subjectType;
	}

	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}

	@Column(name = "type_name", length = 200)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<SubjectAttributeType> getSubjectAttributeTypes() {
		return this.subjectAttributeTypes;
	}

	public void setSubjectAttributeTypes(
			Set<SubjectAttributeType> subjectAttributeTypes) {
		this.subjectAttributeTypes = subjectAttributeTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<UserAccount> getUserAccounts() {
		return this.userAccounts;
	}

	public void setUserAccounts(Set<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<SubjectAttribute> getSubjectAttributes() {
		return this.subjectAttributes;
	}

	public void setSubjectAttributes(Set<SubjectAttribute> subjectAttributes) {
		this.subjectAttributes = subjectAttributes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectType")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
