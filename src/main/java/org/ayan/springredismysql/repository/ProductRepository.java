package org.ayan.springredismysql.repository;

import org.ayan.springredismysql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}