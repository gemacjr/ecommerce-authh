package com.swiftbeard.ecommerce_auth.controller;

import com.swiftbeard.ecommerce_auth.ProductApi;
import com.swiftbeard.ecommerce_auth.hateoas.ProductRepresentationModelAssembler;
import com.swiftbeard.ecommerce_auth.model.Product;
import com.swiftbeard.ecommerce_auth.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ProductController implements ProductApi {

  private final ProductService service;
  private final ProductRepresentationModelAssembler assembler;

  public ProductController(ProductService service, ProductRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Product> getProduct(String id) {
    return service
        .getProduct(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<Product>> queryProducts(
      @Valid String tag, @Valid String name, @Valid Integer page, @Valid Integer size) {
    return ok(assembler.toListModel(service.getAllProducts()));
  }
}
