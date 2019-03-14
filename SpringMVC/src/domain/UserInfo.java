package domain;

import java.util.Date;

public class UserInfo {
    /**
     * ����id
     */
    private Integer id;
    /**
     * �û�id
     */
     private String userId;
    /**
     * �û���
     */
    private String userName;
    /**
     * �û�����
     */
     private String userPassword;
    /**
     * �û���ʵ����
     */
    private String userRealName;
    /**
     * �û�����
     */
     private Date userBirthday;
    /**
     * �û���ע
     */
    private  String note;

    public UserInfo() {
    }

    public UserInfo(Integer id,String userId, String userName, String userPassword, String userRealName, Date userBirthday, String note) {
        this.id=id;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealName = userRealName;
        this.userBirthday = userBirthday;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
