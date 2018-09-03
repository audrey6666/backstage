package com.finup.modules.datapi.entity;

import com.finup.modules.datapi.enums.ThirdSourceEnum;

import java.io.Serializable;
import java.util.Date;

public class ThirdSourceEntity implements Serializable{

    private Long id;

    private String creditType;

    private String thirdSource;

    private String thirdSourceStr;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getThirdSource() {
        return thirdSource;
    }

    public void setThirdSource(String thirdSource) {
        this.thirdSource = thirdSource;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getThirdSourceStr() {
        if(thirdSource!=null && thirdSourceStr==null){
            thirdSourceStr=ThirdSourceEnum.getDescByCode(thirdSource);
        }
        return thirdSourceStr;
    }

    public void setThirdSourceStr(String thirdSourceStr) {
        this.thirdSourceStr = thirdSourceStr;
    }
}
