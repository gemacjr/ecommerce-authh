package com.swiftbeard.ecommerce_auth.repository;

import com.swiftbeard.ecommerce_auth.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {}
