package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="project")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Project {
      private Integer pId;
      private String pName;
      private Set<Employee> employees=new HashSet<Employee>();
      
    @Id
  	@Column(name = "PROJECTID",nullable = false)
  	@SequenceGenerator(name = "PROJECTID", sequenceName = "PROJECTIDSEQ", allocationSize = 1)
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECTID")
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Column(name = "PROJECTNAME",nullable = false)
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	//工程为主导方
	@ManyToMany(targetEntity=Employee.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="pro_emp",joinColumns=@JoinColumn(referencedColumnName="PROJECTID",name="PROJECTID"),
	           inverseJoinColumns=@JoinColumn(referencedColumnName="EMPLOYEEID",name="EMPLOYEEID")
	           )
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Project(Integer pId, String pName, Set<Employee> employees) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.employees = employees;
	}
	public Project() {
		super();
	}
      
      
      
}
