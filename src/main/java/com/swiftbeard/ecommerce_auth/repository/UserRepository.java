package com.swiftbeard.ecommerce_auth.repository;

import com.swiftbeard.ecommerce_auth.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  Optional<UserEntity> findByUsername(String username);

  @Query(
      value =
          "select count(u.*) from ecomm.\"user\" u where u.username = :username or u.email = :email",
      nativeQuery = true)
  Integer findByUsernameOrEmail(String username, String email);
}
