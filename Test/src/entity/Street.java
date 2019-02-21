package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="street")
public class Street {
	//自动类型映射，映射到中间类型hibernate类型，再转到数据库相应数据类型
    private Integer sId;
    private String sName;
    private City city;
    
    @ManyToOne(targetEntity=entity.City.class)
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Street() {
		super();
	}
	public Street(Integer sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}
	
	
	public Street(Integer sId, String sName, City city) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.city = city;
	}
	@Id
	@Column(name = "STREET_ID")
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	@Column(name = "STREET_NAME")
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
    
    
}
