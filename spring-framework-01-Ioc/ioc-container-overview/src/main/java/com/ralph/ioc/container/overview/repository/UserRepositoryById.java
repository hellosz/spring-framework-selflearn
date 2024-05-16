package com.ralph.ioc.container.overview.repository;

import com.ralph.ioc.container.overview.domain.User;

import java.util.List;

/**
 * 用户仓库
 */
public class UserRepositoryById {
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
