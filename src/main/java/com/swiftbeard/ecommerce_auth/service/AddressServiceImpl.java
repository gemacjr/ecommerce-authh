package com.swiftbeard.ecommerce_auth.service;

import com.swiftbeard.ecommerce_auth.entity.AddressEntity;
import com.swiftbeard.ecommerce_auth.exception.ResourceNotFoundException;
import com.swiftbeard.ecommerce_auth.model.AddAddressReq;
import com.swiftbeard.ecommerce_auth.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;

  public AddressServiceImpl(AddressRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq) {
    return Optional.of(repository.save(toEntity(addAddressReq)));
  }

  @Override
  public void deleteAddressesById(String id) {
    repository
        .findById(UUID.fromString(id))
        .orElseThrow(
            () -> new ResourceNotFoundException(String.format("No Address found with id %s.", id)));
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Optional<AddressEntity> getAddressesById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Iterable<AddressEntity> getAllAddresses() {
    return repository.findAll();
  }

  private AddressEntity toEntity(AddAddressReq model) {
    AddressEntity entity = new AddressEntity();
    return entity
        .setNumber(model.getNumber())
        .setResidency(model.getResidency())
        .setStreet(model.getStreet())
        .setCity(model.getCity())
        .setState(model.getState())
        .setCountry(model.getCountry())
        .setPincode(model.getPincode());
  }
}
