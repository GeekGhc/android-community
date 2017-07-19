package com.gavin.community.mvp.model.bean;

/**
 * Created by Administrator on 2017/7/19.
 */

public class UserBean {
    /**
     * 用户ID（int64）
     */
    private String id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户头像
     */
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



}
