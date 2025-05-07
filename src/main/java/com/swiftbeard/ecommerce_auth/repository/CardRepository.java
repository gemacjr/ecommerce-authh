package com.swiftbeard.ecommerce_auth.repository;


import com.swiftbeard.ecommerce_auth.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface CardRepository extends CrudRepository<CardEntity, UUID> {}
