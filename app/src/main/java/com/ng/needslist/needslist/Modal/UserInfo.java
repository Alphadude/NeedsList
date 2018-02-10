package com.ng.needslist.needslist.Modal;

/**
 * Created by user on 1/26/2018.
 */

public class UserInfo {
    private String url,name,device_token;

    public UserInfo() {
    }

    public UserInfo(String url, String name, String device_token) {
        this.url = url;
        this.name = name;
        this.device_token = device_token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }
}
