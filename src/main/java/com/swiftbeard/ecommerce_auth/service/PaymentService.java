package com.swiftbeard.ecommerce_auth.service;

import com.swiftbeard.ecommerce_auth.entity.AuthorizationEntity;
import com.swiftbeard.ecommerce_auth.model.PaymentReq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface PaymentService {

  Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);

  Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
