package com.swiftbeard.ecommerce_auth.controller;

import com.swiftbeard.ecommerce_auth.AddressApi;
import com.swiftbeard.ecommerce_auth.entity.RoleEnum;
import com.swiftbeard.ecommerce_auth.hateoas.AddressRepresentationModelAssembler;
import com.swiftbeard.ecommerce_auth.model.AddAddressReq;
import com.swiftbeard.ecommerce_auth.model.Address;
import com.swiftbeard.ecommerce_auth.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class AddressController implements AddressApi {

  private final AddressRepresentationModelAssembler assembler;
  private AddressService service;

  public AddressController(
      AddressService addressService, AddressRepresentationModelAssembler assembler) {
    this.service = addressService;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Address> createAddress(@Valid AddAddressReq addAddressReq) {
    return status(HttpStatus.CREATED)
        .body(service.createAddress(addAddressReq).map(assembler::toModel).get());
  }

  @PreAuthorize("hasRole('" + RoleEnum.Const.ADMIN + "')")
  @Override
  public ResponseEntity<Void> deleteAddressesById(String id) {
    service.deleteAddressesById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<Address> getAddressesById(String id) {
    return service
        .getAddressesById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<Address>> getAllAddresses() {
    return ok(assembler.toListModel(service.getAllAddresses()));
  }
}
