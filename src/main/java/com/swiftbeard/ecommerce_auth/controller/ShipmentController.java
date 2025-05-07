package com.swiftbeard.ecommerce_auth.controller;

import com.swiftbeard.ecommerce_auth.ShipmentApi;
import com.swiftbeard.ecommerce_auth.hateoas.ShipmentRepresentationModelAssembler;
import com.swiftbeard.ecommerce_auth.model.Shipment;
import com.swiftbeard.ecommerce_auth.service.ShipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController implements ShipmentApi {

  private final ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(
      ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<Shipment>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
