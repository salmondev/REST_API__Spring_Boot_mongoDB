package com.example.angapi.controller;

import com.example.angapi.model.Products;
import com.example.angapi.repositories.ProductRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	/*
	 * private MongoTemplate mongoTemplate;
	 * 
	 * @Autowired public ProductController(MongoTemplate mongoTemplate) {
	 * this.mongoTemplate = mongoTemplate; }
	 */

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Products> getAllProduct() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Products getProductById(@PathVariable("id") ObjectId id) {
		return repository.findByid(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyProductById(@PathVariable("id") ObjectId id, @Valid @RequestBody Products Product) {
		Product.setid(id);
		repository.save(Product);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Products createProduct(@Valid @RequestBody Products Product) {
		Product.setid(ObjectId.get());
		repository.save(Product);
		return Product;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable ObjectId id) {
		repository.delete(repository.findByid(id));
	}
}
