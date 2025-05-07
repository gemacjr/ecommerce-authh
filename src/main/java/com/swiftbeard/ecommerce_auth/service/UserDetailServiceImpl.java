package com.swiftbeard.ecommerce_auth.service;

import com.swiftbeard.ecommerce_auth.entity.UserEntity;
import com.swiftbeard.ecommerce_auth.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  private UserRepository userRepo;

  public UserDetailServiceImpl(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (Strings.isBlank(username)) {
      throw new UsernameNotFoundException("Invalid user.");
    }
    final String uname = username.trim();
    Optional<UserEntity> oUserEntity = userRepo.findByUsername(uname);
    UserEntity userEntity =
        oUserEntity.orElseThrow(
            () -> new UsernameNotFoundException(String.format("Given user(%s) not found.", uname)));
    return User.builder()
        .username(userEntity.getUsername())
        .password(userEntity.getPassword())
        .authorities(userEntity.getRole().getAuthority())
        .build();
  }
}
