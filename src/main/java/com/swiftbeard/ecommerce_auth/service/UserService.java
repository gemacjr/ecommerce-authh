package com.swiftbeard.ecommerce_auth.service;


import com.swiftbeard.ecommerce_auth.entity.AddressEntity;
import com.swiftbeard.ecommerce_auth.entity.CardEntity;
import com.swiftbeard.ecommerce_auth.entity.UserEntity;
import com.swiftbeard.ecommerce_auth.model.RefreshToken;
import com.swiftbeard.ecommerce_auth.model.SignedInUser;
import com.swiftbeard.ecommerce_auth.model.User;

import java.util.Optional;

public interface UserService {

  void deleteCustomerById(String id);

  Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);

  Iterable<UserEntity> getAllCustomers();

  Optional<CardEntity> getCardByCustomerId(String id);

  Optional<UserEntity> getCustomerById(String id);

  Optional<SignedInUser> createUser(User user);

  UserEntity findUserByUsername(String username);

  SignedInUser getSignedInUser(UserEntity userEntity);

  Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);

  void removeRefreshToken(RefreshToken refreshToken);
}
