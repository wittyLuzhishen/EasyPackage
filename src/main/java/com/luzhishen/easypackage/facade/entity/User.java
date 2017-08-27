package com.luzhishen.easypackage.facade.entity;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class User extends BaseJavaBean {
    private Integer id;
    private String loginName;
    private String name;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
