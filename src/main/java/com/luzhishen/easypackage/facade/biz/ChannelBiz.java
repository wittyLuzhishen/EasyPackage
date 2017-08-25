package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.entity.Channel;

@Service
public class ChannelBiz {

    public List<Channel> findChannelList(int appId) {
        List<Channel> channelList = new ArrayList<>();
        channelList.add(new Channel(1, "DEBUG", ""));
        channelList.add(new Channel(2, "RELEASE", ""));
        channelList.add(new Channel(3, "channel_test", "测试渠道"));
        return channelList;
	}

}
