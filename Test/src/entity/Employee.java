package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Employee {
     private Integer eId;
     private String eName;
     private Set<Project> projects=new HashSet<Project>();
     
    @Id
   	@Column(name = "EMPLOYEEID",nullable = false)
   	@SequenceGenerator(name = "EMPLOYEEID", sequenceName = "EMPLOYEEIDSEQ", allocationSize = 1)
   	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEEID")
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	
	@Column(name = "EMPLOYEENAME",nullable = false)
	public String geteName() {
		return eName;
	}
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	@ManyToMany(targetEntity=Project.class,mappedBy="employees")
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Employee(Integer eId, String eName, Set<Project> projects) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.projects = projects;
	}
	public Employee() {
		super();
	}
     
     
     
}
