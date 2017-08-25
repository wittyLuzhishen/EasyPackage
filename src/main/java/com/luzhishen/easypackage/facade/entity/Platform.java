package com.luzhishen.easypackage.facade.entity;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class Platform extends BaseJavaBean {
    private Integer id;
    private String name;
    private String desc;
    private Integer packageToolType;

    public Platform() {
    }

    public Platform(Integer id, String name, String desc,
            Integer packageToolType) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.packageToolType = packageToolType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPackageToolType() {
        return packageToolType;
    }

    public void setPackageToolType(Integer packageToolType) {
        this.packageToolType = packageToolType;
    }

}
