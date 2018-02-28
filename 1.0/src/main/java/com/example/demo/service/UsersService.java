package com.example.demo.service;

import com.example.demo.model.jpa.Users;

public interface UsersService {

    Users addUser(Users user);

    void deleteUser(Users user);

    Users getUser(int id);
}
