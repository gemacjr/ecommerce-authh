package com.swiftbeard.ecommerce_auth.controller;

import com.swiftbeard.ecommerce_auth.PaymentApi;
import com.swiftbeard.ecommerce_auth.hateoas.PaymentRepresentationModelAssembler;
import com.swiftbeard.ecommerce_auth.model.Authorization;
import com.swiftbeard.ecommerce_auth.model.PaymentReq;
import com.swiftbeard.ecommerce_auth.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController implements PaymentApi {

  private final PaymentService service;
  private final PaymentRepresentationModelAssembler assembler;

  public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Authorization> authorize(@Valid PaymentReq paymentReq) {
    return null;
  }

  @Override
  public ResponseEntity<Authorization> getOrdersPaymentAuthorization(@NotNull @Valid String id) {
    return null;
  }
}
