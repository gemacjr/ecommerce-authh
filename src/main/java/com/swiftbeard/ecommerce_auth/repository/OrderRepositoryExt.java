package com.swiftbeard.ecommerce_auth.repository;


import com.swiftbeard.ecommerce_auth.entity.OrderEntity;
import com.swiftbeard.ecommerce_auth.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
  Optional<OrderEntity> insert(NewOrder m);
}
