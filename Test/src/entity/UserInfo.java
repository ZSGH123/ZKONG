package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * �û���Ϣ
 * @author ����
 * ����ʱ�䣺2019-01-13
 * �޸�ʱ�䣺
 * @Entity 
@Table(name = "XXGX_RBBTJ")
public class StatisticalDaily {
//	/** id */
//	@Id
//	@Column(name = "ID", unique = true, nullable = false)
//	@SequenceGenerator(name = "RBBTJ_SEQ", sequenceName = "RBBTJ_SEQ", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RBBTJ_SEQ")
//	private Integer id;
//	/** ��ѯ���� */
//	@Column(name = "QUERY_TIME")
//	private String queryTime;
//	/** ������� */
//	@Column(name = "APPLY_COUNT")
//	private Integer applyCount;
//	/** �ɹ��������ܵ� O�� O=B+C+D */
//	@Column(name = "SUC_TOTAL_COUNT")
//	private Integer sucTotalCount;

// */
@Entity
@Table(name="USER_INFO")
public class UserInfo {
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	@SequenceGenerator(name = "USERID", sequenceName = "USERID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERID")
	private String userId;//�û����
	@Column(name = "USER_PHONENUMBER")
	private String userPhoneNumber;//�û��ֻ���
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String userName;//�û���
	@Column(name = "USER_Password", nullable = false)
	private String userPassword;//�û�����
	@Column(name = "USER_REALNAME")
	private String userRealName;//�û���ʵ����
	@Column(name = "USER_SEX")
	private String userSex;//�û��Ա�
	@Column(name = "USER_IDCARD")
	private String userIdCard;//�û�����֤��
	@Column(name = "USER_WEIBO_ID")
	private String userWeiboId;//΢���û����
	@Column(name = "USER_QQ_ID")
	private String userQQId;//QQ�û����
	@Column(name = "USER_ICON")
	private String userIcon;//�û�ͷ���ַ
	@Column(name = "USER_ALIPAY")
	private String userAliPay;//֧�����˺�
	@Column(name = "USER_BANK_CARD")
	private String userBankCard;//���п��˺�
	@Column(name = "USER_REMARK")
	private String userRemark;//�û���Ϣ��ע
	
	public String toString(){
		return "�û���Ϣ [�û����=" + userId + ",�û��ֻ���=" + userPhoneNumber + ",�û���=" + userName + ",�û�����=" + userPassword 
				+ ",�û���ʵ����=" + userRealName + ",�û��Ա�=" + userSex + ",�û�����֤��=" + userIdCard + ",΢���û����=" + userWeiboId 
				+ ",QQ�û����=" + userQQId + ",�û�ͷ���ַ=" + userIcon + ",֧�����˺�=" + userAliPay + ",���п��˺�=" + userBankCard + ",�û���Ϣ��ע=" + userRemark + "]";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getUserWeiboId() {
		return userWeiboId;
	}
	public void setUserWeiboId(String userWeiboId) {
		this.userWeiboId = userWeiboId;
	}
	public String getUserQQId() {
		return userQQId;
	}
	public void setUserQQId(String userQQId) {
		this.userQQId = userQQId;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public String getUserAliPay() {
		return userAliPay;
	}
	public void setUserAliPay(String userAliPay) {
		this.userAliPay = userAliPay;
	}
	public String getUserBankCard() {
		return userBankCard;
	}
	public void setUserBankCard(String userBankCard) {
		this.userBankCard = userBankCard;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	
}