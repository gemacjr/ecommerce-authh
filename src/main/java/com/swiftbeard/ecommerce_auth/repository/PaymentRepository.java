package com.swiftbeard.ecommerce_auth.repository;

import com.swiftbeard.ecommerce_auth.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {}
