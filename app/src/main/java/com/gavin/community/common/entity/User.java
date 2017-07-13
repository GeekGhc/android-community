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
    public String province;

    /**
     * 用户所在城市ID
     */
    public String city;
    /**
     * 用户个人描述
     */
    public String description;
    /**
     * 用户博客地址
     */
    public String site;
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
    public String followers_count;
    /**
     * 关注数
     */
    public String followings_count;
    /**
     * 帖子数
     */
    public String posts_count;
    /**
     * 文章数
     */
    public String articles_count;
    /**
     * 评论数
     */
    public String comments_count;
    /**
     * 收藏数
     */
    public String favourites_count;
    /**
     * 用户创建（注册）时间
     */
    public String created_at;
    /**
     * 用户经验值
     */
    public String ex_points;


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }

    public void setSite(String site){
        this.site = site;
    }
    public String getSite(){
        return this.site;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setExPoints(String ex_points){
        this.ex_points = ex_points;
    }
    public String getExPoints(){
        return this.ex_points;
    }

}
