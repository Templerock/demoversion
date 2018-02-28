package com.example.demo.controller;

import com.example.demo.dao.OrdersRepository;
import com.example.demo.model.jpa.Orders;
import com.example.demo.model.jpa.Users;
import com.example.demo.service.OrdersService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping(value = "/added", method = RequestMethod.GET)
    public ModelAndView addUser(@RequestParam String name, @RequestParam String location, @RequestParam String car_brand){
        Map map = new HashMap();
        Users user = new Users(location, car_brand, name);
        usersService.addUser(user);
        map.put("name","Пользователь " + user.getName() + " успешно добавлен");
        return new ModelAndView("hello", map);
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validate(@RequestParam int id, Users user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_list");
        user = usersService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/add_order", method = RequestMethod.GET)
    public ModelAndView addOrder(@RequestParam int id, Users user, Orders order){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_list");
        user = ordersService.addOrder(usersService.getUser(id), order);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id, Users user){
        Map map = new HashMap();
        user = usersService.getUser(id);
        if (user.getOrders() == null){
            usersService.deleteUser(user);
        }   else {
            ordersRepository.delete(ordersService.getOrder());
        }
        map.put("name","Пользователь " + user.getName() + " успешно удален");
        return new ModelAndView("hello", map);
    }



}
