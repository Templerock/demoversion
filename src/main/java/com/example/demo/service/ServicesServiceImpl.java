package com.example.demo.service;

import com.example.demo.dao.ServicesRepository;
import com.example.demo.model.jpa.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public Services addService(Services service) {
        return servicesRepository.save(service);
    }

    @Override
    public void deleteService(Services service) {
        servicesRepository.delete(service);
    }

    @Override
    public Services getService(int id) {
        return servicesRepository.findOne(id);
    }
}
