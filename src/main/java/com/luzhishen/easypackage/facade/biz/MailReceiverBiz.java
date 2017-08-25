package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.entity.MailReceiver;

@Service
public class MailReceiverBiz {

    public List<MailReceiver> findMailReceiverList() {
        List<MailReceiver> mailReceiverList = new ArrayList<>();
        mailReceiverList.add(new MailReceiver(1, "张三", "zhangsan@qq.com"));
        mailReceiverList.add(new MailReceiver(2, "李四", "lisi@qq.com"));
        mailReceiverList.add(new MailReceiver(3, "王五", "wangwu@qq.com"));
        return mailReceiverList;
	}

}