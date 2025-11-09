package com.figmonie.services;


import com.figmonie.data.models.User;


public interface UserService {

    User findByUsername(String username);
}
