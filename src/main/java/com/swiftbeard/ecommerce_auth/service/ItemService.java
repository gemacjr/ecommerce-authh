package com.swiftbeard.ecommerce_auth.service;

import com.swiftbeard.ecommerce_auth.entity.ItemEntity;
import com.swiftbeard.ecommerce_auth.model.Item;

import java.util.List;

public interface ItemService {

  ItemEntity toEntity(Item m);

  List<ItemEntity> toEntityList(List<Item> items);

  Item toModel(ItemEntity e);

  List<Item> toModelList(List<ItemEntity> items);
}
