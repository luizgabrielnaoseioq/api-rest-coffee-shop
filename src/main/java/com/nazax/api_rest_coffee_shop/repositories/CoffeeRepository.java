package com.nazax.api_rest_coffee_shop.repositories;

import com.nazax.api_rest_coffee_shop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
