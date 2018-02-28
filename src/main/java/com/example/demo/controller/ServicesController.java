package com.example.demo.controller;

import com.example.demo.model.jpa.Orders;
import com.example.demo.model.jpa.Services;
import com.example.demo.service.OrdersService;
import com.example.demo.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/added", method = RequestMethod.GET)
    public ModelAndView addUser(@RequestParam String name, @RequestParam String location){
        Map map = new HashMap();
        Services service = new Services(name, location);
        servicesService.addService(service);
        map.put("name","Сервис " + service.getName() + " успешно добавлен");
        return new ModelAndView("hello", map);
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validate(@RequestParam int id, Services service){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("service_list");
        service = servicesService.getService(id);
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @RequestMapping(value = "/accept_order", method = RequestMethod.GET)
    public ModelAndView addOrder(@RequestParam int id, @RequestParam int idor, Services service, Orders order){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("service_list");
        service = ordersService.acceptOrder(servicesService.getService(id), idor);
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id, Services service){
        Map map = new HashMap();
        service = servicesService.getService(id);
        if (service.getOrders() == null){
            servicesService.deleteService(service);
        }   else {
            servicesService.deleteService(service);
        }
        map.put("name","Сервис " + service.getName() + " успешно удален");
        return new ModelAndView("hello", map);
    }
}
