package com.luzhishen.easypackage.facade.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class BaseJavaBean {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
