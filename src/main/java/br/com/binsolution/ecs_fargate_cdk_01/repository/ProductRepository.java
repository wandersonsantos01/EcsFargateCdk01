package br.com.binsolution.ecs_fargate_cdk_01.repository;

import br.com.binsolution.ecs_fargate_cdk_01.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByCode(String code);

}
