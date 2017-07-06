package com.gavin.community.common.entity;



public class User {

    /**
     * 用户ID（int64）
     */
    public String id;

    /**
     * 用户昵称
     */
    public String name;

    /**
     * 用户头像
     */
    public String avatar;

    /**
     * 用户所在省级ID
     */
    public int province;

    /**
     * 用户所在城市ID
     */
    public int city;
    /**
     * 用户所在地
     */
    public String location;
    /**
     * 用户个人描述
     */
    public String description;
    /**
     * 用户博客地址
     */
    public String url;
    /**
     * 用户的个性化背景(手机)
     */
    public String cover_image;
    /**
     * 用户的个性化域名
     */
    public String domain;
    /**
     * 性别，m：男、f：女、n：未知
     */
    public String gender;
    /**
     * 粉丝数
     */
    public int followers_count;
    /**
     * 关注数
     */
    public int followings_count;
    /**
     * 帖子数
     */
    public int posts_count;
    /**
     * 文章数
     */
    public int articles_count;
    /**
     * 评论数
     */
    public int comments_count;
    /**
     * 收藏数
     */
    public int favourites_count;
    /**
     * 用户创建（注册）时间
     */
    public String created_at;
    /**
     * 用户经验值
     */
    public String ex_points;



}
