package com.swiftbeard.ecommerce_auth.repository;

import com.swiftbeard.ecommerce_auth.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {}
