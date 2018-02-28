package com.example.demo.dao;

import com.example.demo.model.jpa.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository  extends CrudRepository<Orders,Integer> {
}
