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
 * EmployeeRoleType generated by hbm2java
 */
@Entity
@Table(name = "employee_role_type")
public class EmployeeRoleType implements java.io.Serializable {

	private int employeeRoleType;
	private String typeName;
	private Set<EmployeeRole> employeeRoles = new HashSet<EmployeeRole>(0);

	public EmployeeRoleType() {
	}

	public EmployeeRoleType(int employeeRoleType) {
		this.employeeRoleType = employeeRoleType;
	}

	public EmployeeRoleType(int employeeRoleType, String typeName,
			Set<EmployeeRole> employeeRoles) {
		this.employeeRoleType = employeeRoleType;
		this.typeName = typeName;
		this.employeeRoles = employeeRoles;
	}

	@Id
	@Column(name = "employee_role_type", unique = true, nullable = false)
	public int getEmployeeRoleType() {
		return this.employeeRoleType;
	}

	public void setEmployeeRoleType(int employeeRoleType) {
		this.employeeRoleType = employeeRoleType;
	}

	@Column(name = "type_name", length = 200)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeRoleType")
	public Set<EmployeeRole> getEmployeeRoles() {
		return this.employeeRoles;
	}

	public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}
