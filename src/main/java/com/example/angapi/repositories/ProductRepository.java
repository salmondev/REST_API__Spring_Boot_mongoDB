package com.example.angapi.repositories;

import com.example.angapi.model.Products;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {
	Products findByid(ObjectId id);
}
