package ru.example.swagger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.example.swagger.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
