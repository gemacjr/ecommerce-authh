package com.swiftbeard.ecommerce_auth.repository;


import com.swiftbeard.ecommerce_auth.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {}
