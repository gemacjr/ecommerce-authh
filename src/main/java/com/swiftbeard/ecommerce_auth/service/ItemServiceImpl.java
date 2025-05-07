package com.swiftbeard.ecommerce_auth.service;

import com.swiftbeard.ecommerce_auth.entity.ItemEntity;
import com.swiftbeard.ecommerce_auth.entity.ProductEntity;
import com.swiftbeard.ecommerce_auth.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class ItemServiceImpl implements ItemService {

  @Override
  public ItemEntity toEntity(Item m) {
    ItemEntity e = new ItemEntity();
    e.setProduct(new ProductEntity().setId(UUID.fromString(m.getId())))
        .setPrice(m.getUnitPrice())
        .setQuantity(m.getQuantity());
    return e;
  }

  @Override
  public List<ItemEntity> toEntityList(List<Item> items) {
    if (Objects.isNull(items)) {
      return List.of();
    }
    return items.stream().map(this::toEntity).collect(toList());
  }

  @Override
  public Item toModel(ItemEntity e) {
    Item m = new Item();
    m.id(e.getProduct().getId().toString())
        .unitPrice(e.getPrice())
        .quantity(e.getQuantity())
        .description(e.getProduct().getDescription())
        .name(e.getProduct().getName())
        .imageUrl(e.getProduct().getImageUrl());
    return m;
  }

  @Override
  public List<Item> toModelList(List<ItemEntity> items) {
    if (Objects.isNull(items)) {
      return List.of();
    }
    return items.stream().map(this::toModel).collect(toList());
  }
}
