package com.claytonpereira.springproject01.repositories;

import com.claytonpereira.springproject01.entities.OrderItem;
import com.claytonpereira.springproject01.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
