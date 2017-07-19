package com.gavin.community.common.entity;


public class User {
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

    /**
     * 用户所在省级ID
     */
    private String province;

    /**
     * 用户所在城市ID
     */
    private String city;
    /**
     * 用户个人描述
     */
    private String description;
    /**
     * 用户博客地址
     */
    private String site;
    /**
     * 用户的个性化背景(手机)
     */
    private String coverImage;
    /**
     * 用户的个性化域名
     */
    private String domain;
    /**
     * 性别，m：男、f：女、n：未知
     */
    private String gender;
    /**
     * 粉丝数
     */
    private String followersCount;
    /**
     * 关注数
     */
    private String followingsCount;
    /**
     * 帖子数
     */
    private String postsCount;
    /**
     * 文章数
     */
    private String articlesCount;
    /**
     * 评论数
     */
    private String commentsCount;
    /**
     * 收藏数
     */
    private String favouritesCount;

    /**

     * 用户创建（注册）时间
     */
    private String createdAt;
    /**
     * 用户经验值
     */
    private String exPoints;



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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
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

    public String getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(String followersCount) {
        this.followersCount = followersCount;
    }

    public String getFollowingsCount() {
        return followingsCount;
    }

    public void setFollowingsCount(String followingsCount) {
        this.followingsCount = followingsCount;
    }

    public String getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(String postsCount) {
        this.postsCount = postsCount;
    }

    public String getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(String articlesCount) {
        this.articlesCount = articlesCount;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(String favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getExPoints() {
        return exPoints;
    }

    public void setExPoints(String exPoints) {
        this.exPoints = exPoints;
    }

}
