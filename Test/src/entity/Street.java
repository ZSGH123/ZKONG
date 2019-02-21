package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="street")
public class Street {
	//�Զ�����ӳ�䣬ӳ�䵽�м�����hibernate���ͣ���ת�����ݿ���Ӧ��������
    private Integer sId;
    private String sName;
    private City city;
    //fetch=FetchType.EAGERΪ����ȥ��city
    //fetch=FetchType.LAZYΪ�ӳټ���city����Ҫ�Ŵ����ݿ���
    @ManyToOne(targetEntity=City.class,fetch=FetchType.LAZY)
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
	@SequenceGenerator(name = "STREETID", sequenceName = "STREETID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STREETID")
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
