package com.example.demo.service;

import com.example.demo.model.jpa.Services;

public interface ServicesService {

    Services addService(Services service);

    void deleteService(Services service);

    Services getService(int id);
}
