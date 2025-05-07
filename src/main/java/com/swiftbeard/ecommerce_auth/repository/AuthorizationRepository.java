package com.swiftbeard.ecommerce_auth.repository;


import com.swiftbeard.ecommerce_auth.entity.AuthorizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface AuthorizationRepository extends CrudRepository<AuthorizationEntity, UUID> {}
