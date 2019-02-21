package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
    private Integer cId;
    private String cName;
    
	public City() {
		super();
	}
	public City(Integer cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	
	@Id
	@Column(name = "CITY_ID",nullable = false)
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	@Column(name = "CITY_NAME", unique = true)
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
    	
}
