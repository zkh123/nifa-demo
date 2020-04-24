package com.sdkbackendpr.entity;

import java.util.Date;

public class UserInfo {
    private Long userId;
    private String userName;
    private String account;
    private String password;
    private boolean isActive;
    private Date insertTime;
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
