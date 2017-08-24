package com.luzhishen.easypackage.facade.entity;

public class App {
    private Integer id;
    private String name;
    private String desc;
    private String projectPath;

    public App(Integer id, String name, String desc, String projectPath) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.projectPath = projectPath;
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

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    @Override
    public String toString() {
        return "App [id=" + id + ", name=" + name + ", desc=" + desc
                + ", projectPath=" + projectPath + "]";
    }

}
