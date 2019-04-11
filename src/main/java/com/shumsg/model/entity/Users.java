package com.shumsg.model.entity;

import java.util.Date;

public class Users {
    private String id;

    private String registerWay;

    private String nickname;

    private Integer editableNicknameTimes;

    private Date lastModifyNicknameTime;

    private String studentCardId;

    private String password;

    private String actualName;

    private String department;

    private String phone;

    private String mail;

    private Date birthday;

    private String gender;

    private String about;

    private String location;

    private String school;

    private String job;

    private String identity;

    private Boolean invalid;

    private String avatar;

    private String background;

    private Integer consequentLoginDays;

    private Date lastLoginTime;

    private Short pushInterval;

    private Date lastPushTime;

    private Integer socialGroupNum;

    private Integer followingNum;

    private Integer followerNum;

    private Integer myGroupsNum;

    private Date createTime;

    private Date deleteTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay == null ? null : registerWay.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getEditableNicknameTimes() {
        return editableNicknameTimes;
    }

    public void setEditableNicknameTimes(Integer editableNicknameTimes) {
        this.editableNicknameTimes = editableNicknameTimes;
    }

    public Date getLastModifyNicknameTime() {
        return lastModifyNicknameTime;
    }

    public void setLastModifyNicknameTime(Date lastModifyNicknameTime) {
        this.lastModifyNicknameTime = lastModifyNicknameTime;
    }

    public String getStudentCardId() {
        return studentCardId;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId == null ? null : studentCardId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName == null ? null : actualName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    public Integer getConsequentLoginDays() {
        return consequentLoginDays;
    }

    public void setConsequentLoginDays(Integer consequentLoginDays) {
        this.consequentLoginDays = consequentLoginDays;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Short getPushInterval() {
        return pushInterval;
    }

    public void setPushInterval(Short pushInterval) {
        this.pushInterval = pushInterval;
    }

    public Date getLastPushTime() {
        return lastPushTime;
    }

    public void setLastPushTime(Date lastPushTime) {
        this.lastPushTime = lastPushTime;
    }

    public Integer getSocialGroupNum() {
        return socialGroupNum;
    }

    public void setSocialGroupNum(Integer socialGroupNum) {
        this.socialGroupNum = socialGroupNum;
    }

    public Integer getFollowingNum() {
        return followingNum;
    }

    public void setFollowingNum(Integer followingNum) {
        this.followingNum = followingNum;
    }

    public Integer getFollowerNum() {
        return followerNum;
    }

    public void setFollowerNum(Integer followerNum) {
        this.followerNum = followerNum;
    }

    public Integer getMyGroupsNum() {
        return myGroupsNum;
    }

    public void setMyGroupsNum(Integer myGroupsNum) {
        this.myGroupsNum = myGroupsNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}