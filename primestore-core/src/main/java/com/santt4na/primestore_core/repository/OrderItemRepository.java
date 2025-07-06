package com.santt4na.primestore_core.repository;

import com.santt4na.primestore_core.entity.OrderItem;
import com.santt4na.primestore_core.entity.PK.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}