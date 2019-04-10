package com.shumsg.model.entity;

import java.util.Date;

public class UserSubscribeLabel {
    private Object id;

    private Object userId;

    private Object labelId;

    private Boolean needSendMsg;

    private Date createTime;

    private Date deleteTime;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getLabelId() {
        return labelId;
    }

    public void setLabelId(Object labelId) {
        this.labelId = labelId;
    }

    public Boolean getNeedSendMsg() {
        return needSendMsg;
    }

    public void setNeedSendMsg(Boolean needSendMsg) {
        this.needSendMsg = needSendMsg;
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