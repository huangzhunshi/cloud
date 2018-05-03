package com.zuul.bootc.elasticsearch;

import com.netflix.discovery.provider.Serializer;
import io.searchbox.annotations.JestId;

@Serializer
public class User{
    @JestId
    private Integer userId;

    private String userName;




    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
