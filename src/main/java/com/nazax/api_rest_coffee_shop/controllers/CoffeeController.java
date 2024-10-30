package com.nazax.api_rest_coffee_shop.controllers;

import com.nazax.api_rest_coffee_shop.models.Coffee;
import com.nazax.api_rest_coffee_shop.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }
    @PostMapping(value = "/createCofee" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee createCoffee(@RequestBody Coffee coffee){

            Coffee createCoffee = new Coffee();

            createCoffee.setName(coffee.getName());
            createCoffee.setPrice(coffee.getPrice());

            return coffeeRepository.save(createCoffee);
    }

    @PutMapping(value = "updatedCoffee" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updatedCoffe(@RequestBody Coffee coffee){
        Coffee getCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();

        Coffee updateCoffee = new Coffee();
        updateCoffee.setId(coffee.getId());
        updateCoffee.setName(coffee.getName());
        updateCoffee.setPrice(coffee.getPrice());

        return coffeeRepository.save(updateCoffee);
    }

    @DeleteMapping(value = "deletedCoffee/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee deleteCoffee(@PathVariable Long id){
        Coffee getCoffee = coffeeRepository.findById(id).orElseThrow();
        coffeeRepository.delete(getCoffee);
        return getCoffee;
    }


}