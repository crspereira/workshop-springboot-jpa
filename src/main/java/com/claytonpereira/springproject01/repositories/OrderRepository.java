package com.claytonpereira.springproject01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claytonpereira.springproject01.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
