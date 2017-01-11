
package br.com.monitoratec.app.domain.entity;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private Integer id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("starred_url")
    private String starredUrl;
    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;
    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("repos_url")
    private String reposUrl;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("received_events_url")
    private String receivedEventsUrl;
    @SerializedName("type")
    private String type;
    @SerializedName("site_admin")
    private Boolean siteAdmin;
    @SerializedName("name")
    private String name;
    @SerializedName("company")
    private String company;
    @SerializedName("blog")
    private String blog;
    @SerializedName("location")
    private String location;
    @SerializedName("email")
    private String email;
    @SerializedName("hireable")
    private Boolean hireable;
    @SerializedName("bio")
    private String bio;
    @SerializedName("public_repos")
    private Integer publicRepos;
    @SerializedName("public_gists")
    private Integer publicGists;
    @SerializedName("followers")
    private Integer followers;
    @SerializedName("following")
    private Integer following;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("login")
    public String getLogin() {
        return login;
    }

    @SerializedName("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @SerializedName("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @SerializedName("gravatar_id")
    public String getGravatarId() {
        return gravatarId;
    }

    @SerializedName("gravatar_id")
    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    @SerializedName("url")
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @SerializedName("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @SerializedName("followers_url")
    public String getFollowersUrl() {
        return followersUrl;
    }

    @SerializedName("followers_url")
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    @SerializedName("following_url")
    public String getFollowingUrl() {
        return followingUrl;
    }

    @SerializedName("following_url")
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    @SerializedName("gists_url")
    public String getGistsUrl() {
        return gistsUrl;
    }

    @SerializedName("gists_url")
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    @SerializedName("starred_url")
    public String getStarredUrl() {
        return starredUrl;
    }

    @SerializedName("starred_url")
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    @SerializedName("subscriptions_url")
    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    @SerializedName("subscriptions_url")
    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    @SerializedName("organizations_url")
    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    @SerializedName("organizations_url")
    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    @SerializedName("repos_url")
    public String getReposUrl() {
        return reposUrl;
    }

    @SerializedName("repos_url")
    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    @SerializedName("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @SerializedName("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @SerializedName("received_events_url")
    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    @SerializedName("received_events_url")
    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    @SerializedName("type")
    public String getType() {
        return type;
    }

    @SerializedName("type")
    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("site_admin")
    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    @SerializedName("site_admin")
    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("company")
    public String getCompany() {
        return company;
    }

    @SerializedName("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @SerializedName("blog")
    public String getBlog() {
        return blog;
    }

    @SerializedName("blog")
    public void setBlog(String blog) {
        this.blog = blog;
    }

    @SerializedName("location")
    public String getLocation() {
        return location;
    }

    @SerializedName("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @SerializedName("email")
    public String getEmail() {
        return email;
    }

    @SerializedName("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("hireable")
    public Boolean getHireable() {
        return hireable;
    }

    @SerializedName("hireable")
    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }

    @SerializedName("bio")
    public String getBio() {
        return bio;
    }

    @SerializedName("bio")
    public void setBio(String bio) {
        this.bio = bio;
    }

    @SerializedName("public_repos")
    public Integer getPublicRepos() {
        return publicRepos;
    }

    @SerializedName("public_repos")
    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    @SerializedName("public_gists")
    public Integer getPublicGists() {
        return publicGists;
    }

    @SerializedName("public_gists")
    public void setPublicGists(Integer publicGists) {
        this.publicGists = publicGists;
    }

    @SerializedName("followers")
    public Integer getFollowers() {
        return followers;
    }

    @SerializedName("followers")
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @SerializedName("following")
    public Integer getFollowing() {
        return following;
    }

    @SerializedName("following")
    public void setFollowing(Integer following) {
        this.following = following;
    }

    @SerializedName("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @SerializedName("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @SerializedName("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @SerializedName("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
