package com.luzhishen.easypackage.facade.entity;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class App extends BaseJavaBean {
    private Integer id;
    private String name;
    private String desc;
    private String projectDir;

    public App() {
    }

    public App(Integer id, String name, String desc, String projectDir) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.projectDir = projectDir;
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

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

}
