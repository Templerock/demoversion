package com.example.demo.service;

import com.example.demo.model.jpa.Orders;
import com.example.demo.model.jpa.Services;
import com.example.demo.model.jpa.Users;

import java.util.List;


public interface OrdersService {

    Users addOrder(Users user, Orders order);

    Services acceptOrder(Services service, int idOrder);

    void deleteOrder(List<Orders> order);

    Orders getOrder(int id);

}
