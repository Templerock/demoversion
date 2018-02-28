package com.example.demo.controller;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.dao.UsersRepository;
import com.example.demo.model.jpa.Orders;
import com.example.demo.model.jpa.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class ApiController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/users")
    public String getUs(){
        String result = "";
        for(Users user : usersRepository.findAll()){
            result += user.toString() + "<br>";
        }
        return result;
    }

    @GetMapping("/orders")
    public String getOr(){
        String result = "";
        for(Orders order : ordersRepository.findAll()){
            result += order.toString() + "<br>";
        }
        return result;
    }


    /*@GetMapping("/orders")
    public Iterable<Orders> getOrders(){
        return ordersRepository.findAll();
    }

    //@GetMapping("/users")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }*/



}
