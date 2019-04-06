package com.shu.message.model.entity;

public class User {
    private String userId;

    private String userName;

    private String password;

    private String phone;

    private String mail;

    private String bigImg;

    private String img;

    private String department;

    private Integer followMe;

    private Integer followOthers;

    private Integer joinGroupNum;

    private Integer concernGroup;

    private String personalLabel;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg == null ? null : bigImg.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getFollowMe() {
        return followMe;
    }

    public void setFollowMe(Integer followMe) {
        this.followMe = followMe;
    }

    public Integer getFollowOthers() {
        return followOthers;
    }

    public void setFollowOthers(Integer followOthers) {
        this.followOthers = followOthers;
    }

    public Integer getJoinGroupNum() {
        return joinGroupNum;
    }

    public void setJoinGroupNum(Integer joinGroupNum) {
        this.joinGroupNum = joinGroupNum;
    }

    public Integer getConcernGroup() {
        return concernGroup;
    }

    public void setConcernGroup(Integer concernGroup) {
        this.concernGroup = concernGroup;
    }

    public String getPersonalLabel() {
        return personalLabel;
    }

    public void setPersonalLabel(String personalLabel) {
        this.personalLabel = personalLabel == null ? null : personalLabel.trim();
    }
}