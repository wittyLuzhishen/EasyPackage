package com.luzhishen.easypackage.facade.entity;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class MailReceiver extends BaseJavaBean {
    private Integer id;
    private String name;
    private String email;
    private Integer defaultSent;

    public MailReceiver() {
    }

    public MailReceiver(Integer id, String name, String email,
            Integer defaultSent) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.defaultSent = defaultSent;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDefaultSent() {
        return defaultSent != null && defaultSent != 0;
    }

    public void setDefaultSent(Integer defaultSent) {
        this.defaultSent = defaultSent;
    }

}
