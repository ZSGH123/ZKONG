package entity;
/**
 * 用户信息
 * @author 单杰
 * 创建时间：2019-01-13
 * 修改时间：
 * @Entity 
@Table(name = "XXGX_RBBTJ")
public class StatisticalDaily {
//	/** id */
//	@Id
//	@Column(name = "ID", unique = true, nullable = false)
//	@SequenceGenerator(name = "RBBTJ_SEQ", sequenceName = "RBBTJ_SEQ", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RBBTJ_SEQ")
//	private Integer id;
//	/** 查询日期 */
//	@Column(name = "QUERY_TIME")
//	private String queryTime;
//	/** 申请笔数 */
//	@Column(name = "APPLY_COUNT")
//	private Integer applyCount;
//	/** 成功笔数（总的 O） O=B+C+D */
//	@Column(name = "SUC_TOTAL_COUNT")
//	private Integer sucTotalCount;

// */
public class UserInfo {
	private String userId;//用户编号
	private String userPhoneNumber;//用户手机号
	private String userName;//用户名
	private String userPassword;//用户密码
	private String userRealName;//用户真实姓名
	private String userSex;//用户性别
	private String userIdCard;//用户身份证号
	private String userWeiboId;//微博用户编号
	private String userQQId;//QQ用户编号
	private String userIcon;//用户头像地址
	private String userAliPay;//支付宝账号
	private String userBankCard;//银行卡账号
	private String userRemark;//用户信息备注
	
	public String toString(){
		return "用户信息 [用户编号=" + userId + ",用户手机号=" + userPhoneNumber + ",用户名=" + userName + ",用户密码=" + userPassword 
				+ ",用户真实姓名=" + userRealName + ",用户性别=" + userSex + ",用户身份证号=" + userIdCard + ",微博用户编号=" + userWeiboId 
				+ ",QQ用户编号=" + userQQId + ",用户头像地址=" + userIcon + ",支付宝账号=" + userAliPay + ",银行卡账号=" + userBankCard + ",用户信息备注=" + userRemark + "]";
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
