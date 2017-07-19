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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getFollowings_count() {
        return followings_count;
    }

    public void setFollowings_count(String followings_count) {
        this.followings_count = followings_count;
    }

    public String getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(String posts_count) {
        this.posts_count = posts_count;
    }

    public String getArticles_count() {
        return articles_count;
    }

    public void setArticles_count(String articles_count) {
        this.articles_count = articles_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(String favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEx_points() {
        return ex_points;
    }

    public void setEx_points(String ex_points) {
        this.ex_points = ex_points;
    }

}
