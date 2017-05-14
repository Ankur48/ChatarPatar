package com.example.ankur.ChatarPatar.cardstack.models;

/**
 * Created by etiennelawlor on 11/17/16.
 */
public class User {

    // region Member Variables
    private String avatarUrl;
    private String displayName;
    private String username;
    // endregion

    // region Constructors
    public User() {

    }
    // endregion

    // region Getters
    public String getAvatarUrl() {
        return avatarUrl;
    }

    // region Setters
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDisplayName() {
        return displayName;
    }
    // endregion

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    // endregion

}
