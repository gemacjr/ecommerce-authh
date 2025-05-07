package com.swiftbeard.ecommerce_auth.repository;

import com.swiftbeard.ecommerce_auth.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {}
