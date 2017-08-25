package com.example.zj.hidemo;

import cn.bmob.v3.BmobUser;

/**
 * Created by ZJ on 2017/8/23.
 */

public class Friend extends BmobUser {
    private User user;
    private User friend;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
