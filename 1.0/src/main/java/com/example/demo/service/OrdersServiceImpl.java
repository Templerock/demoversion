package com.example.demo.service;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.dao.ServicesRepository;
import com.example.demo.dao.UsersRepository;
import com.example.demo.model.jpa.Orders;
import com.example.demo.model.jpa.Services;
import com.example.demo.model.jpa.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ServicesRepository servicesRepository;


    @Override
    public Users addOrder(Users user, Orders order) {
        user.setOrderStatus("active");
        order.setOrderStatus("active");
        ordersRepository.save(order);
        return usersRepository.save(user);
    }

    @Override
    public Services acceptOrder(Services service, int idOrder) {
        List<Orders> listOrders = new LinkedList<Orders>();
        listOrders.add(ordersRepository.findOne(idOrder));
        service.setOrders(listOrders);
        return servicesRepository.save(service);
    }

    @Override
    public void deleteOrder(List<Orders> orders) {
        ordersRepository.delete(orders);
    }


    @Override
    public Orders getOrder(int id) {
        return ordersRepository.findOne(id);
    }
}
