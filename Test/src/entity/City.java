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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="city")
public class City {
    private Integer cId;
    private String cName;
    private Set<Street> streets=new HashSet<Street>();
    
    @OneToMany(targetEntity=entity.Street.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="city")
	public Set<Street> getStreets() {
		return streets;
	}
	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}
	public City() {
		super();
	}
	public City(Integer cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	
	public City(Integer cId, String cName, Set<Street> streets) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.streets = streets;
	}
	@Id
	@Column(name = "CITYID",nullable = false)
	@SequenceGenerator(name = "CITYID", sequenceName = "CITYID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITYID")
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	@Column(name = "CITYNAME", unique = true)
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
    	
}
