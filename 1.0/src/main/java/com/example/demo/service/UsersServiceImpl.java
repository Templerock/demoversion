package com.example.demo.service;

import com.example.demo.dao.UsersRepository;
import com.example.demo.model.jpa.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }

    @Override
    public Users getUser(int id) {
        return usersRepository.findOne(id);
    }

}
